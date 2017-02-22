/*
 * 文件名：stream.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月20日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月20日
 * @see stream
 * @since
 */

public class mystream {

    public void java7Sort1(){
        List<Integer> nums = Arrays.asList(1,2,3,4);
        List<Integer> squareNums = nums.stream().
                map(n ->n*n).collect(Collectors.toList());
        squareNums.forEach(System.out::println);
    }
    public static void main(String[] args) {
        //IntStream.range(1, 3).forEach(System.out::println);
        mystream mys = new mystream();
        mys.java7Sort1();
    }
}
