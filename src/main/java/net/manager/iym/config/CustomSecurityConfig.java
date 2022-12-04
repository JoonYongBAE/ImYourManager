package net.manager.iym.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.security.handler.Custom403Handler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) //prePostEnabled = true는 원하는 곳에
// @PreAuthorize, @PostAuthorize 어노테이션을 이용하여 로그인 상태를 사전/사후 체크 설정 가능함
public class CustomSecurityConfig {//로그인을 안하면 보드에 접근을 못하게 설정을 함
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {//
        return new BCryptPasswordEncoder();

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        log.info("------------로그인 환경설정중(configure)-------");

        //로그인 페이지
        http.formLogin()
                .loginPage("/member/login")//로그인페이지로 이 주소를 사용
                .usernameParameter("id").passwordParameter("pass")//로그인 페이지 form에서 id와 pass를 받아옴
                .defaultSuccessUrl("/main/joinboard/list");//defalutSuccessUrl이 로그인 성공시에 보내줄 사이트를 지정해줌
                                                                //defaulttargeturl과 같은 역할??
        http.csrf().disable(); //csrf 보안을 사용하지 않는 설정

        http.logout().logoutSuccessUrl("/").invalidateHttpSession(true);//로그아웃시 세션삭제 true이고 로그아웃 성공시 url설정

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler()); //403


        return http.build();
    }


    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        //로그인 오류 페이지 대신 로그인 페이지로 이동시킴
        return new Custom403Handler();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("------------web configure-------------------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }
}