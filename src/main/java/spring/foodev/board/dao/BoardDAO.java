package spring.foodev.board.dao;

import java.util.List;

import spring.foodev.board.BoardVO;



public interface BoardDAO {

	public boolean insertBoard(BoardVO vo);
	
	public List<BoardVO> getBoardList(BoardVO vo);
}
