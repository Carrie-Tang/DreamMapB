package com.dreammap.ws.service.data;

import com.dreammap.ws.bean.DmFavor;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Lenovo on 2017/5/13.
 */
public interface DmFavorDataService {
    @Insert("INSERT INTO dm_favor (userId,sceneryId) VALUES (#{dmFavor.userId},#{dmFavor.sceneryId})")
    @Options(useGeneratedKeys = true, keyProperty = "dmFavor.favorId")
    public int add(@Param("dmFavor")DmFavor dmFavor);

    @Select("SELECT * FROM dm_favor WHERE userId=#{userId}")
    public List<DmFavor> lst(int userId);

    @Update("UPDATE dm_favor SET isConqured=1 WHERE favorId=#{favorId}")
    public int upd(int favorId);
}
