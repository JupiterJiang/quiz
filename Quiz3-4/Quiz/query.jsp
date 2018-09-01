
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
    <h1>已完成查询，当前数据库用户信息如下</h1>

    <%!
        public String queryAll() {
            StringBuffer result = new StringBuffer();
            try {
                //1 获取核心类
                QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
                //2 编写sql语句
                String sql = "select * from user";
                //3 执行查询语句
                List<User> users = qr.query(sql, new BeanListHandler<>(User.class));
                //4 对结果集进行遍历
                for (User user : users) {
                    result.append(user.getUname() + ":" + user.getUpassword() + "\r\n");
                }
            } catch (SQLException ex) {

            }
            return result.toString();
        }
    %>
    <body>
        <%
            out.print(queryAll());
        %>
        <br />
        <a href="index.html">return homepage</a>
    </body>
</html>
