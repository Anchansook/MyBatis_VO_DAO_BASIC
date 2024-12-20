package com.learning.cookiestore.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//# 데이터를 담는 객체 - 상품

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
	private Integer productNumber;
	private String productName;
	private Integer productPrice;
	
}
