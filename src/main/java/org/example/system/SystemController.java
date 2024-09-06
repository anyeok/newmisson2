package org.example.system;

import org.example.Container;

public class SystemController {
    public void exit() {
        System.out.println("== 시스템이 종료 ==");
        Container.close();
    }
}