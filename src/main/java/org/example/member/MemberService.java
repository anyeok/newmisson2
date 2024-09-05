package org.example.member;

import java.util.List;

public class MemberService {
    MemberRepository MemberRepository;

    public MemberService() {
        MemberRepository = new MemberRepository();
    }

    public int create(String userid, String password) {
        return MemberRepository.create(userid, password);
    }

    public List<Member> findAll() {
        return MemberRepository.findAll();
    }

    public Member findByUserIdPw(String userid, String password) {
        return MemberRepository.findByUserIdPw(userid, password);
    }

    public boolean foundId(String userid, String password) {
        return MemberRepository.foundId(userid, password);
    }
}