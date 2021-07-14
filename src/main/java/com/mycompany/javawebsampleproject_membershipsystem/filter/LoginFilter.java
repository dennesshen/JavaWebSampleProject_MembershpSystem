package com.mycompany.javawebsampleproject_membershipsystem.filter;

import com.mycompany.javawebsampleproject_membershipsystem.service.DataManipulateService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denne
 */
@WebFilter("/controller/requestDataServlet")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String accountName = req.getParameter("accountName");
        String password = req.getParameter("password");
        String enterAuthorCode = req.getParameter("enterAuthorCode");
        String authorCode = session.getAttribute("authorCode").toString();
        boolean check = false;
        try {
            check = new DataManipulateService().checkPassword(accountName, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        if (!enterAuthorCode.equals(authorCode)) {
            res.setContentType("text/html;charset=UTF-8");
            res.getWriter().print("認證碼錯誤!");
            return;
        }
        if (check) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().println("accountName:" + accountName);
            res.getWriter().println("password:" + password);
            res.getWriter().println("enterAuthorCode:" + enterAuthorCode);
            res.getWriter().println("authorCode:" + authorCode);
        }

    }

}
