package com.dreammap.ws.bean;/**
 * Created by Lenovo on 2017/4/24.
 */

/**
 * Title: DmScenery
 * Project: DreamMap
 * Package: com.dreammap.ws.bean
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmScenery {
    private Integer sceneryId;
    private String SceneryName;
    private String sceneryImg;
    private String sceneryDesc;
    private Integer conqueredTimes;
    private Double sceneryLon;
    private Double sceneryLat;


    public Integer getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(Integer sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getSceneryName() {
        return SceneryName;
    }

    public void setSceneryName(String sceneryName) {
        SceneryName = sceneryName;
    }

    public String getSceneryImg() {
        return sceneryImg;
    }

    public void setSceneryImg(String sceneryImg) {
        this.sceneryImg = sceneryImg;
    }

    public String getSceneryDesc() {
        return sceneryDesc;
    }

    public void setSceneryDesc(String sceneryDesc) {
        this.sceneryDesc = sceneryDesc;
    }

    public Integer getConqueredTimes() {
        return conqueredTimes;
    }

    public void setConqueredTimes(Integer conqueredTimes) {
        this.conqueredTimes = conqueredTimes;
    }

    public Double getSceneryLon() {
        return sceneryLon;
    }

    public void setSceneryLon(Double sceneryLon) {
        this.sceneryLon = sceneryLon;
    }

    public Double getSceneryLat() {
        return sceneryLat;
    }

    public void setSceneryLat(Double sceneryLat) {
        this.sceneryLat = sceneryLat;
    }
}
