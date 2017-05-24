package com.yxh.audition.designmodel.abstractFactory;

public class MailFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
