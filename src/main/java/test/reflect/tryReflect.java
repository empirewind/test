/*
 * 文件名：tryReflect.java
 * 版权：Copyright by www.huawei.com
 * 描述：
 * 修改人：Hello World
 * 修改时间：2016年10月1日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author YuanPeng
 * @version 2016年10月1日
 * @see tryReflect
 * @since
 */

public class tryReflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {

        tryReflect tr = new tryReflect();
        //tr.getAttribute();
        tr.getOneAttr();
        
    }
   //1、 //反射机制获取类有三种方法
   public  void  getClassWithReflect(){
      try {
         //first method
        Object Classc1 = Class.forName("User");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
      //second method
      Object Classc2 = User.class;
      //third method
      User u = new User();
      Class<? extends User> Classc3 =u.getClass();
   }
   
   public void useClass(){
       try {
            Class c = Class.forName("User");
            Object o = c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
       
   }
//get all attribute
   public void getAttribute() throws ClassNotFoundException{
       Class c = Class.forName("java.lang.Integer");
       Field[] fs =c.getDeclaredFields();
       //declare String for saving fields
       StringBuffer sb = new StringBuffer();
       sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
       //internal all attribute
       for(Field field:fs){  
           sb.append("\t");//空格  
           sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等  
           sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字  
           sb.append(field.getName()+";\n");//属性的名字+回车  
       }  
       sb.append("}");  
       System.out.println(sb);  
   }
   //get one attribute
   public void getOneAttr() throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException{
       Class c = Class.forName("test.reflect.User");
       Field idF = c.getDeclaredField("id");
       Object o = c.newInstance();
       //打破封装
       idF.setAccessible(true);
       //给对象赋值
       idF.set(o, 110);
       System.out.println(idF.get(o));
   }
}
