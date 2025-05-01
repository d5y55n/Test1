package board;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class Board1 
{
	Scanner scan=new Scanner(System.in);
	Map<String, String> user = new HashMap<>();
	static final String USER_DATA_FILE="user data.txt";
	
	
	void home()//홈화면
	{
		//타이틀
		System.out.println("────────────────────────────────────────────────────────────");
		System.out.println("                     음 그래그래 어서오고                        ");
		System.out.println("────────────────────────────────────────────────────────────");
				
		//로그인 상태창
		System.out.print("──────────────");		System.out.println(" ──────────────────────────────"); 
		System.out.print("    비접속중    │");		System.out.println("              자유게시판          ");
		System.out.print("              │");	System.out.println("──────────────────────────────");
		System.out.print("──────────────");		System.out.println("  [ Write ]");
		
		//로그인
		System.out.print("──────────────");   System.out.println("  ──────────────────────────────");
		System.out.println("     Log in   │");
		System.out.println("──────────────");
		
		//회원가입
		System.out.println("──────────────");
		System.out.println("   Sign up    │");
		System.out.println("──────────────");
		
		//회원가입
		System.out.println("──────────────");
		System.out.println(" Forgot id/pw │");
		System.out.println("──────────────");
		
		System.out.println("---키를 입력해주세요. (L,S,F,W,[1~n])---");
		String input=scan.nextLine();
		
		if(input.equals("L"))
		{
			login();
		}
		
		if(input.equals("S")) 
		{
			signUp();
		}
		
	}
	
	
	
	void login() //로그인 화면
	{
		System.out.println(" ───────────────────");
		System.out.println("        Log in     ");
		System.out.println(" ───────────────────");
		System.out.print("ID:");	String id=scan.nextLine();
		System.out.print("PW:");	String pw=scan.nextLine();
	}
	
	
	void signUp() //회원가입
	{
		System.out.println(" ───────────────────");
		System.out.println("        Sign up      ");
		System.out.println(" ───────────────────");
		System.out.println(" 생성할 ID를 입력해주세요");
		String newId=scan.nextLine();
		
		//id 중복확인
		if(user.containsKey(newId)) 
		{
			System.out.println("이미 사용 중인 ID입니다. [1]돌아가기 [2]재입력");
			String input=scan.nextLine();
			int a = Integer.parseInt(input);
			
			if(a==1)
			{
				home();
			}
			else if(a==2)
			{
				signUp();
			}
		}
		
		System.out.println(" 생성할 PW를 입력해주세요");
		String newPw=scan.nextLine();
		
		user.put(newId, newPw); //매핑
		saveUser(); //파일저장
		
		
	}
	
	void loadUser() //회원정보 불러오기
	{
		
		try(BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE)))
		{
			String line;
			while((line=reader.readLine())!=null) 
			{
				String[] parts=line.split(":");
				if(parts.length==2) 
				{
					String id= parts[0];
					String pw= parts[1];
					
					user.put(id, pw);
				}
				
			}
			System.out.println("회원 정보를 로드했습니다.");
			reader.close();
		}
		catch(IOException e) 
		{

			System.getProperty("user.dir");
			System.out.println("회원 정보 로드 실패");
			
			e.printStackTrace();
		}
	}
	
	void saveUser() //회원목록 저장 
	{
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(USER_DATA_FILE)))
		{
			for(Map.Entry<String, String> entry : user.entrySet())
			{
				writer.write(entry.getKey()+":"+entry.getValue());
				writer.newLine();
			}
			System.out.println("회원 정보를 저장했습니다.");
			writer.close();
		}
		catch(IOException e) 
		{
			System.out.println("회원 정보를 저장하는데 실패 했습니다.");
			
		}
		
			
		
	}
	
}
