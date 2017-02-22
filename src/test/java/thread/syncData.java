/*
 * 文件名：syncData.java
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


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月18日
 * @see syncData
 * @since
 */

public class syncData {

    private int data;
    public synchronized void set(int data){
        System.out.println(Thread.currentThread().getName()+"准备写入数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName()+"写入 " + this.data);
    }
    public synchronized void get(){
        System.out.println(Thread.currentThread().getName()+"准备读取数据");
        try {
            Thread.sleep(20);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"读取"+this.data);
    }
    
    public static void main(String[] args){
        final syncData data = new syncData();
        //write
        for(int i =0; i<3;i++){
            Thread t = new Thread(()->{
                for(int j =0;j<5;j++){
                    data.set(new Random().nextInt(30));
                }
            }
            );
            t.setName("Thread-W"+ i);
            t.start();
        }
        //读取
        for(int i = 0; i<3;i++){                    
            Thread t = new Thread(()->{
                    for(int j=0;j<5;j++){
                        data.get();
                    }
                });
            t.setName("Thread-R" +i);
            t.start();
        }
//        Thread t = new Thread(()->{for(int j=0;j<5;j++){
//            data.get();
//        } } );
    }
}
