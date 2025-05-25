package controller;
import view.BoardView;
import vo.BoardVO;
import dao.BoardDAO;
import service.BoardService;

public class BoardController 
{
	BoardVO vo = new BoardVO();
	BoardDAO dao= new BoardDAO();
	BoardService bs= new BoardService();
	
	//1.회원가입
	
	public void signUp(BoardVO vo) 
	{
		bs.signUp(vo);
	}
	//1).중복체크
	public int idCheck(String id) 
	{
		int a=bs.idCheck(id);
		return a;
	}
}
