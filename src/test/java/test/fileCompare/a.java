/*
 * 文件名：a.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月23日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test.fileCompare;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月23日
 * @see a
 * @since
 */

public class a {
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest =MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //60292812ce9fc4a91a31cf8461ef0572
    //3ada46166fe6f5ddb005f653bd679af9
    //3ada46166fe6f5ddb005f653bd679af9

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File file = new File("B:/素材/050-H009超炫的火背景.rar");
        String result =  a.getFileMD5(file);
        long end = System.currentTimeMillis();
        System.out.println(end - start );
        System.out.println(result);

    }
}
