package BoardTest;

import vo.BoardVO;
import view.BoardView;

public class BoardTest 
{
	
	public static void main(String[] args) 
	{
		BoardVO vo=new BoardVO();
		BoardView vi = new BoardView();
		
		vi.signUp(vo);
		

	}

}
