package wordtojsp;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

	public class ToWord {
		private static final String ENCODING = "ISO-8859-1";// UTF-8

		public static String wordToHtml(String sourcePath, final String picturesPath,String targetPath){
			String ext = FileUtils.GetFileExt(sourcePath);
			File picturesDir = new File(picturesPath);
			if (!picturesDir.isDirectory()) {
				picturesDir.mkdirs();
			}
			String content = null;
			try {
				if (ext.equals("doc")) {
					HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourcePath));
					WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
							DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
					wordToHtmlConverter.setPicturesManager(new PicturesManager() {
						public String savePicture(byte[] content, PictureType pictureType, String suggestedName,
								float widthInches, float heightInches) {
							File file = new File(picturesPath + "\\" + suggestedName);
							FileOutputStream fos = null;
							try {
								fos = new FileOutputStream(file);
								fos.write(content);
								fos.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
							return "http://localhost:8081/qqmail/file/fileimg/" + suggestedName;
						}
					});
					wordToHtmlConverter.processDocument(wordDocument);
					Document htmlDocument = wordToHtmlConverter.getDocument();
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					DOMSource domSource = new DOMSource(htmlDocument);
					StreamResult streamResult = new StreamResult(out);

					TransformerFactory tf = TransformerFactory.newInstance();
					Transformer serializer = tf.newTransformer();
					serializer.setOutputProperty(OutputKeys.ENCODING, ENCODING);
					serializer.setOutputProperty(OutputKeys.INDENT, "yes");
					serializer.setOutputProperty(OutputKeys.METHOD, "html");
					serializer.transform(domSource, streamResult);
					out.close();
					FileUtils.writeFile(new String(out.toByteArray()), targetPath);
					content = out.toString();
				} else if (ext.equals("docx")) {
					// 1) 加载word文档生成 XWPFDocument对象
					InputStream in = new FileInputStream(new File(sourcePath));
					XWPFDocument document = new XWPFDocument(in);
					// 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
					XHTMLOptions options = XHTMLOptions.create();
					options.setExtractor(new FileImageExtractor(picturesDir));
					//options.URIResolver(new BasicURIResolver(picturesPath));
					options.URIResolver(new BasicURIResolver("/qqmail/file/fileimg/"));//设置jsp的文件路径千万不要为本地地址如D://要改成服务器的地址
					// 3) 将 XWPFDocument转换成XHTML
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					XHTMLConverter.getInstance().convert(document, baos, options);
					baos.close();
					content = baos.toString();
					FileUtils.writeFile(content, targetPath);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return content;
		}
}
