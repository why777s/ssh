package Controller;

import Entity.Student;
import Service.impl.StudentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class loginAction extends ActionSupport {
    private String userID;
    private String password;
    private StudentServiceImpl studentService;

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        if (getUserID().equals("admin")){
            return SUCCESS;
        }else
            return ERROR;
    }


    public String studentLogin() throws Exception{
        Student student = new Student();
        student.setSid(getUserID());
        student.setPassword(getPassword());
        if (studentService.login(student)){
            // 将用户登录的ID存到session中
//            HttpSession session = ServletActionContext.getRequest().getSession();
//            session.setAttribute("userID",student.getSid());
//            session.getAttribute("userID");
            //新建一个session
            ActionContext actionContext = ActionContext.getContext();
            Map<String,Object> session = actionContext.getSession();
            session.put("userID",student.getSid());
            session.put("userName",student.getSname());


            return SUCCESS;
        }
        else
            return ERROR;

    }

}