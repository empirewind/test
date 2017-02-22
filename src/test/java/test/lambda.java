/*
 * 文件名：lambda.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月20日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;
/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月20日
 * @see lambda
 * @since
 */

public class lambda {
    String[] atp = {"Rafael Nadal", "Novak Djokovic",  
            "Sta7nislas Wawrinka",  
            "David Ferrer","Roger Federer",  
            "Andy Murray","Tomas Berdych",  
            "Juan Martin Del Potro"};  
    /**
     * Description: <br>
     * Implement: <br>
     * 
     * @param args 
     * @see 
     */
    public static void main(String[] args) {
        lambda lam = new lambda();
        lam.lambda1();
        lam.lambda2();
    }
    public void lambda1(){
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, atp);
//        list.forEach((l)->System.out.println(l +";"));
        list.forEach(System.out::println);
    }
    public void lambda2(){
        
//        List<String> players = Arrays.asList(atp);
        Arrays.sort(atp,new Comparator<String>(){
            public int compare(String s1,String s2){
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));             }
        });
        List<String> players = Arrays.asList(atp);
        System.out.println(players);
    }
    public void lambda3(){
        Arrays.sort(atp,(String s1, String s2)->
            s1.substring(s1.indexOf(" ")).compareTo( s2.substring(s2.indexOf(" ")) )   
        );
    }

}
