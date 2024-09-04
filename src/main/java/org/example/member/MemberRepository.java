package org.example.member;

import org.example.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public int create(String userid, String password) {
        String sql = String.format("INSERT INTO `member` SET userId = '%s', `password` = '%s', regDate = now()", userid, password);
        int id = Container.getDBConnection().insert(sql);
        return id;
    }

    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from member");
        for(Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }
        return memberList;
    }

    public Member findByUserIdPw(String userid, String password) {
        List<Member> memberList = this.findAll();
        for (Member item : memberList) {
            if(item.getUserid().equals(userid) && item.getPassword().equals(password)) {
                return item;
            }
        }
        return null;
    }

    public boolean login (String userid, String password) {
        String sql = String.format("select * from member WHERE userId = '%s' AND `password` = '%s'", userid, password);
        Container.getDBConnection().selectRows(sql);
        boolean Logintast;
        if (sql == null) {
           Logintast = false;
        } else {
            Logintast = true;
        }
        return Logintast;
    }
}