package DBconnect;
import java.util.Scanner;
public class controldb {
	public static void main(String[] args) { 
		DBconnection t = new DBconnection(); //DAO를 통해 접속을 확인합니다. 
		guestbook GB=new guestbook();
		String userid,adduserid,content;
		int ck;
		System.out.println("1번 : 방명록 보기, 2번 : 방명록 추가\n");
		Scanner sc= new Scanner(System.in);
		ck=sc.nextInt();
		//userid =args[0];
		//adduserid = args[1];
		//content =args[2];
		if(ck==1) {
			System.out.println("id입력하세요\n");
			Scanner sc2= new Scanner(System.in);
			userid=sc2.next();
		GB.showGB(userid);
		}else {
			System.out.println("방명록보고싶은 사용자id,추가하는 사용자id,내용을 입력하세요\n");
			Scanner sc3= new Scanner(System.in);
			userid=sc3.next();
			adduserid=sc3.next();
			content=sc3.next();
			//System.out.println(userid+"\n"+adduserid+"\n"+content+"\n");
			GB.addGB(userid, adduserid,content);
			GB.showGB(userid);
		}
	}

	
}
