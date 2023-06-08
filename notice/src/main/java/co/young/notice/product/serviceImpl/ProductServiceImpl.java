package co.young.notice.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.young.notice.common.DataSource;
import co.young.notice.product.service.ProductMapper;
import co.young.notice.product.service.ProductService;
import co.young.notice.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //dao 선언
	ProductMapper map = sqlSession.getMapper(ProductMapper.class); //mapping
	
	@Override
	public List<ProductVO> productSelectList() {
		// TODO Auto-generated method stub
		return map.productSelectList();
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productSelect(vo);
	}

	@Override
	public int productInsert(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productInsert(vo);
	}

	@Override
	public int productUppdate(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productUppdate(vo);
	}

	@Override
	public int productDelete(ProductVO vo) {
		// TODO Auto-generated method stub
		return map.productDelete(vo);
	}

}
