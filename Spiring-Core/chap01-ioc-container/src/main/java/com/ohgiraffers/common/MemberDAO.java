package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDAO {
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "김상익"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "익상김"));

    }

    public MemberDTO selectMember(int sequence){
        return memberMap.get(sequence);
    }

    public boolean insertMember(MemberDTO newMember){
        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);

        int after = memberMap.size();

        return after > before ? true : false;
    }
}
