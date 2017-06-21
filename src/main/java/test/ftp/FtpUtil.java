package test.ftp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


/**
 * FtpUtil 工具类
 * @author King
 * @version 2017年3月29日
 * @see FtpUtil
 * @since
 */

public class FtpUtil {
    /** 
    * Description: 向FTP服务器上传文件 
    * @param url FTP服务器hostname 
    * @param port FTP服务器端口 
    * @param username FTP登录账号 
    * @param password FTP登录密码 
    * @param path FTP服务器保存目录 
    * @param filename 上传到FTP服务器上的文件名 
    * @param input 输入流 
    * @return 成功返回true，否则返回false 
    */
    public static boolean uploadFile(String url, int port, String username, String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            //连接FTP服务器
            ftp.connect(url, port);
            //登录 
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //切换到FTP服务器保存目录
            boolean changeWorkingDirectory = ftp.changeWorkingDirectory(path);
            if (!changeWorkingDirectory) {
                String[] split = path.split("/");
                for (int i = 0; i < split.length; i++ ) {
                    if (!ftp.changeWorkingDirectory(split[i])) {
                        ftp.makeDirectory(split[i]);
                        ftp.changeWorkingDirectory(split[i]);
                    }
                }
            }
            else {
                ftp.changeWorkingDirectory(path);
            }

            //设置当前的数据连接模式
            ftp.enterLocalPassiveMode();
            ftp.setControlEncoding("UTF-8");
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //存储文件使用给定的文件名，并输入从给定的InputStream。
            ftp.storeFile(new String(filename.getBytes("UTF-8"), "iso-8859-1"), input);
            input.close();
            ftp.logout();
            success = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return success;
    }

    /** 
    * Description: 从FTP服务器下载文件 
    * @param url FTP服务器hostname 
    * @param port FTP服务器端口 
    * @param username FTP登录账号 
    * @param password FTP登录密码 
    * @param remotePath FTP服务器上的相对路径 
    * @param fileName 要下载的文件名 
    * @param localPath 下载后保存到本地的路径 
    * @return 
    */
    public static boolean downFile(String url, int port, String username, String password, String remotePath, String fileName, String localPath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            //连接FTP服务器
            ftp.connect(url, port);
            ftp.setDataTimeout(60000);       //设置传输超时时间为60秒 
            ftp.setConnectTimeout(60000);       //连接超时为60秒
            //登录 
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //切换到FTP服务器目录
            ftp.changeWorkingDirectory(remotePath);
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
            ftp.logout();
            success = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

}
