package net.manager.iym.security.handler;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class Custom403Handler implements AccessDeniedHandler {//내가 직접 403 익셉션 처리를 할것이다.
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        //JSON요청이었는지 확인
        String contentType = request.getHeader("Content-Type");
        boolean jsonRequest = contentType.startsWith("application/json");
        log.info("isJson : "+ jsonRequest);
        //일반 Request 요청시
        if(!jsonRequest){
            response.sendRedirect("/member/login?error=ACCESS_DENIED");
        }
    }

}
