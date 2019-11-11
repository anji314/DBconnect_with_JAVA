package DBconnect;
import java.sql.*;



public class guestbook {
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹�
	private final String DB_URL = "jdbc:mysql://localhost:3306/talkdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; //������ DB ����
		
	private final String USER_NAME = "root"; //DB�� ������ ����� �̸��� ����� ����
	private final String PASSWORD = "anji314"; //������� ��й�ȣ�� ����� ����
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
		System.out.println("ó�� ������");
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
		System.out.println("�߰��κ� ����1");
		sql="INSERT INTO "+userid+"_GBookL VALUES('"+adduserid+"','"+addcontent+"');";
		state.executeUpdate(sql);
		System.out.println("�߰��κ� ����2 MYSQL Close");
		}catch(Exception e) {
			//System.out.println("ó�� ������");
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
