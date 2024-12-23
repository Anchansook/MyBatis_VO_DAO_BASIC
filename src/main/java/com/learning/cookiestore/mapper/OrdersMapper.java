package com.learning.cookiestore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.OrdersVO;
import com.learning.cookiestore.vo.SelectOrdersProductsVO;

@Mapper
public interface OrdersMapper {
	// 주문 생성
	int save(OrdersVO ordersVO);

	// 주문 내역 조회
	List<SelectOrdersProductsVO> findOrderByOrderCode(Integer orderCode);

	// 주문 삭제
	int deleteOrderByOrderCode(Integer orderCode);

	// 장바구니가 아니므로 수정은 제외
	
}
