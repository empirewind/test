/*
 * 文件名：BoundedBuffer.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年9月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年9月18日
 * @see BoundedBuffer
 * @since
 */

public class BoundedBuffer {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    
    final Object[] items = new Object[100];
    int putptr;
    int takeptr;
    int count;
    
    public void put(Object x) throws InterruptedException{
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        
    }
    
    public Object take() throws InterruptedException{
        lock.lock(); 
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
          
}
