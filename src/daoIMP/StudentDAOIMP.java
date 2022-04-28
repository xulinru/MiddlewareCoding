package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{

    // 添加操作
    public void insert(Student s){
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //针对数据库的具体操作
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2,s.getName());

            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstmt!=null){
                try{
                    pstmt.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Student s){
        String sql = "update student set iD=? name=?  where iD =?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;


        try
        {
            conn = new DataBaseConnection();


            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, s.getID());
            pstmt.setString(2,s.getName());
            pstmt.setLong(3,s.getID());


            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstmt!=null){
                try{
                    pstmt.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }



    public void delete(long iD){
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        String sql="delete from student where id=?";
        try
        {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);


            pstmt.setLong(1,iD);

            pstmt.executeUpdate();
            //pstmt.close();
            //conn.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }finally{
            if(pstmt!=null){
                try{
                    pstmt.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    public List findAll() {
        String sql = "select * from student";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        ResultSet rs=null;
        List<Student> studentList = new ArrayList<>();
        try {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getLong("iD"),
                        rs.getString("name")
                );
                studentList.add(student);
            }


            //pstmt.close();
            //conn.close();
            //rs.next();

        } catch (Exception e) {
            e.printStackTrace();

        }finally{

            if(rs!=null){
                try{
                    rs.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            if(pstmt!=null){
                try{
                    pstmt.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }

    public Student findByID(long iD){
        Student student=new Student();
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        ResultSet rs=null;
        String  sql = "select * from student where id=?";

        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);

            pstmt.setLong(1,iD);

            rs= pstmt.executeQuery();


            while (rs.next()) {
                Long id=rs.getLong("iD");
                String name=rs.getString("name");

                student.setID(id);
                student.setName(name);
                //执行SQL语句查找到了数据，就把数据和实体类的一个对象映射起来。
            }


            //pstmt.close();
            //conn.close();
            //rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

            if(rs!=null){
                try{
                    rs.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            if(pstmt!=null){
                try{
                    pstmt.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return student;


    }

}
