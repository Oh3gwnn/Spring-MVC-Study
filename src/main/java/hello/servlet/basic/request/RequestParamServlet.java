package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 * 2. POST는 GET 쿼리 파라미터 형식을 지원한다.
 * `application/x-www-form-urlencoded` 형식은 GET 쿼리 파라미터 형식과 같다.
 * 따라서 쿼리 파라미터 조회 메서드(request.getParameter())를 그대로 사용하면 된다.
 * 정리: || request.getParameter() -->  GET URL 쿼리 파라미터 형식  ||
 *      || 두 형식 모두 지원              POST HTML Form 형식      ||
 *
 * 3. PostMan으로 form 형식 실습 가능
 *
 **/

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("OK");

        /**
         *  단일 파라미터: request.getParameter()
         *  복수 파라미터: request.getParameterValues()
         *  복수 파라미터일 때 request.getParameter() 사용 시 첫 번째 값 출력
         *  보통 중복으로 보낼 경우가 없다.
         *  그냥 중복 사용할 경우 request.getParameterValues()를 사용한다는 것만 인지
         */

    }
}
