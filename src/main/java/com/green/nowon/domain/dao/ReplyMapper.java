package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {

	@Insert("insert into reply(content,writer,board_no) values(#{content},#{writer},#{boardNo})")
	void save(ReplyDTO dto);

}
