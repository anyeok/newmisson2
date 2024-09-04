package org.example.member;

import java.util.Map;

public class Member {
    private int id;
    private String userid;
    private String password;

    //    public Member (){
//        this.id = (int)getId();
//        this.userid = (String) getUserid();
//        this.password = (String) getPassword();
//    }

    public Member(Map<String, Object> row) {
        this.id = (int) row.get("id");
        this.userid = (String) row.get("userid");
        this.password = (String) row.get("password");
    }


    public int getId() {
        return this.id;
    }

    public String getUserid() {
        return this.userid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}