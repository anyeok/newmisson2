package org.example;

import org.example.article.ArticleController;
import org.example.db.DBConnection;
import org.example.member.MemberController;
import org.example.system.SystemController;

public class App {
    private ArticleController articleController;
    private SystemController systemController;
    private MemberController memberController;
    int islogin = 0;

    public App() {
        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();
        memberController = new MemberController();
    }

    public void run() {
        System.out.print("명령) ");
        while (true) {
            String command = Container.getSc().nextLine().trim();
            Request request = new Request(command);
            if (islogin == 1) {
                LogInCommands(request);
            } else {
                LogOutCommands(request);
            }
        }
    }


    private void LogOutCommands(Request request) {
        if (request.getActionCode().equals("종료")) {
            systemController.exit();
        } else if (request.getActionCode().startsWith("회원가입")) {
            memberController.singup();
        } else if (request.getActionCode().equals("로그인")) {
            memberController.login();
            islogin = 1;
        } else {
            System.out.println("잘못된 명령어입니다.");
            System.out.println("로그인 해주세요. (아이디가 없다면 회원가입 해주세요)");
            run();
        }
    }

    private void LogInCommands(Request request) {
        if (request.getActionCode().equals("종료")) {
            systemController.exit();
        } else if (request.getActionCode().equals("등록")) {
            articleController.write();
        } else if (request.getActionCode().equals("목록")) {
            articleController.list();
        } else if (request.getActionCode().startsWith("삭제")) {
            articleController.delete(request);
        } else if (request.getActionCode().startsWith("수정")) {
            articleController.modify(request);
        } else if (request.getActionCode().startsWith("리셋")) {
            articleController.reset();
        } else if (request.getActionCode().equals("로그아웃")) {
            memberController.logout();
            islogin = 0;
        } else {
            LogInCommands(request);
        }
    }
}
