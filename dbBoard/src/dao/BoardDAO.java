package dao;

import java.awt.dnd.DropTargetContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vo.BoardVO;

public class BoardDAO 
{
	String DB_URL="jdbc:mysql://localhost:3306/prac";
	String DB_NAME="root";
	String DB_PW="1234";
	
	//db연결
	public Connection getConnection()
	{
		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로드 성공!");
        return DriverManager.getConnection(DB_URL, DB_NAME, DB_PW);}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
    }
	
	
	
	
	//회원가입
	public void signUp(BoardVO vo) 
	{
		
		
		try 
			(Connection conn = getConnection();
			PreparedStatement pstmt=conn.prepareStatement("insert into user(id,pw,name,birth) values(?,?,?,?)"))
			{
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPw());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getBirth());
				pstmt.executeUpdate();
				
				System.out.println("가입성공");
				
			} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	//id중복확인
	public int idCheck(String id) 
	{
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt=conn.prepareStatement("select id from user where id=?");
			)
			{
			pstmt.setString(1, id);
			
			int a=0;
			
				try(ResultSet rs =pstmt.executeQuery())
				{
				
					while(rs.next()) 
					{
						a=1;
						return a;
					}
				}
				return a;
				
			}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
}
