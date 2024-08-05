//sql injuction
import java.sql.*;
import java.io.*;

class sqlinjuction
{
   public static void main (String args[])
   {

String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:8080/school";
String username = "root";
String password = "mahesh@6282";

try{

InputStreamReader i = new InputStreamReader(System.in);
BufferedReader b = new BufferedReader(i);

System.out.println("please enter your rollno");
String rollno = b.readLine();

System.out.println("please enter your name");
String name = b.readLine();

//step-1 : regester the driver
//class.forName(driver);

//step-2 : get the connection

Connection con = DriverManager.getConnection(url,username,password);

//step-3 : create the statement object
Statement stmt = con.createStatement();

//step-4 : execute the curry

String qry ="insert into student values("+rollno+","+name+")";
Syten.out.println("our query is :"+qry);
stmt.executeUpdate("qry");

//step-5 : close the connection
con.close();
}
catch(Exception e)
{
System.out.println(e);
}

  }
}