package qqmail.entry;

public class Notepaper {
	private int notepaper_id;
	private String notepaper_img;


	public int getNotepaper_id(){
		return this.notepaper_id;
	}
	
	public void setNotepaper_id(int notepaper_id){
		this.notepaper_id = notepaper_id;
	}

	public String getNotepaper_img() {
		return notepaper_img;
	}

	public void setNotepaper_img(String notepaper_img) {
		this.notepaper_img = notepaper_img;
	}

	@Override
	public String toString() {
		return "Notepaper [notepaper_id=" + notepaper_id + ", notepaper_img="
				+ notepaper_img + "]";
	}
	
	
}
