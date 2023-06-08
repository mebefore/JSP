package co.young.notice.prodcut.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.notice.common.Command;
import co.young.notice.product.service.ProductService;
import co.young.notice.product.service.ProductVO;
import co.young.notice.product.serviceImpl.ProductServiceImpl;

public class productList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//제품리스트 
		ProductService ps = new ProductServiceImpl();
		List<ProductVO> products = new ArrayList<>();
		
		products = ps.productSelectList();
		request.setAttribute("products", products);
		
		return "product/productList";
	}

}
