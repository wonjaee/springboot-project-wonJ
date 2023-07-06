package com.green.nowon.domain.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.green.nowon.domain.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	void saveAll(BoardDTO dto);
	
	//@Select("select * from board order by no desc")
	List<BoardDTO> findAll(@Param("limit") int limit,@Param("offset")int offset);
	
	
	Optional<BoardDTO> findByNo(long no);
	
	//@Delete("delete from board where no=#{no}")
	void deleteNo(long no);

	int countAll();
	
	@Update("UPDATE board SET title = #{dto.title}, content = #{dto.content} WHERE no = #{no}")
	void update(@Param("no") long no, @Param("dto") BoardDTO dto);

	
}
