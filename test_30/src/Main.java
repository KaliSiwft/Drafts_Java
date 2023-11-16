import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test_01?useSSL=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url,"root", "root");
        String query1 = "SELECT * FROM ADMIN";
        String create1 = "create table if not exists admin(id varchar(8), pwd varchar(16))";
        String insert1 = "insert into admin values('666','888')";
        String insert2 = "insert into admin values('tom','888')";
        String update1 = "update admin set id = 'king' where id = 'tom'";
        String delete1 = "delete from admin where id = '666'";
        PreparedStatement ps = connection.prepareStatement(query1);
        ps.executeUpdate(create1);
        for (int i = 0; i < 5; i++) {
            ps.executeUpdate(insert1);
        }
        ps.executeUpdate(insert2);
        ps.executeUpdate(update1);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet != null){
            int columns = resultSet.getMetaData().getColumnCount(); // 获取列数
            while(resultSet.next()){
                if(columns >= 2){
                    System.out.println("id=" + resultSet.getString(1));
                    System.out.println("pwd=" + resultSet.getString(2));
                } else {
                    System.out.println("No data found!");
                    break; //如果没有查询到数据，跳出循环
                }
            }
        } else {
            System.out.println("No data found!");
        }
        //ps.executeUpdate(delete1);

    }
}