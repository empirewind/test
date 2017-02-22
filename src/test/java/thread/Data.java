/*
 * 文件名：Data.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月18日
 * @see Data
 * @since
 */

public class Data {

    private int data;
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void set(int data){
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        } finally {
            rwl.writeLock().unlock();
        }
    }
    public void get(){
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备读取数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        } finally {
            rwl.readLock().unlock();
        }
    }
    
    public static void main(String[] args){
        final syncData data = new syncData();
        //write
        for(int i =0; i<3;i++){
            Thread t = new Thread(new Runnable(){
                public void run(){
                    for(int j =0 ;j<5;j++){
                        data.set(new Random().nextInt(30));
                    }
                }
            }
            );
            t.setName("Thread-W"+ i);
            t.start();
        }
        //读取
        for(int i = 0; i<3;i++){
            Thread t = new Thread(new Runnable(){
                public void run(){
                    for(int j=0;j<5;j++){
                        data.get();
                    }
                }
            });
            t.setName("Thread-R" +i);
            t.start();
        }
    }
}
