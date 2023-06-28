package com.green.nowon.domain.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.green.nowon.domain.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	void saveAll(BoardDTO dto);
	
	@Select("select * from board order by no desc")
	List<BoardDTO> findAll();
	
	
	Optional<BoardDTO> findByNo(long no);

	
}
