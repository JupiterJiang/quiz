
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
    <h1>将Tom的密码改为888888</h1>
    <%!
        public void update() {
            try {
                // 1.创建核心类QueryRunner
                QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
                // 2.编写SQL语句
                String sql = "update user set upassword=? where uname=?";
                // 3.为站位符设置值
                Object[] params = {"888888", "Tom"};
                // 4.执行添加操作
                int rows = qr.update(sql, params);
                if (rows > 0) {
                    System.out.println("修改成功!");
                } else {
                    System.out.println("修改失败!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>
    <body>
        <%
            update();
        %>
                <a href="query.jsp">查看当前数据库用户信息</a>
    </body>
</html>
