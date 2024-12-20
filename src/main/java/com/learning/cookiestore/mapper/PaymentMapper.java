package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.PaymentVO;

@Mapper
public interface PaymentMapper {
	// 결제 생성
	int save(PaymentVO paymentVO);
	
}
