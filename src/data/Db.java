package data;

import java.sql.*;

public class Db
{
    private String connectionString = "jdbc:ucanaccess://C:/Users/Мария/Desktop/Market.mdb";
    public Connection Conn;
    public Db() throws ClassNotFoundException
    {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    }

    public void OpenConnection() throws SQLException
    {
        Conn = DriverManager.getConnection(connectionString);

    }

    public void CloseConnection() throws SQLException
    {
        Conn.close();
    }

    public static Stack<Product> GetStackFromDB()
    {
        Stack<Product> stack = new Stack<>();
        try
        {
            Db db = new Db();
            db.OpenConnection();
            Statement stmt = db.Conn.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT * FROM [Product]");
            while(executeQuery.next())
            {
                Product temp = new Product();
                temp.Id = executeQuery.getString("Product_id");
                temp.Name = executeQuery.getString("Product_name");
                temp.Price = executeQuery.getString("Product_price");
                stack.Push(temp);
            }
            stmt.close();
            executeQuery.close();
            db.CloseConnection();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return stack;
    }
}
