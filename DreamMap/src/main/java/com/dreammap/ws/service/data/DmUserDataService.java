package com.dreammap.ws.service.data;

import com.dreammap.ws.bean.DmUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Lenovo on 2017/4/24.
 */
public interface DmUserDataService {
    @Insert("INSERT INTO dm_user (userName,phone,password) VALUES (#{dmUser.userName},#{dmUser.phone},#{dmUser.password})")
    @Options(useGeneratedKeys = true, keyProperty = "dmUser.userId")
    public int add(@Param("dmUser")DmUser dmUser);

    @Select("SELECT * FROM dm_user WHERE userId=#{userId}")
    public DmUser one(int userId);

    @Select("SELECT * FROM dm_user WHERE phone=#{phone}")
    public DmUser getOneByPhone(String phone);
}
