package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	void memberSave(MemberDTO dto);

}
