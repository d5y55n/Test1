package prac1;



import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import net.coobird.thumbnailator.Thumbnails;


public class ImgReduce 
{
	public static void main(String[] args) 
	{		
		try 
		{
			Scanner scan= new Scanner(System.in);
			
			
			
			while(true)
			{
				System.out.println("크기를 줄일 파일명을 입력해주세요");
				String input=scan.nextLine();
				File inputImage = new File(input); // 원본 이미지 파일 경로
				
				if(input.equals("C:/Dev/Work/java_workspace/ee.png"))
				{
					System.out.println("변환할 크기의 가로픽셀을 입력해주세요: ");
					String width=scan.nextLine();			
					System.out.println("변환할 크기의 세로픽셀을 입력해주세요: ");
					String height=scan.nextLine();
					
					System.out.println("변환할 파일명을 입력해주세요");
					String name=scan.nextLine();
	
					File outputImage = new File("C:/Dev/Work/java_workspace/"+name); // 썸네일 이미지 파일 경로
					int a =Integer.parseInt(width), b=Integer.parseInt(height);
					Thumbnails.of(inputImage).size(a, b).toFile("C:/Dev/Work/java_workspace/"+name);
					
					System.out.println("변환 완료");
					break;
				}
				else System.out.println("재입력");
				
		
				
				if(input.equals(""))
					{System.out.println("종료"); break;}
					
			}

			
			
			
						
		}
		catch(IOException e) 
		{
			System.out.println("오류");
			e.printStackTrace();
		}
		
	}

}
