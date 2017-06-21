/*
 * 文件名：FtpTest.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2017年3月30日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test.ftp;

/**
 * FTP测试类
 * @author Hello World
 * @version 2017年3月30日
 * @see FtpTest
 * @since
 */

public class FtpTest {

    /**
     * Description: 
     * Implement: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param args 
     * @see 
     */
    public static void main(String[] args) {
        String url = "192.168.120.160";
        int port = 21;
        String username = "test";
        String password = "123456";
        String remotePath = "/mnt/k8s/";
        String fileName = "ceph.conf";
        String localPath = "D://";
        FtpUtil.downFile(url, port, username, password, remotePath, fileName, localPath);
    }

}
