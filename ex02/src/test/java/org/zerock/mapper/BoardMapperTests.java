package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("���ۻ���");
		board.setContent("���볻��");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}

	@Test
	public void testInsertSelectKey() {
		
		
		BoardVO board = new BoardVO();
		board.setTitle("����߳���� select key");
		board.setContent("�̸����ƿ��ʶ� select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		//�����ϴ� �Խù� ��ȣ�� �׽�Ʈ
		BoardVO board = mapper.read(201L);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(84L));
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(61L);
		board.setTitle("����������");
		board.setContent("�����ȳ���");
		board.setWriter("user00");
		
		int count = mapper.update(board);
	
		log.info("UPDATE COUNT : " +count);
	}
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		//10���� 3������
		cri.setPageNum(3);
		cri.setAmount(5);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("���ٹ�");
		cri.setType("T");//Title or Content or Writer
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	
}
