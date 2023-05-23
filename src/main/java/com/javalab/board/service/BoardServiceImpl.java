package com.javalab.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalab.board.dao.BoardDao;
import com.javalab.board.vo.BoardVo;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	// 멤버 변수로 Dao 단의 빈이 자동 주입됨(DI)
	@Autowired
	private BoardDao boardDao;

	public BoardServiceImpl() {
		super();
		System.out.println("여기는 BoardServiceImple 기본 생성자");
	}

	// 게시물 목록조회
	@Override
	public ArrayList<BoardVo> selectBoardList() {
		ArrayList<BoardVo> boardList = boardDao.selectBoardList();
		return boardList;
	}

	// 게시물 삭제
	@Override
	public int deleteBoard(int no) {
		int result = 0;
		result = boardDao.deleteBoard(no);
		return result;
	}

	// 게시물 한개 조회
	@Override
	public BoardVo getBoardById(int no) {
		BoardVo boardVo = null;
		updateHitCount(no);
		boardVo = boardDao.getBoardById(no);
		return boardVo;
	}

	// 게시물 수정
	@Override
	public int modifyBoard(BoardVo boardVo) {
		int result = 0;
		result = boardDao.modifyBoard(boardVo);
		return result;
	}

	// 게시물 등록
	@Override
	public int insertBoard(BoardVo vo) {
		int result = 0;
		result = boardDao.insertBoard(vo);
		return result;
	}

	// 게시물 조회수 증가
	@Override
	public void updateHitCount(int no) {
		boardDao.updateHitCount(no);
	}

}
