/**
 * 
 */
package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanpeng
 *
 */
public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> bigSet = new HashSet<Integer>();
		bigSet.add(1);bigSet.add(2);bigSet.add(3);
		Set<Integer> smalSet = new HashSet<Integer>();
		smalSet.add(1);smalSet.add(4);
		bigSet.removeAll(smalSet);
		
		Object[] obj =bigSet.toArray();
		int portSet=Integer.valueOf(obj[0]
							.toString());
		System.out.println(bigSet.toString());
	}

}
