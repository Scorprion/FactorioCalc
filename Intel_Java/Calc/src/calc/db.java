package calc;

import java.sql.*;

public class db {
    public static String ident;
    public static String equat;
    public static String ct;
    public db() {
        ResultSet fac = getfactorio();
        try {
            while (fac.next())
            {
                Item f = getfactorio(fac);
                ident = Integer.toString(f.Id);
                ident += ": " + f.ItemName;
                equat = f.Equation;
                ct = Integer.toString(f.Ct);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    private static ResultSet getfactorio() {
        Connection con = getConnection();
        try {
            Statement s = con.createStatement();
            String select = "SELECT id, item_name, equation, ct "
                    + "FROM Items WHERE id = 1";
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
            String url = "jdbc:mysql://localhost/factorio?useSSL=false";
            String user = "root";
            String pw = "nuri2105";
            con = DriverManager.getConnection(url, user, pw);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found Exception");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }

    private static Item getfactorio(ResultSet fac) {
        try
        {
            int id = fac.getInt("id");
            String item_name = fac.getString("item_name");
            String equation = fac.getString("equation");
            int ct = fac.getInt("ct");
            //forgot last time
            return new Item(id, item_name, equation, ct);
        }
        catch (SQLException e) {
            System.err.println("Something went wrong D:");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static String getIdent() { return ident; }
    public static void setIdent(String m) {
        ident = m;
    }
    public static String getEquat() {
        return equat;
    }
    public static void setEquat(String e) { equat = e; }
    public static String getCt() { return ct; }
    public static void setCt(String c) { ct = c; }
}
