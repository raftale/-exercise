package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	//带有泛型 ---- Course，的List类属性
	public List<Course> courses;
	
	public TestGeneric() {
		this.courses =  new ArrayList<Course>();
	}
	
	//测试添加
	public void testAdd() {
		Course cr1 = new Course("1","大学语文");
		courses.add(cr1);
		//泛型集合中，不能除泛型类型以外及其子类型以外的对象，否则会报错
//		courses.add("能否添加一些奇怪的东西呢？？？");
		Course cr2 = new Course("2","Java基础");
		courses.add(cr2);
	}
	
	//测试循环遍历
	public void testForeach() {
		for(Course cr : courses) {
			System.out.println("课程: "+cr.id+ ": "+cr.name);
		}
	}
	
	//测试泛型集合可以添加泛型的子类型的对象实例
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id="3";
		ccr.name = "我是子类型的课程对象实例";
		courses.add(ccr);
	}
	
	//泛型不能使用基本类型,须使用其包装类
	public void testBasicType() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("基本类型必须使用包装类作为泛型!"+list.get(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForeach();
		tg.testChild();
		tg.testForeach();
		tg.testBasicType();
	}

}
