package com.testing;

import java.io.IOException;

class Lead {
	static void test() throws IOException {
		System.out.println("lead");
	}
}

public class Testing extends Lead{
	
//	static void test() throws Exception{
//		
//	}
	
int testEMethod() {
	    int i =0;
	    try {
	    	i = 100/1;
	    	return i;
	    } catch(Exception e) {
	    	i = 200/i;
	    	return i;
	    }
	    finally {
	    	System.out.println("finallly block!!!!!!!11");
	    	i = 300;
	    }
	}
	
public static void main(String[] args) {
	
	
	
//	int test = new Testing().testEMethod();
//	System.out.println("test: " + test);
	
	
//	System.out.println("abc: " + (11<22<33));
//	System.out.println("abc:" + (11>22>33));
	
//	float f[] = new float[5];
//	Object ob = f;
//	System.out.println(f[0]);
//	Class<Testing> testing;
//	testing.getin
//	int a[] = {2, 3, 4 , 5};
//	for( int i = 0; i < 3; ++i) {
//		System.out.println(i);
	}
}
