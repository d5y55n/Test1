package service;

import dao.BoardDAO;
import vo.BoardVO;

public class BoardService 
{
	BoardDAO dao= new BoardDAO();
	BoardVO vo = new BoardVO();
	
	
	//1.회원가입
	public void signUp(BoardVO vo) 
	{		
		dao.signUp(vo);
	}
	
	//1)id중복체크
	public int idCheck(String id) 
	{
		int a= dao.idCheck(id);
		return a;
	}
}
