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
public class settest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set set =new HashSet();
		System.out.println(set.toString());
		System.out.println(set.isEmpty());
		set.add(null);

		System.out.println(set.toString());
		System.out.println(set.isEmpty());
		System.out.println(set.remove(null));
		set.remove(null);
		Object[] obj =set.toArray();
		
		System.out.println(obj[0].toString());
		System.out.println(set.isEmpty());

	}

}
