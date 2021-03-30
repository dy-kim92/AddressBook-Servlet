package com.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.AddressDao;
import com.java.dao.AddressDaoImpl;
import com.java.dao.AddressVo;

@WebServlet(urlPatterns = "/ab" )
public class AddressBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AddressDao dao = new AddressDaoImpl();
		String action = req.getParameter("a");
		
		if("insert".equals(action)) {
			
			RequestDispatcher rd =
					getServletContext().getRequestDispatcher("/WEB-INF/views/insertForm.jsp");
			rd.forward(req, resp);
			
		} else if ("delete".equals(action)) {
			
			Long id = Long.valueOf(req.getParameter("id"));
			
			dao = new AddressDaoImpl();
			dao.delete(id);
			
			resp.sendRedirect(req.getContextPath() + "/ab");
			
		} else if ("search".equals(action)) {
			
			String keyword = req.getParameter("keyword");
			List<AddressVo> addressList = dao.search(keyword);
			req.setAttribute("addressList", addressList);
			req.setAttribute("keyword", keyword);
			RequestDispatcher rd = req.getRequestDispatcher("/");
			rd.forward(req, resp);
			
		} else {
			
			List<AddressVo> addressList = dao.getList();
			req.setAttribute("addressList", addressList);
			RequestDispatcher rd = req.getRequestDispatcher("/");
			rd.forward(req, resp);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("a");
		
		if ("insert".equals(action)) {
			
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String tel = req.getParameter("tel");
			
			AddressVo vo = new AddressVo();
			vo.setName(name);
			vo.setPhone(phone);
			vo.setTel(tel);
			
			AddressDao dao = new AddressDaoImpl();
			
			if(name == "" || phone == "" || tel == "") {
				
				System.out.println("NULL");
				req.setAttribute("a", "insert");
				doGet(req, resp);
				
			} else {
				
				dao.insert(vo);
				resp.sendRedirect(req.getContextPath() + "/ab");
			}
			
		} else {
			doGet(req, resp);
		}
		
	}
	
	
}
