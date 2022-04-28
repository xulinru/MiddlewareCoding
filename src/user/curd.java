package User;

import bean.Student;
import dao.StudentDAO;
import daoIMP.StudentDAOIMP;

import java.util.List;

public class curd {
    public static void main(String[] args) {
        StudentDAO dao=new StudentDAOIMP();
        List<Student> list= dao.findAll();

        for(Student stu:list){
            System.out.println("id:"+stu.getID()+"\t"+"name:"+stu.getName());
        }
    }
}
