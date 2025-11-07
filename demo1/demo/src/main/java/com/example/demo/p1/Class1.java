package com.example.demo.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Class1 {

	public MyClass val;
	
	@Autowired
	public void fun2(MyClass obj)
	{
		val = obj;
	}
	
	public String show()
	{
		return val.fun1();
	}
}
