package Prac1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class WeekTest 
{
	static List<String> list = new ArrayList<>(); //static 
	static final String df = "Data File.txt"; //저장할 파일 이름
	static Scanner scan=new Scanner(System.in);
	static String line;
	
	static void loadFile() //파일 로드
	{		
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(df)/*df에지정된 파일을 연다*/);
							/*FileReader가 생성한 문자스트림을 인자로 받습니다*/
			//BufferReader는 버퍼기능(문자를 효율적으로 처리)을 갖춘 객체
			
			
			while((line=reader.readLine())!=null) 
				//readLine()은 반복호출 될떄마다 다음줄로 포인터를 바꿈, 파일끝에서 null 값을 반환함)
				
			{
				list.add(line);
			}
			System.out.println("로드 성공");
		}
		catch(IOException e)
		{							
			System.out.println("로드 실패");
		}
			
			
		
	}		
	
	//파일 저장 메서드
	static void saveFile() 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(df));
			//FileWriter가 가져온 파일을 쓸 준비
			
			for(String line: list) 
			{
				writer.write(line);
				writer.newLine();
			}
			System.out.println("저장 성공");
			
		}
		catch(IOException e) 
		{
			System.out.println("저장 실패");
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		System.out.println("현재 작업 디렉토리: " + System.getProperty("user.dir"));
		loadFile(); //파일 로드
		 System.out.println("\n--- 저장된 값 출력 ---");
		    for (String item : list) {
		        System.out.println(item);
		    }
		String input; //입력
		
		while(true) 
		{
			System.out.println("문자를 입력해 주세요/ 종료0번 : ");
			
			input=scan.nextLine();
			
			if(input.equals("0"))break;
			
			list.add(input);    //입력값 리스트화
		}
		
		saveFile(); //종료시 파일 저장
		
	}
}
	
