package Logic;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by SmiLeX on 22.11.2017.
 */
public final class DBConnect
{
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public DBConnect()
    {
        URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
        USER = "root";
        PASSWORD = "root";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = (Statement) connection.createStatement();
        } catch (ClassNotFoundException e)
        {
            System.out.println("Error in driver connection: " + e);
        } catch (SQLException e)
        {
            System.out.println("Error in connection to DB: " + e);
        }
    }
    
    public  ObservableList<Student> GetData() throws SQLException
    {
        ObservableList<Student> temp = FXCollections.observableArrayList();
        try
        {
            String query = "select * from student_list.students";
            resultSet = statement.executeQuery(query);
            System.out.println("From base");
           
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int math = resultSet.getInt("math_grade");
                int java = resultSet.getInt("java_grade");
                int physics = resultSet.getInt("physics_grade");
                int economy = resultSet.getInt("economy_grade");
                int math_h = resultSet.getInt("math_hours");
                int java_h = resultSet.getInt("java_hours");
                int economy_h = resultSet.getInt("economy_hours");
                int physics_h = resultSet.getInt("physics_hours");
                System.out.println("ID: " + id + " Name: " + name + " math: " + math + math_h + " java: " + java + " physics: " + physics + " economy: " + economy);
                temp.add(new Student(name, math, math_h, java, java_h, physics, physics_h, economy, economy_h));
            }

        } catch (SQLException e)
        {
            System.out.println("Error in get data: " + e);
        }
        return temp;
    }
    public void Clear()
    {
        try
        {
            statement.execute("DELETE from student_list.students");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void SetData(Student student) throws SQLException
    {
        try
        {
            String INSERT = "INSERT INTO student_list.students (name, math_grade,math_hours, java_grade,java_hours, economy_grade,economy_hours, physics_grade,physics_hours) VALUES (?,?,?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getMath_grade());
            preparedStatement.setInt(3, student.getMath_hours());
            preparedStatement.setInt(4, student.getJava_grade());
            preparedStatement.setInt(5, student.getJava_hours());
            preparedStatement.setInt(6, student.getEconomy_grade());
            preparedStatement.setInt(7, student.getEconomy_hours());
            preparedStatement.setInt(8, student.getPhysics_grade());
            preparedStatement.setInt(9, student.getPhysics_hours());
            preparedStatement.execute();
            UpdateID();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            preparedStatement.close();
        }
    }
    public void UpdateData(Student student, int id) throws SQLException
    {
        try
        {
            String INSERT = "UPDATE student_list.students set name = ?, math_grade = ?,math_hours = ?, java_grade = ?,java_hours = ?," +
                    " economy_grade = ?,economy_hours = ?, physics_grade = ?, physics_hours = ? WHERE id = " + id;
            preparedStatement = (PreparedStatement) connection.prepareStatement(INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getMath_grade());
            preparedStatement.setInt(3, student.getMath_hours());
            preparedStatement.setInt(4, student.getJava_grade());
            preparedStatement.setInt(5, student.getJava_hours());
            preparedStatement.setInt(6, student.getEconomy_grade());
            preparedStatement.setInt(7, student.getEconomy_hours());
            preparedStatement.setInt(8, student.getPhysics_grade());
            preparedStatement.setInt(9, student.getPhysics_hours());
            preparedStatement.execute();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            preparedStatement.close();
        }
    }
    public void UpdateID()
    {
        try
        {
            statement.addBatch("SET @id=0;");
            statement.addBatch("update student_list.students set id=@id:=@id+1 ");
            statement.executeBatch();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void DeleteBelow3()
    {
        try
        {
            statement.execute("DELETE from student_list.students WHERE (math_grade <=3 or math_grade = 0) or (physics_grade <=3 or physics_grade = 0)" +
                    " OR (economy_grade <=3 or economy_grade = 0) OR (java_grade <= 3 or java_grade = 0)");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}