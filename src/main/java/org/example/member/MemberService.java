package org.example.member;

import org.example.article.Article;

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
    public boolean login(String userid, String password) {
        return MemberRepository.login(userid, password);
    }
}