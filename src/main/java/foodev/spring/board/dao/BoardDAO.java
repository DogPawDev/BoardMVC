package foodev.spring.board.dao;

import java.util.List;

import foodev.spring.board.BoardVO;



public interface BoardDAO {

	public boolean insertBoard(BoardVO vo);
	
	public List<BoardVO> getBoardList(BoardVO vo);
}
