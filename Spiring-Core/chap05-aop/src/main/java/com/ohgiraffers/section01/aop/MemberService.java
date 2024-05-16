package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers method 실행");
        return memberDAO.selectAllMembers();
    }

    public MemberDTO selectMemberById(Long id) {
        System.out.println("selectMemberById method 실행");
        return memberDAO.selectMemberById(id);
    }

}
