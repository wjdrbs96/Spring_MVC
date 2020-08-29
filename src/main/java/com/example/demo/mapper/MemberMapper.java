package com.example.demo.mapper;

import com.example.demo.dto.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {

    // 중복아이디 체크
    @Select("SELECT * FROM member WHERE id = #{id}")
    Member checkById(@Param("id") final String id);

    // 회원가입
    @Insert("INSERT INTO member (id, password) VALUES(#{id}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "memberIdx")
    int insertMember(Member member);

}
