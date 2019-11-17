package DBconnect;

import java.sql.*;

public class FriendList {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://localhost:3306/talkdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //접속할 DB 서버
		
	private final String USER_NAME = "root"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "anji314"; //사용자의 비밀번호를 상수로 정의
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
			//System.out.println("처음 오류남");
			System.out.println("MYSQL Close여기?");
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
			System.out.println("처음 오류남아님여기");
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
