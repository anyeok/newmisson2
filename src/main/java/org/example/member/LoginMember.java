package org.example.member;

import java.util.ArrayList;
import java.util.List;

public class LoginMember {
    private List<String> loginMembers = new ArrayList<>();

    public void setLoginmember(String name) {
        if (loginMembers.isEmpty()) {
            loginMembers.add(name);
        } else {
            System.out.println("이미 로그인 되어 있습니다.");
        }
    }
}