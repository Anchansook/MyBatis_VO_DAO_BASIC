package com.learning.cookiestore.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//# 데이터를 담는 객체 - 결제

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO {
	private Integer paymentNumber;
	private Integer orderCode;
	private String userId;
	private Integer paidAmount;
	
}
