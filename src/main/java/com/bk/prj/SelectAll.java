package com.bk.prj;

import com.bk.prj.dao.ProjectDAO;
import com.bk.prj.entity.Project;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class SelectAll extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out=response.getWriter();
        ProjectDAO projectDAO=new ProjectDAO();

        try {
            projectDAO.connect();
            List<Project> lPrj=projectDAO.selectAll();

            Gson gson=new Gson();
            out.print(gson.toJson(lPrj));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            projectDAO.disconnect();
        }
    }
}
