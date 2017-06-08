package com.dreammap.ws.utils;/**
 * Created by Lenovo on 2017/5/12.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Title: DmMD5Tool
 * Project: DreamMap
 * Package: com.dreammap.ws.utils
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/5/12
 */

public class DmMD5Tool {
    /**
     * md5编码
     *
     * @param newString 需要编码的字符串
     * @return
     */
    public static String getMd5(String newString) {//md5编码
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        byte[] btInput = newString.getBytes();
        char str[] = null;
        try {
            // 获得MD5摘要算法的MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int length = md.length;
            str = new char[length * 2];
            int k = 0;
            for (int i = 0; i < length; i++) {
                byte byte0 = md[i];
                // 取出这个字节的高四位，然后与0x0f与运算，得到一个0-15之间的数据，通过hexDigits（0-15）即为十六进制数
                str[k++] = hexDigits[(byte0 >>> 4) & 0x0f];
                // 取出这个字节的地位，与0x0f与运算，得到一个0-15之间的数据，通过hexDigits（0-15）即为十六进制数
                str[k++] = hexDigits[byte0 & 0x0f];
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return new String(str);
    }
}
