package com.dreammap.ws.service.data;

import com.dreammap.ws.bean.DmScenery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Lenovo on 2017/4/24.
 */
public interface DmSceneryDataService {
//    @Insert("INSERT INTO dm_scenery (userName,phone,password) VALUES (#{dmUser.userName},#{dmUser.phone},#{dmUser.password})")
//    @Options(useGeneratedKeys = true, keyProperty = "dmUser.userId")
//    public int add(@Param("dmUser") DmUser dmUser);

    @Select("SELECT * FROM dm_scenery WHERE sceneryId=#{sceneryId}")
    public DmScenery one(int sceneryId);

    @Select("SELECT * FROM dm_scenery")
    public List<DmScenery> lst();

}
