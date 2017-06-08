package com.dreammap.ws.bean;/**
 * Created by Lenovo on 2017/4/24.
 */

/**
 * Title: DmFavor
 * Project: DreamMap
 * Package: com.dreammap.ws.bean
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmFavor {
    private Integer favorId;
    private Integer userId;
    private Integer sceneryId;
    private String vector;
    private Integer isConqured;

    public Integer getIsConqured() {
        return isConqured;
    }

    public void setIsConqured(Integer isConqured) {
        this.isConqured = isConqured;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVector(){
        return this.vector;
    }

    public void setVector(String data){
        this.vector = data;
    }

    public Integer getFavorId() {
        return favorId;
    }

    public void setFavorId(Integer favorId) {
        this.favorId = favorId;
    }

    public Integer getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(Integer sceneryId) {
        this.sceneryId = sceneryId;
    }
}
