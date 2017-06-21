/*
 * 文件名：Dervied.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2017年3月15日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test.reflect;

public class Test {
    public static void main(String [] args){
        int i=12;
//        System.out.println(i+=i-=i*=i);
        i*=i;
        i+=i;
        i-=i;
        System.out.println(i);
        }
    }