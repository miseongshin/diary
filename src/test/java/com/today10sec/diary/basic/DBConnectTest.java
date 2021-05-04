package com.today10sec.diary.basic;

import java.sql.*;

public class DBConnectTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/today10secDB";
        String userName = "today";
        String pw = "1234";

        //try with resource java 7
        try(Connection connection = DriverManager.getConnection(url, userName,pw)){
            //System.out.println("Connection Created"+ connection);
            //String sql = " CREATE TABLE ACCOUNT(id int, username varchar(255), password varchar(255))";
            //String sql = " INSERT INTO ACCOUNT VALUES(1,'day', 'pass')";
            String sql =" SELECT * FROM ACCOuNT";
            ResultSet rs ;
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                rs = statement.executeQuery();
                //int result = statement.executeUpdate();
                //System.out.println(result);
                while (rs.next()){
                    System.out.println(rs.getInt("id")+rs.getString("username")+rs.getString("password"));
                }
            }

        }
        //JDBC : 커넥션 만드는 비용이 비쌈 - 오래걸림.
        //스프링 부트 : hicari : 커넥션 객체 미리 만들고 사용. 
    }
}
