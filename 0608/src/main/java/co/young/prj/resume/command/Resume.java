package co.young.prj.resume.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.prj.common.Command;

public class Resume implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "resume/resume";
	}

}
