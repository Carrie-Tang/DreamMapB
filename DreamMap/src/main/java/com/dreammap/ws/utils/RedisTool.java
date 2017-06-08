package com.dreammap.ws.utils;/**
 * Created by Lenovo on 2017/4/24.
 */

import redis.clients.jedis.Jedis;

/**
 * Title: RedisTool
 * Project: DreamMap
 * Package: com.dreammap.ws.utils
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class RedisTool {
    private final static String REDIS_RUL="120.25.146.113";
    private final static Integer REDIS_PORT=6379;
    private final static String REDIS_PASSWORD="630okhXp7HRf2RiREnVAQgJtJibMcuGV";
    private final static String REDIS_DB_PREFIX="dm_";
    private Jedis jedis;

    private void init(){
        this.jedis = new Jedis(this.REDIS_RUL, this.REDIS_PORT);
        this.jedis.auth(this.REDIS_PASSWORD);
    }

    public void set(String key,String value,int time){
        this.init();
        jedis.set(this.REDIS_DB_PREFIX+key,value);
        jedis.expire(this.REDIS_DB_PREFIX+key,time);
        this.close();
    }

    public String get(String key){
        this.init();
        String result = jedis.get(this.REDIS_DB_PREFIX+key);
        this.close();
        return result;
    }

    public void delete(String key){
        this.init();
        jedis.del(this.REDIS_DB_PREFIX+key);
    }

    private void close(){
        this.jedis.close();
    }
}
