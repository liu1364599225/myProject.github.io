package com.music.service;

import java.util.List;

import com.music.entity.Song;
import com.music.entity.SongDetails;

public interface SongService {
    int deleteByPrimaryKey(Integer songId);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Integer songId);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);
    
    /**
     * @author 刘波
     * @param selectBySingerId() 通过歌手id查询对应歌手歌曲
     */
    List<Song> selectBySingerId(Integer singerId);
    
    /**
     * 通过专辑编号查询所有歌曲
     * @param specialId 专辑编号
     * @return 一个歌曲集合
     */
	List<Song> findBySpecialId(Integer specialId);
	
	/**
	 * 通过歌曲id查询歌曲具体详情
     * @param songId 歌曲编号
     * @return 一个歌曲详情对象
	 */
	SongDetails selectDetails(Integer songId);
}