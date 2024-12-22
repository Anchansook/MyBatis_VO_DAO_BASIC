package com.learning.cookiestore.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

//# 주문코드 생성 유틸

public class CreateOrderCode {
	private String generateOrderCode() {
		String dataPart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		Random random = new Random();
		int randomNumber = random.nextInt(100000);

		System.out.println(dataPart + String.format("%05d", randomNumber));
		
		return dataPart + String.format("%05d", randomNumber);
	}
}
