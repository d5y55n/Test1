package board;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.ArrayList;


public class Board1 
{
	Scanner scan=new Scanner(System.in);
	Map<String, String[]> user = new HashMap<>();
	List<String[]> board=new ArrayList<>();
	static final String USER_DATA_FILE="user data.txt";
	static final String WRITE_DATA_FILE="write data.txt";
	
	
	void home()//홈화면
	{
		String non ="";
		do 
		{
			//타이틀
			System.out.println("────────────────────────────────────────────────────────────");
			System.out.println("                     NAVER (네이버 맞음)                        ");
			System.out.println("────────────────────────────────────────────────────────────");
					
			//로그인 상태창
			System.out.print("──────────────");		System.out.println(" ──────────────────────────────"); 
			System.out.print("    미접속중    │");		System.out.println("              자유게시판          ");
			System.out.print("              │");	System.out.println("──────────────────────────────");
			System.out.print("──────────────");		System.out.println("  [ Write ]");
			
			//로그인
			System.out.print("──────────────");       System.out.println("  ──────────────────────────────");
														int i=1;
			System.out.print("     Log in   │");    for(String[] post : board) 
													{		
														if(i==1)
															{System.out.println(" "+i+"."+post[0]);}
														else{System.out.println("                "+i+"."+post[0]);}
														i++;
													}
			
			System.out.println("──────────────");
			
			//회원가입
			System.out.println("──────────────");
			System.out.println("   Sign up    │");
			System.out.println("──────────────");
			
			//아디찾기
			System.out.println("──────────────");
			System.out.println(" Forgot id/pw │");
			System.out.println("──────────────");
			
			System.out.println("---키를 입력해주세요. (L,S,F,W,[1~n])---");
			String input=scan.nextLine();
			
			if(input.equals("L"))
			{
				login();
			}
			
			else if(input.equals("S")) 
			{
				signUp();
			}
			
			else if(input.equals("F")) 
			{
				finder();
			}
			
			else if(input.equals("W")) 
			{
				System.out.println("-권한이 없습니다-");
				System.out.println("[any key]홈으로 이동");
				scan.nextLine();
				home();
			}
			else
			{
				try 
				{
					int a=Integer.parseInt(input);
					viewPost(a, non);
				}
				catch(IndexOutOfBoundsException e) 
				{
					System.out.println("오류");
					System.out.println("[any key]홈으로 이동");
					scan.nextLine();
					home();
				}
				catch(NumberFormatException e) 
				{
					System.out.println("오류");
					System.out.println("[any key]홈으로 이동");
					scan.nextLine();
					home();
				}
			}
			
			
			
		}
		while(true);
			
		
	}
	
	void loginHome(String id)//로그인홈화면
	{

		do 
		{
			//타이틀
			System.out.println("────────────────────────────────────────────────────────────");
			System.out.println("                     NAVER(네이버 맞음)                        ");
			System.out.println("────────────────────────────────────────────────────────────");
					
			//로그인 상태창
			System.out.print("──────────────");		System.out.println(" ──────────────────────────────"); 
			System.out.print("  "+id+"님  │" );		System.out.println("              자유게시판          ");
			System.out.print("     접속중     │");	System.out.println("──────────────────────────────");
			System.out.print("──────────────");		System.out.println("  [ Write ]");
			
			//로그인
			System.out.print("──────────────");   System.out.println("  ──────────────────────────────");
													
			System.out.print("   Log out    │"); int i=1; 
												for(String[] post : board) 
												{		
													if(i==1)
														{System.out.println(" "+i+"."+post[0]);}
													else{System.out.println("                "+i+"."+post[0]);}
													i++;
												}
			//회원가입
			System.out.println("──────────────");
			System.out.println("    Del id    │");
			System.out.println("──────────────");
			
			//회원가입
			System.out.println("──────────────");
			System.out.println(" Forgot id/pw │");
			System.out.println("──────────────");
			
			System.out.println("---키를 입력해주세요. (L,D,F,W,[1~n])---");
			String input=scan.nextLine();
			
			if(input.equals("L")) //로그아웃
			{
				home();
				break;
			}
			
			else if(input.equals("D")) 
			{
				deleteID(id);
			}
			
			else if(input.equals("W")) 
			{
				write();
			}
			else
			{
				try 
				{
					int a=Integer.parseInt(input);
					viewPost(a, id);
				}
				catch(IndexOutOfBoundsException e) 
				{
					System.out.println("오류");
					System.out.println("[any key]홈으로 이동");
					scan.nextLine();
					loginHome(id);
				}
				catch(NumberFormatException e) 
				{
					System.out.println("오류");
					System.out.println("[any key]홈으로 이동");
					scan.nextLine();
					loginHome(id);
				}
			}

			
		}while(true);
			
		
	}
	
	
	
	void login() //L로그인
	{
		System.out.println(" ───────────────────");
		System.out.println("        Log in     ");
		System.out.println(" ───────────────────");
		System.out.print("ID:");	String id=scan.nextLine();
		System.out.print("PW:");	String pw=scan.nextLine();
		
		//회원 체크
		for(Map.Entry<String, String[]> entry : user.entrySet())
		{
			if(id.equals(entry.getKey())) 
			{
				String [] pwcheck =entry.getValue();
				if(pw.equals(pwcheck[0])) 
				{
					System.out.println("로그인 성공");
					
					loginHome(id);
					break;
				}
				else 
				{
					System.out.println("아이디와 패스워드를 확인해주세요.[r]재입력 [any key]홈으로 돌아가기 "); 
					String input = scan.nextLine();
					
					if(input.equals("r")) 
					{
						login();
					}
					else 
					{
						home();
					}
				}
			}
			
		}
			System.out.println("아이디와 패스워드를 확인해주세요.[r]재입력 [any key]홈으로 돌아가기 "); 
			String input = scan.nextLine();
			
			if(input.equals("r")) 
			{
				login();
			}
			else 
			{
				home();
			}
	}
	
	
	void signUp() //S회원가입
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
		
