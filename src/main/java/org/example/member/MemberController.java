package org.example.member;

import org.example.Container;

public class MemberController {
    MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public void singup() {
        System.out.print("회원가입 ID : ");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("비밀번호 PW : ");
        String password = Container.getSc().nextLine().trim();

        int id = memberService.create(userid, password);

        System.out.printf("%d번 회원이 등록되었습니다.\n", id);

    }
    public boolean login() {
        System.out.print("ID : ");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("PW : ");
        String password = Container.getSc().nextLine().trim();

        if (memberService.foundId(userid, password) == false) {
            System.out.print("로그인에 실패하였습니다.");
        } else {
            System.out.printf("%s님 환영합니다 !\n", userid);
            System.out.print("명령) ");
        }
        return false;
    }

    public void logout() {
        System.out.println("로그아웃 되었습니다.");
        System.out.print("명령) ");
    }
}