package token;/**
 * Created by Lenovo on 2017/5/8.
 */

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Title: GetRequest
 * Project: DreamMap
 * Package: token
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/8
 */

public class GetRequest {

    @Test
    public void testHttps() throws Exception {
        URL myURL = new URL("https://www.tmall.com/");


                // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
                HttpsURLConnection httpsConn = (HttpsURLConnection) myURL
                        .openConnection();

                // 取得该连接的输入流，以读取响应内容
                InputStreamReader insr = new InputStreamReader(httpsConn
                        .getInputStream());
              // 读取服务器的响应内容并显示
              int respInt = insr.read();
              while (respInt != -1) {
                       System.out.print((char) respInt);
            respInt = insr.read();
                  }

    }
}
