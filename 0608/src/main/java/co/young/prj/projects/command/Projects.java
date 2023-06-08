package co.young.prj.projects.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.young.prj.common.Command;

public class Projects implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "projects/projects";
	}

}
