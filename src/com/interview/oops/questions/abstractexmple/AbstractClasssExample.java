package com.interview.oops.questions.abstractexmple;

 abstract class Phone {
	public static final int PHONE_PRICE = 10000;
      abstract void call();
      abstract void camera();
      void displayPrice() {
    	  System.out.println(PHONE_PRICE);
      }
}

class IPhone extends Phone {
//	void display() {
//		
//	}

	@Override
	void call() {
		System.out.println("Inside IPhone call method:.....");	
	}

	@Override
	void camera() {
		System.out.println("Inside IPhone camera method:.....");	
	}
 }

class SamsungPhone extends Phone {
	@Override
	void call() {
		System.out.println("Inside samsung call method:.....");	
	}
	@Override
	void camera() {
		System.out.println("Inside samsung camera method:.....");	
	}
}

public class AbstractClasssExample {
	public static void main(String[] args) {
		Phone phone = new IPhone();
		System.out.println("Welecome.......");
        System.out.println("Iphone: " );
        phone.call();
        Phone samsungPhone = new SamsungPhone();
        samsungPhone.call();
        samsungPhone.displayPrice();
 	}
}