		System.out.println(" 성함을 입력해주세요");
		String name=scan.nextLine();
		String birth;
		
		
		while(true) 
		{
			System.out.println(" 생년월일 6자리를 입력해주세요");
			birth=scan.nextLine();
			if(birth.length()==6 && birth.matches("^[0-9]+$")) 
			{
				break;
			}
			else 
			{
				System.out.println("다시 입력해주세요");
			}
		}
		
		user.put(newId, new String[]{newPw,name,birth}); //매핑
		saveUser(); //파일저장
		
		
	}
	
	void loadUser() //Data 회원정보 불러오기
	{
		
		try(BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE)))
		{
			String line;
			while((line=reader.readLine())!=null) 
			{
				String[] parts=line.split(":");
				if(parts.length==4) 
				{
					String id= parts[0];
					String pw= parts[1];
					String name= parts[2];
					String birth= parts[3];
					
					user.put(id, new String[]{pw, name, birth});
				}
				
			}
			reader.close();
		}
		catch(IOException e) 
		{

			System.out.println(System.getProperty("user.dir"));
			System.out.println("회원 정보 로드 실패");
			
			e.printStackTrace();
		}
	}
	
	void saveUser() //Data 회원목록 저장 

	
	{
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(USER_DATA_FILE)))
		{
			for(Map.Entry<String, String[]> entry : user.entrySet())
			{
				String[] userInfo=entry.getValue();
				writer.write(entry.getKey()+":"+userInfo[0]+":"+userInfo[1]+":"+userInfo[2]);
				
				writer.newLine();
			}
			System.out.println("회원 정보를 저장했습니다.");
			writer.close();
			home();
		}
		catch(IOException e) 
		{
			System.out.println("회원 정보를 저장하는데 실패 했습니다.");
			
		}
		
			
		
	}
	
	
	void finder() //F 아디비번찾기
	{
		System.out.println(" ───────────────────");
		System.out.println("      아디 비번찾기    ");
		System.out.println(" ───────────────────");
		System.out.println("성함을 입력해주세요");
		String name=scan.nextLine();
		
		System.out.println("생년월일을 입력해주세요");
		String birth=scan.nextLine();
		
		
		for(Map.Entry<String, String[]> entry : user.entrySet())
		{
			String key=entry.getKey();
			String[] data=entry.getValue();
			
			if(name.equals(data[1]) && birth.equals(data[2])) 
			{
				System.out.println(name+"님의 id와 pw는 아래와 같습니다");
				System.out.println("id : "+key);
				System.out.println("pw : "+data[0]);
			}
			
			System.out.println("[any key]홈으로 이동");
			scan.nextLine();
			home();
			
		}
		
	}
	
	
	void deleteID(String id)  //D회원탈퇴
	{
		System.out.println(" ───────────────────");
		System.out.println("       계정 삭제     ");
		System.out.println(" ───────────────────");
		System.out.println("비밀번호를 입력해주세요");
		String pw=scan.next();
		System.out.println("성함을 입력해주세요");
		String name=scan.next();
		
		String[] data=user.get(id);
		
		if(pw.equals(data[0]) && name.equals(data[1])) 
		{
			
			user.remove(id);
			saveUser();
			System.out.println("삭제 되었습니다 [any key]홈으로 이동");
			scan.nextLine();
			home();
		}
		else 
		{
			System.out.println("입력된 정보와 일치하지 않습니다.[any key]홈으로 이동 "); 
			String input = scan.nextLine();
			home();		
		}
	}
	
	
	void write() //W글쓰기
	{
		
		System.out.println(" ──────────────────────────────");
		System.out.println("           자유게시판  ");
		System.out.println(" ──────────────────────────────");
		System.out.print("제목 : "); String title=scan.nextLine();
		System.out.print("내용 : "); String content=scan.nextLine();
		
		System.out.println("등록 하시겠습니까? Y/N");
		String input=scan.nextLine();
		
		if(input.equals("Y"))
		{
			savePost(title,content);
			loadPost();
		}
		else 
		{
			
		}
			
			
	}
	
	void savePost(String title, String content) //Data 글 저장
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(WRITE_DATA_FILE,true)))
		{
			writer.write(title+":"+content);
			writer.newLine();
		}
		catch(IOException e) 
		{
			System.out.println("등록 실패!");
			e.printStackTrace();
		}
	}
	
	void loadPost() //Data 글 로드
	{
		board.clear();
		try (BufferedReader reader= new BufferedReader(new FileReader(WRITE_DATA_FILE)))
		{
			String line;
			while((line=reader.readLine())!=null) 
			{
				String[] parts=line.split(":");
				if(parts.length==2) 
				{
					String title=parts[0];
					String content=parts[1];
					String[] result= {title,content};
					board.add(result);
				}
			}
			reader.close();
		}
	    catch (IOException e) 
		{
	        System.out.println("게시글 정보 로드 실패");
	        e.printStackTrace();
        }
	}
	
	
	void viewPost(int number, String id) //[1~n] 글 보기 
	{
		String[] pos = board.get(number-1);
		System.out.println(" ──────────────────────────────");
		System.out.println("           자유게시판   ");
		System.out.println(" ──────────────────────────────");
		System.out.println("제목 : "+pos[0]);
		System.out.println("내용 : "+pos[1]);
		System.out.println(" ");
		System.out.println("[any key]홈으로");
		scan.nextLine();
		if(id!=null)
		{
			loginHome(id);
		}
		else 
		{
			home();
		}
	}
}
