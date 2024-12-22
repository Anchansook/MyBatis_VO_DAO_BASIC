package com.learning.cookiestore.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//# 주문내역 조회를 위한 VO

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectOrdersProductsVO {
	private String productName;
	private Integer productCount;
	private Integer totalPrice;
	private String orderDate;
	
}
