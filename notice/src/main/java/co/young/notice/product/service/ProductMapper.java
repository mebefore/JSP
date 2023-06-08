package co.young.notice.product.service;

import java.util.List;

public interface ProductMapper {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUppdate(ProductVO vo);
	int productDelete(ProductVO vo);
	
	
}
