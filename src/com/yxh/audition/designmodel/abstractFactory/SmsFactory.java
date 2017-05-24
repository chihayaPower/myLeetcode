package com.yxh.audition.designmodel.abstractFactory;

public class SmsFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
