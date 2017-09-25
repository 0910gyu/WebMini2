package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.dao.JoinDao;
import car.dao.LoginDAO;
import car.dao.UpdateDao;
import car.dto.MemberVO;

@WebServlet("/logSc")
public class LoginSearch extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		if (command.equals("login")) {
			login(request, response);
			/* response.sendRedirect("loginView.jsp"); */
		} else if (command.equals("join")) {
			insertMember(request, response);
			System.out.println("가입성공");
		} else if (command.equals("update")) {
			update(request, response);
			System.out.println("수정");
		} else if (command.equals("info")) {
			System.out.println("개인정보");
			info(request, response);

		}
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);

		MemberVO infomem = new MemberVO();
		infomem.setId(id);
		String url = null;

		LoginDAO.getInstance();
		request.setAttribute("id", id);

		url = "info.jsp";

		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("개인정보");

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");

		MemberVO loginMember = new MemberVO();
		loginMember.setId(id);
		loginMember.setPassword(password);
		String url = null;

		LoginDAO.getInstance();
		request.setAttribute("id", id);
		request.setAttribute("pwd", password);
		url = "loginView.jsp";

		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
		System.out.println("로그인");
		System.out.println(loginMember.toString());

	}

	public void insertMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String mail = request.getParameter("mail").trim();
		String addr = request.getParameter("addr").trim();
		String phone = request.getParameter("phone").trim();
		MemberVO mem = new MemberVO(id, pw, name, mail, addr, phone);
		String url = null;
		try {
			JoinDao.memberJoin(mem);
			request.setAttribute("mem", mem);
			url = "index.html";
		} catch (Exception e) {
			request.setAttribute("error", "입력 실패");
			url = "error.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	MemberVO mem = new MemberVO(request.getParameter("id").trim(), request.getParameter("password").trim(),
				request.getParameter("name").trim(), request.getParameter("mail").trim(),
				request.getParameter("addr").trim(), request.getParameter("phone").trim());*/
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String mail = request.getParameter("mail").trim();
		String addr = request.getParameter("addr").trim();
		String phone = request.getParameter("phone").trim();
		MemberVO mem = new MemberVO(id, password, name, mail, addr, phone);
		String url = null;
		
		try {
			UpdateDao.update(mem);
			request.setAttribute("mem", mem);
			url = "loginWiew.jsp";
//			request.getRequestDispatcher("loginView.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", "에러");
			url = "error.jsp";
//			request.getRequestDispatcher("error.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
