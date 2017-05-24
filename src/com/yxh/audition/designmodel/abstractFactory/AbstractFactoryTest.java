package com.yxh.audition.designmodel.abstractFactory;

public class AbstractFactoryTest {
	
	
	public static void main(String[] args) {
		Provider provider = new MailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}
