package com.yxh.audition.designmodel.factory;

public class FactoryTest {

	
	public static void main(String[] args) {
		Sender mailsend = SenderFactory.produceMail();
		Sender smssend = SenderFactory.produceSms();
		
		mailsend.Send();
		smssend.Send();
	}
}
