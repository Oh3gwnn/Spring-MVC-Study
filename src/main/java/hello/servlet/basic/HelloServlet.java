package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override // Ctrl + O (protected service)
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // Servlet request 파라미터 값
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // Servlet response
        response.setContentType("text/plain");  // 단순 문자
        response.setCharacterEncoding("utf-8"); // 인코딩 값(한글 가능)
        response.getWriter().write("hello " + username); // wirte(): in http message body
        // F12 - Network에서 Content-type 확인 가능
        // HTTP 응답에서 Content-Length는 WAS가 자동 생성
    }
}
