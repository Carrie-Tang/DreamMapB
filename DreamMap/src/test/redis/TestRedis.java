package redis;/**
 * Created by Lenovo on 2017/4/24.
 */


import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Title: TestRedis
 * Project: DreamMap
 * Package: redis
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class TestRedis{
    private Jedis jedis;

    @Before
    public void init(){
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("120.25.146.113", 6379);
        jedis.auth("630okhXp7HRf2RiREnVAQgJtJibMcuGV");
    }

    @Test
    public void testRedisConnection(){
//        ApplicationContext cxt=new FileSystemXmlApplicationContext("classpath*:context/application-redis.xml");
        String test = jedis.get("dm_0933ac2904e86fcccc4e6a7de0415d4d");//向key-->name中放入了value-->xinxin
        System.out.println(test);
//        jedis.expire("name",60);

    }
}
