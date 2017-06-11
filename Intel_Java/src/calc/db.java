package calc;

import java.sql.*;

public class db {
    public static String msg;
    public static void main() {
        ResultSet fac = getFactorio();
        try {
            while (fac.next())
            {
                Factorio f = getFactorio(fac);
                String msg = Integer.toString(f.id);
                msg += ": " + f.item_name;
                msg += " = " + f.equation;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    private static ResultSet getFactorio() {
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            String select = "SELECT id, item_name, equation "
                    + "FROM Items WHERE id = " + Calc.getSelection();
            ResultSet rows;
            rows = s.executeQuery(select);
            return rows;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Connection getConnection() {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Factorio?useSSL=false";
            String user = "root";
            String pw = "nuri2105";
            con = DriverManager.getConnection(url, user, pw);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }

    private static Factorio getFactorio(ResultSet fac) {
        try
        {
            int id = fac.getInt("id");
            String item_name = fac.getString("item_name");
            String equation = fac.getString("equation");
            //forgot last time
            return new Factorio(id, item_name, equation);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static class Factorio {
        public String item_name;
        public String equation;
        public int id;
        public Factorio(int id, String item_name, String equation) {
            this.id = id;
            this.item_name = item_name;
            this.equation = equation;
        }
    }
    public static String getMsg() {
        return msg;
    }
    public static void setMsg(String m) {
        msg = m;
    }
}
