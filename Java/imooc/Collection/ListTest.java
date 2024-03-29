package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//备选课程类
public class ListTest {
	public List coursesToSelect;
	public ListTest() {
		this.coursesToSelect = new ArrayList();
	}
	public void testAdd() {
		Course cr1 = new Course("1","数据结构");
		coursesToSelect.add(cr1);
		Course temp = (Course)coursesToSelect.get(0);
		System.out.println("添加了课程："+ temp.id +":" + temp.name);

		Course cr2 = new Course("2","C语言");
		coursesToSelect.add(0,cr2);
		Course temp2 = (Course)coursesToSelect.get(0);
		System.out.println("添加了课程："+ temp2.id +":" + temp2.name);

		coursesToSelect.add(cr1);
		Course temp0 = (Course)coursesToSelect.get(2);
		System.out.println("添加了课程："+ temp0.id +":" + temp0.name);

		//以下方法会抛出数组下标越界异常
//		Course cr3 = new Course("3","test");
//		coursesToSelect.add(3,cr3);
//		Course temp3 = (Course)coursesToSelect.get(3);
//		System.out.println("添加了课程："+ temp3.id +":" + temp3.name);
		Course[] course = {new Course("3","离散属性"), new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course)coursesToSelect.get(3);
		Course temp4 = (Course)coursesToSelect.get(4);
		System.out.println("添加了两门课程："+ temp3.id +":" + temp3.name+";"+temp4.id+":"+temp4.name);

		Course[] course2 = {new Course("5","高等数学"), new Course("6","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
		Course temp6 = (Course)coursesToSelect.get(3);
		System.out.println("添加了两门课程："+ temp5.id +":" + temp5.name+";"+temp6.id+":"+temp6.name);

	}
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i=0;i<size;i++) {
			Course cr = (Course)coursesToSelect.get(i);
			System.out.println("课程： "+cr.id+":"+cr.name);
		}
	}
	
	//通过迭代器遍历List
	public void testIterator() {
		System.out.println("有如下课程待选（通过Iterator返回）：");

		Iterator it = coursesToSelect.iterator();
		while(it.hasNext()) {
			Course cr = (Course)it.next();
			System.out.println("课程： "+cr.id+":"+cr.name);
		}
	}
	
	//通过for each方法访问集合元素
	public void testForeach() {
		System.out.println("有如下课程待选（通过ForEach返回）：");

		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("课程： "+cr.id+":"+cr.name);
		}
	}
	
	//修改List中的元素
	public void testModify() { 
		coursesToSelect.set(4, new Course("7","毛概"));
	}
	
	
	//删除List中的元素
	public void testRemove() {
//		Course cr = (Course)coursesToSelect.get(4);
//		System.out.println("要删除的课程： "+cr.id+":"+cr.name);
//		coursesToSelect.remove(cr);  //也行得通
		
//		System.out.println("即将删除位置4上的课程： ");
//		coursesToSelect.remove(4);
		
		System.out.println("即将删除位置4和5上的课程： ");
		Course[] courses = {(Course) coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses)); //从列表中移除指定collection中包含的其所有元素
		System.out.println("成功删除课程");
		testForeach();
	}
	
	
	//往List中添加一些奇怪的东西
	public void testType() {
		System.out.print("能否往List上添加一些奇怪的东西");
		coursesToSelect.add("我不是课程，我只是一个无辜的字符串！");
	}
	
	public static void main(String[] args) {
		ListTest it = new ListTest();
		it.testAdd();
		it.testType(); //java.lang.String cannot be cast to com.imooc.collection.Course
		it.testForeach();
		
//		it.testGet();
//		it.testIterator();
//		it.testForeach();
//		it.testModify();
//		it.testForeach();
//		it.testRemove();
		
	}
}
