
<%@page import="org.apache.commons.dbutils.handlers.BeanListHandler"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.SQLException"%>
<%@page import="org.apache.commons.dbutils.handlers.BeanHandler"%>
<%@page import="domain.User"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@page import="utils.C3P0Utils"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>增加如下用户信息:zhangsan 159753 student</h1>

    <%!
        public void addUser() {
            try {
                // 1.创建核心类QueryRunner
                QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
                // 2.编写SQL语句
                String sql = "insert into user values(null,?,?,?)";
                // 3.为站位符设置值
                Object[] params = {"zhangsan", "159753", "student"};
                // 4.执行添加操作
                int rows = qr.update(sql, params);
                if (rows > 0) {
                    System.out.println("添加成功!");
                } else {
                    System.out.println("添加失败!");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    %>
    <body>
        <%
            addUser();
        %>
        <a href="query.jsp">查看当前数据库用户信息</a>
    </body>
</html>
