package org.example.lifecycle.section01.annotation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(value = "/annotation-lifecycle")
public class LifecycleTestServlet extends HttpServlet {

    private int initCount = 1;

    private int serviceCount = 1;

    private int destroyCount = 1;

    public LifecycleTestServlet() {
        System.out.println("기본 생성자 호출됨");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
