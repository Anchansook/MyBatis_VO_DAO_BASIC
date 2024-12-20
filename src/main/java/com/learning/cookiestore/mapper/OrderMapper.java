package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.OrderVO;

@Mapper
public interface OrderMapper {
	// 주문 생성
	int save(OrderVO orderVO);

	// 주문 내역 조회
	OrderVO findOrderByOrderCode(Integer orderCode);

	// 주문 삭제
	int deleteOrderByOrderCode(Integer orderCode);

	// 장바구니가 아니므로 수정은 제외
	
}
