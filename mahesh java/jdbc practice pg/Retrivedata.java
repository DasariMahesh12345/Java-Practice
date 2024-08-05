import java.sql.*;
class FIRSTPROGRAMJDBC
{
   public static void main (String args[])
   {

String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:8080/school";
String username = "root";
String password = "mahesh@6282";

try{

//step-1 : regester the driver
//class.forName(driver);

//step-2 : get the connection

Connection con = DriverManager.getConnection(url,username,password);

//step-3 : create the statement object
Statement stmt = con.createStatement();

//step-4 : execute the curry
ResultSet res = stmt.executeQuery("select * from student");

while(res.next())

{
System.out.println(res.getInt(1));
System.out.println(res.getString(2));

}

//step-5 : close the connection
con.close();
}
catch(Exception e)
{
System.out.println(e);
}

  }
}