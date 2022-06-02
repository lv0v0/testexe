package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCdemo {

    public static void main(String[] args) {

        {
            //第一步
            //加载具体的驱动类，使用Class.forNmae()方法
            //Sql Server的具体驱动类是：SQLServerDriver
            //MySql的具体驱动类是Driver
            //Oracle的具体驱动类是OracleDriver
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            //第二步
            //连接某个具体数据库需要对应 需要数据库的ip地址、端口号及数据库名字，用户名，密码。它是一个连接字符串，不同的数据库不一样。
            //使用Connection connection =DriverManager.getConnection(dbURL,userName,userPwd);
            String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=exercise_db";

            String userName = "test";  //登录名

            String userPwd = "12345";     //登录密码

            try {
                //第一步，加载具体的驱动类
                Class.forName(driverName);
                System.out.println("加载驱动成功\n");
                //第二步：连接相应的数据库
                Connection connection = DriverManager.getConnection(dbURL, userName, userPwd);
                System.out.println("连接数据库成功");

                //第三步，使用sql语句执行操作
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("连接失败");

            }

        }
    }
}
