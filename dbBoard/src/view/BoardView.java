package view;

import java.util.Scanner;

import vo.BoardVO;
import controller.BoardController;

public class BoardView //사용자의 입력을 controller에 전달

{
	BoardController bc = new BoardController();
	
	
	public void signUp(BoardVO vo) //S회원가입
	{
		Scanner scan =new Scanner(System.in);
		
		System.out.println(" ───────────────────");
		System.out.println("        Sign up      ");
		System.out.println(" ───────────────────");
		System.out.println(" 생성할 ID를 입력해주세요");
		
		vo.setId(scan.nextLine());
		
		int a=bc.idCheck(vo.getId());//controller에 값에 따른 중복체크 여부 
		
		if(a==0) //값에 따른 결과 메세지
		{
			System.out.println(" 생성할 PW를 입력해주세요");
			vo.setPw(scan.nextLine());
			
			System.out.println(" 성함을 입력해주세요");
			vo.setName(scan.nextLine());
			
			while(true) 
			{
				System.out.println(" 생년월일 6자리를 입력해주세요");
				vo.setBirth(scan.nextLine());
				
				String birth = vo.getBirth();
				
				if(birth.length()==6 && birth.matches("^[0-9]+$")) 
				{

					bc.signUp(vo);
					break;
				}
				else 
				{
					System.out.println("다시 입력해주세요");
				}
			}
			
			//
			
		}
		else 
		{
		System.out.println("이미 사용 중인 ID입니다. [1]돌아가기 [2]재입력");
		scan.nextLine();
		}
		
		
		
		
		
		
		
		
	}
}
