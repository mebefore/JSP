package co.young.notice.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.notice.common.Command;

public class productInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//입력폼 호출 
		return "product/productInsertForm";
	}

}
