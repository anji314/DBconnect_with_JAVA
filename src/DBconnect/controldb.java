package DBconnect;
import java.util.Scanner;
public class controldb {
	public static void main(String[] args) { 
		DBconnection t = new DBconnection(); //DAO�� ���� ������ Ȯ���մϴ�. 
		guestbook GB=new guestbook();
		String userid,adduserid,content;
		int ck;
		System.out.println("1�� : ���� ����, 2�� : ���� �߰�\n");
		Scanner sc= new Scanner(System.in);
		ck=sc.nextInt();
		//userid =args[0];
		//adduserid = args[1];
		//content =args[2];
		if(ck==1) {
			System.out.println("id�Է��ϼ���\n");
			Scanner sc2= new Scanner(System.in);
			userid=sc2.next();
		GB.showGB(userid);
		}else {
			System.out.println("���Ϻ������ �����id,�߰��ϴ� �����id,������ �Է��ϼ���\n");
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
