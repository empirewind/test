/*
 * 文件名：immutable.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test;
import java.math.*;

/**
 *不可变类的小测试
 * @author YuanPeng
 * @version 2016年9月18日
 * @see immutable
 * @since
 */

public class immutable {
    public static void main(String[] args) {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHuandredThousand = new BigInteger("500000");
        BigInteger total = BigInteger.ZERO;
        total = total.add(fiveHuandredThousand);
        total.hashCode();
        total = total.add(fiveThousand);
        total.hashCode();
        System.out.println(total);
    }

}
