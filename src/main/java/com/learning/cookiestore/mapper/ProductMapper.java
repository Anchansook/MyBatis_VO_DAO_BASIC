package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.ProductVO;

@Mapper
public interface ProductMapper {
	// 상품 등록
	int save(ProductVO productVO);

	// 상품 조회 (상품 번호)
	ProductVO findProductByProductNumber(Integer productNumber);
	// 상품 조회 (상품 이름)
	ProductVO findProductByProductName(String productName);

	// 상품 수정
	int updateProductByProductNumber(ProductVO productVO);

	// 상품 삭제
	int deleteProductByProductNumber(Integer productNumber);
	
}
