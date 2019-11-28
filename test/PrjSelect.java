import com.bk.prj.dao.ProjectDAO;
import com.bk.prj.entity.Project;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

public class PrjSelect {

    public static void main(String[] args) {
        ProjectDAO projectDAO=new ProjectDAO();
//        try {
//            projectDAO.connect();
//            List<Project> lPrj=projectDAO.selectAll();
//
//            Gson gson=new Gson();
//            System.out.println(gson.toJson(lPrj));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            projectDAO.disconnect();
//        }
        try {
            projectDAO.connect();
            Project project=projectDAO.findByNo(1);
            System.out.println(project);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            projectDAO.disconnect();
        }
    }
}
