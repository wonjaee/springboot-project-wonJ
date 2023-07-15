package com.green.nowon.domain.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.dto.MemberRole;
import com.green.nowon.domain.dto.MyuserDTO;

@Mapper
public interface MemberMapper {

	void saveMember(MemberDTO dto);
	void saveRole(@Param("memberNo")long no,@Param("role")MemberRole Role);
	Optional<MemberDTO> findByNo(String no);

	Optional<MemberDTO> findById(String id);
	
	int findByIdOne(String id);
	

}
