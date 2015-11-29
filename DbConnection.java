/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection
{
    
    
    static Connection con;
	public static Connection getconnection() throws ClassNotFoundException
	{


		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com/demoprivacy2", "demoprivacy2", "root");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "root");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}
    
    
}
