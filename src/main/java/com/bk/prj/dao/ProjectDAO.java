package com.bk.prj.dao;

import com.bk.jdbc.dao.DAO;
import com.bk.jdbc.util.JdbcUtil;
import com.bk.prj.entity.Project;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDAO extends DAO {

    public ProjectDAO() {
        this.tableName = "`prj`.`list`";
        JdbcUtil.setPropertyFile("./conf/bruce.conf");
    }

    public List<Project> selectAll() {
        List<Project> lPrj = new ArrayList<>();
        try {
            PreparedStatement stmt=conn.prepareStatement("select * from " + this.tableName + " order by no desc;");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            while (rs.next()) {
                Map<String, Object> row=new HashMap<>();
                for (int i=0;i<meta.getColumnCount();i++) {
                    row.put(meta.getColumnName(i+1), rs.getObject(i+1));
                }

                Project prj=new Project();
                try {
                    BeanUtils.populate(prj, row);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                lPrj.add(prj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lPrj;
    }

    public Project findByNo(Integer no) {
        Project project=new Project();

        try {
            PreparedStatement stmt=conn.prepareStatement("select * from " + this.tableName + " where no=?;");
            stmt.setInt(1, no);
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData meta=rs.getMetaData();
            while(rs.next()) {
                Map<String, Object> row = new HashMap();

                for(int i = 0; i < meta.getColumnCount(); ++i) {
                    row.put(meta.getColumnName(i + 1), rs.getObject(i + 1));
                }

                try {
                    BeanUtils.populate(project, row);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return project;
    }
}
