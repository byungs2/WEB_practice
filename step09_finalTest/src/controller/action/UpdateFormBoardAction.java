package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.guestbook.GuestBookBean;
import model.guestbook.GuestBookDAO;

public class UpdateFormBoardAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		String strNum=request.getParameter("num");
		try{
			if(strNum == null || strNum.trim().length() == 0){
				throw new Exception("입력값이 충분하지 않습니다.");
			}
			int num = Integer.parseInt(strNum);
			GuestBookBean gContent = GuestBookDAO.getContent(num, false);
			if(gContent == null){
				throw new Exception("게시물이 존재하지 않습니다.");
			}else{
				gContent.setContent(gContent.getContent().replaceAll("<br/>", "\n"));
				request.setAttribute("resultContent", gContent);
				url = "update.jsp";
			}
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
