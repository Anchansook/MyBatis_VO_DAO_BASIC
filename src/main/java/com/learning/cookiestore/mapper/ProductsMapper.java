package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.ProductsVO;

@Mapper
public interface ProductsMapper {
	// 상품 등록
	int save(ProductsVO productsVO);

	// 상품 조회 (상품 번호)
	ProductsVO findProductByProductNumber(Integer productNumber);
	// 상품 조회 (상품 이름)
	ProductsVO findProductByProductName(String productName);

	// 상품 수정
	int updateProductByProductNumber(ProductsVO productVO);

	// 상품 삭제
	int deleteProductByProductNumber(Integer productNumber);
	
}
