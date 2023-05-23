package com.javalab.board.dao;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.board.vo.BoardVo;


/*
 * junit 단위테스트 클래스
 * - 테스트 클래스는 `BoardDao` 클래스와 동일한 패키지에 위치
 * (src/test/java)
 * @Test : 테스트 케이스 작성, 각 메소드가 junit 테스트 클래스임을 명시
 * @Ignore : 이 메소드는 테스트에서 제외
 * 두 개를 같이 쓰면 테스트에서 제외됨(ex. @Test @Ignore)
 * @Before : 테스트를 하기 전에 반드시 거쳐야 하는 부분을 기재
 * assertNotNull(검증 객체) : 괄호 안에 있는 객체가 널이 아닐 것이라고
 * - 널이 아니면 true 널이면 false가 됨.
 * @RunWith(SpringJUnit4ClassRunner.class)
 * - 스프링에서 Junit을 사용하기 위해서 스프링 컨테이너 대신 application context 생성
 * - @Autowired와 같은 어노테이션 사용할 수 있게 됨.
 * @ContextConfiguration("classpath:config/root-context.xml")'
 * - (단위테스트에서) 사용할 빈등록 설정파일 지정
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
public class BoardDaoTest {

		@Autowired
		private BoardDao boardDao;
		
	@Test @Ignore
	public void testDao() {
		assertNotNull(boardDao);
	}
	
	@Test @Ignore
	public void testSelectBoardList() {
		ArrayList<BoardVo> boardList = boardDao.selectBoardList();
		assertNotNull(boardList); // 게시물 목록이 널인지 체크 위의 assertNotNull까지만 체크해도 되지만 실제 결과를 보고싶을때 아래와 같이 테스트가능
		for (BoardVo boardVo : boardList) {
			System.out.println(boardVo.toString());
		}
	}
	
	@Test @Ignore
	public void testGetBoardById() {
		int no = 1;
		BoardVo board = boardDao.getBoardById(no);
		assertNotNull(board);
		assertEquals(no, board.getNo());
	}
	
	@Test @Ignore
	public void testInsertBoard() {
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("단위테스트로 등록된 게시물");
		boardVo.setContent("단위테스트로 등록된 게시물");
		boardVo.setWriter("작성자");
		
		int result = boardDao.insertBoard(boardVo);
		assertEquals(1, result);
	}
	
	@Test @Ignore
	public void testModifyBoard() {
		//특정 게시물을 수정하기 위한 정보를 담을 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(1);
		boardVo.setTitle("수정된 게시물제목");
		boardVo.setContent("수정된 게시물 내용");
		boardVo.setWriter("수정된 작성자");
		
		int result = boardDao.modifyBoard(boardVo);
		assertEquals(1, result);
		
	}
	@Test //@Ignore
	public void testDeleteBoard() {
		int no = 4;
		int result = boardDao.deleteBoard(no);
		System.out.println("result" + result);
		assertEquals(1, result);
	}
	
	

}
