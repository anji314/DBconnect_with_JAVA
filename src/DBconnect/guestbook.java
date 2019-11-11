package DBconnect;
import java.sql.*;



public class guestbook {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://localhost:3306/talkdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //접속할 DB 서버
		
	private final String USER_NAME = "root"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "anji314"; //사용자의 비밀번호를 상수로 정의
	Connection conn ;
	Statement state ;
	ResultSet rs;
	public guestbook() {
		rs=null;
		conn=null;
		state=null;
		try {
		System.out.println("MYSQL open");
		Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		System.out.println("[mysql connetion ]\n");
		state=conn.createStatement();
	}catch(Exception e) {
		System.out.println("처음 오류남");
	}
		
	}
	
	public void showGB(String userid) {
		try {	
		rs=null;
		String sql;
		sql="SELECT * FROM "+userid+"_GBookL";
		rs=state.executeQuery(sql);
		while(rs.next()) {
			String userID=rs.getString("userID");
			String content=rs.getString("content");
			System.out.println("ID : "+userID+"\ncontent : "+content+"\n---------------------------\n");	
			}
		System.out.println("MYSQL Close");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}	
	
	public void addGB(String userid,String adduserid,String addcontent) {
		try {
		String sql;
		System.out.println("추가부분 오류1");
		sql="INSERT INTO "+userid+"_GBookL VALUES('"+adduserid+"','"+addcontent+"');";
		state.executeUpdate(sql);
		System.out.println("추가부분 오류2 MYSQL Close");
		}catch(Exception e) {
			//System.out.println("처음 오류남");
		}
	}
	
	public void closeDB() {
		try {
			rs.close();
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
