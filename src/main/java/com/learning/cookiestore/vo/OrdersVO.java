package com.learning.cookiestore.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//# 데이터를 담는 객체 - 주문

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersVO {
	private Integer orderCode;
	private String userId;
	private Integer productNumber;
	private Integer productCount;
	private Integer totalPrice;
	private String orderDate;
	
}
