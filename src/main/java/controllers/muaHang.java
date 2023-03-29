package controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class muaHang
 */
@WebServlet("/mua-hang")
public class muaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public muaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String soLuong = request.getParameter("soLuong");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");

		boolean checkError = false;

		// catch error quantity
		double giatri_soluong = 0;
		try {
			giatri_soluong = Double.parseDouble(soLuong);
		} catch (Exception e) {
			checkError = true;
			request.setAttribute("e_soLuong", "Sai, nhập lại");
		}

		if (giatri_soluong <= 0) {
			checkError = true;
			request.setAttribute("e_soLuong", "Sai, nhập lại lớn hơn 0");
		}else {
			request.setAttribute("soLuong", soLuong);
		}
		
		// catch error phonenumber
		Pattern soDienThoaiPattern = Pattern.compile("\\d{10}");
		Matcher soDienThoaiMatcher = soDienThoaiPattern.matcher(soDienThoai);
		if (!soDienThoaiMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_phonenumber", "So dien thoai khong dung");
		}else {
			request.setAttribute("soDienThoai", soDienThoai);
		}

		// catch error email
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern emailPattern = Pattern.compile(regex);
		Matcher emailMatcher = emailPattern.matcher(email);
		if (!emailMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_email", "email khong dung");
		}else {
			request.setAttribute("email", email);
		}
		String url = "/success.jsp";
		if (checkError) {
			url = "/index.jsp";
		}

		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);

		rq.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
