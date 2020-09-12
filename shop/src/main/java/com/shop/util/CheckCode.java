package com.shop.util;

public class CheckCode {

	public String generateCheckCode(){
		String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
		return verificationCode;
	}

}
