package token;/**
 * Created by Lenovo on 2017/4/25.
 */

import com.dreammap.ws.utils.DmTokenTool;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title: TestMD5
 * Project: DreamMap
 * Package: token
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/25
 */

public class TestMD5 {
    @Test
    public void testGetToken() {
        System.out.println(DmTokenTool.getToken("LCY"));
    }

    @Test
    public void testCheckToken() {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(System.currentTimeMillis());
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        System.out.println(res);
    }



}