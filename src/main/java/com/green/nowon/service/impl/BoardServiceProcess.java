package com.green.nowon.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.BoardMapper;
import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceProcess implements BoardService{
	
	private final BoardMapper boardmapper;
	
	@Override
	public void saveProcess(BoardDTO dto) {
		boardmapper.saveAll(dto);
		
	}

	@Override
	public void findAllProcess(Model model,int page) {
		int limit = 5; //한 페이지에 보여지는 게시글수
		int offset= (page-1)*limit; //게시글 페이징할 번호
		List<BoardDTO> result= boardmapper.findAll(limit,offset);
		model.addAttribute("list",result);
		
		int rowCount=boardmapper.countAll();//rowCount 총 게시글 개수
		System.out.println("rowCount :"+rowCount);
		int pageTotal=rowCount/limit; //페이지 총개수
		if(rowCount%limit>0) pageTotal++; // 총게시글수/limit>0 이면 페이지를 1씩증가한다
		System.out.println("pageTotal :"+pageTotal);
		
		//페이지 번호에 의해 변화하면됨
		//p1~p10 : from 1 , to = 10
		
		int tot=pageTotal;
		model.addAttribute("tot", pageTotal);
		int range=10;
		int rangeNo=page/range;//1~9번 까진 0 , 10번은 1 
		if(page%range>0)rangeNo++; 
				
		int to = range*rangeNo; //페이지 마지막번호
		int from = to-range+1; //페이지시작번호
		
		if(to>tot)to=tot;
		model.addAttribute("from",from);
		model.addAttribute("to",to);
	}

	@Override
	public void detailProcess(long no, Model model) {
		model.addAttribute("detail",boardmapper.findByNo(no).orElseThrow());
		
	}

	@Override
	public void deleteProcess(long no) {
		boardmapper.deleteNo(no);
		
	}

}
