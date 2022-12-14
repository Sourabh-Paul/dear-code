//Program to insert image in database.
import java.sql.*;
import java.io.*;
class EleventhProgram{
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Successfully loaded");
		}
		catch(ClassNotFoundException cnf){
			System.out.println("Cannot load the driver class:" +cnf.getMessage());
			System.exit(1);
		}
		Connection conn=null;
		try{
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/xe","rohit","admin");
			PreparedStatement pst=conn.prepareStatement("insert into photos values(?,?)");
			File f=new File("E:/Simant.jpg");
			FileInputStream fis=new FileInputStream(f);
			pst.setString(1,f.getName());
			pst.setBinaryStream(2,fis,(int)f.length());
			int num=pst.executeUpdate();
			System.out.println("Image inserted");
			}
	catch(Exception sq){
		System.out.println("Cannot Communicate with the Database:"+sq.getMessage());
	}
	finally{
		if(conn!=null){
			try{
				conn.close();
			}
		catch(SQLException sq){
			System.out.println("Connot Close the Connection:"+ sq.getMessage());
					}
			}
		}
	}
}