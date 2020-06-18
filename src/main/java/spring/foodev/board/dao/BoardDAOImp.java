package spring.foodev.board.dao;

import java.util.List;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.foodev.board.BoardVO;




@Repository
public class BoardDAOImp implements BoardDAO {

	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "spring.foodev.mappers.BoardMapper";
	
	
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
	try {
		sqlSession.insert(NAMESPACE+".insertBoard",vo);	
		}catch (Exception e) {
			
			return false;
		// TODO: handle exception
		}
		
		return true;
		
	}



	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
	
		return sqlSession.selectList(NAMESPACE+".getBoardList",vo);
		
		
	}
}
