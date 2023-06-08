package co.young.notice.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.young.notice.common.Command;
import co.young.notice.product.service.ProductService;
import co.young.notice.product.service.ProductVO;
import co.young.notice.product.serviceImpl.ProductServiceImpl;

public class productInsertgo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//제품등록 처리 및 파일 업로드
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		String saveDir = "upload/";
		int maxSize = 100 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(
											request,
											saveDir,
											maxSize,
											"utf-8",
											new DefaultFileRenamePolicy());
			String pfile = multi.getFilesystemName("pfile");
			pfile += saveDir + pfile;
			String ofile = multi.getOriginalFileName("pfile");
		
			vo.setProductId(multi.getParameter("productId"));
			vo.setProductName(multi.getParameter("productName"));
			
			if(ofile != null) {
				vo.setProductImage(ofile);
				vo.setProductDir(pfile);
			}
			
			ps.productInsert(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		vo.setProductName(request.getParameter("productName"));
		System.out.println(vo.getProductName());
		return "productList.do";
	}

}
