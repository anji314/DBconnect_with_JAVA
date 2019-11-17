package DBconnect;

import java.sql.*;

public class FriendList {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹�
	private final String DB_URL = "jdbc:mysql://localhost:3306/talkdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //������ DB ����
		
	private final String USER_NAME = "root"; //DB�� ������ ����� �̸��� ����� ����
	private final String PASSWORD = "anji314"; //������� ��й�ȣ�� ����� ����
	Connection conn ;
	Statement state ;
	ResultSet rs;
	ResultSet rrs;
	public FriendList() {
		rs=null;
		rrs=null;
		conn =null;
		state =null;
		try {
			System.out.println("MYSQL open");
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			System.out.println("[mysql connetion ]\n");
			state=conn.createStatement();
			
			
			
		}catch(Exception e) {
			//System.out.println("ó�� ������");
			System.out.println("MYSQL Close����?");
		}finally {
		}
	}
	
	
	public void showlist(String userid) {
		try {
			String sql;
			sql="SELECT * FROM "+userid+"_FriendList as F,user_id as U WHERE F.Fname=U.Name";
			rs=state.executeQuery(sql);
			//int rs.c
			while(rs.next()) {
				//try {
				String FID=rs.getString("FID");
				String FName=rs.getString("FName");
				int Fonline=rs.getInt("online");
				System.out.println("FID : "+FID+"\nFName : "+FName+"\nOnline : "+Fonline+"\n---------------------------\n");
				
			}
		}catch(Exception e) {
			System.out.println("ó�� �������ƴԿ���");
		}
		
	}
	
	
	
	
	public void close() {
		try {
			rs.close();
			state.close();
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
