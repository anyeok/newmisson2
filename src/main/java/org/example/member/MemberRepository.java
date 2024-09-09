package org.example.member;

import org.example.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public int create(String userid, String password) {
        String sql = String.format("INSERT INTO `member` SET userid = '%s', `password` = '%s', regDate = now()", userid, password);
        int id = Container.getDBConnection().insert(sql);
        return id;
    }

    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member");
        for (Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }
        return memberList;
    }

    public Member findByUserIdPw(String userid, String password) {
        List<Member> memberList = this.findAll();
        for (Member item : memberList) {
            if (item.getUserid().equals(userid) && item.getPassword().equals(password)) {
                return item;
            }
        }
        return null;
    }

    public boolean foundId(String userid, String password) {
        List<Member> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member");

        for (Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }
        for (Member member : memberList) {
            String storedUserid = member.getUserid();
            String storedPassword = member.getPassword();
            if (storedUserid != null && storedUserid.equals(userid) &&
                    storedPassword != null && storedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}