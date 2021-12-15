package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcManager {
	//Need to update these once the db_init script is done
  private String jdbcUrl = "jdbc:mysql://localhost:3306/provisio?useSSL=false";
  private String jdbcUserName = "provisio_user";
  private String jdbcPassword = "provisiopass";
  
  public JdbcManager() {
  
  try {
	  Class.forName("com.mysql.jdbc.Driver");  
  }
  catch(Exception e) {
	  System.out.println(e);
  }
  }
  public Connection getConn() {
	  Connection Conn=null;
	  try {
		  Conn=DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		  
	  }
	  catch (Exception e){
		  System.out.println(e);
	  }
	  return Conn;
  }
  public void closeConn(Connection Conn) {
	  try {
		  Conn.close();
	  }
	  catch(Exception e) {
		  System.out.println(e);
	  }
  }
}
