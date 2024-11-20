package com.example.boardPage.dto;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import security.JwtManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter { // OncePerRequestFilter: 각 http 요청에 대해 한번만 실행


    @Autowired
    private JwtManager jwtManager; //

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{

        String requestURI = request.getRequestURI();

        // 로그인과 회원가입 API는 JWT 필터를 적용하지 않음
        if (requestURI.startsWith("/api/auth") || requestURI.startsWith("/api/users")) {
            filterChain.doFilter(request, response); // JWT 필터를 거치지 않고 바로 다음 필터로 진행
            return;
        }

        String token = resolveToken(request); // 토큰 추출
        if (token != null && !jwtManager.isTokenExpired(token)){  //토큰 없거나 토큰 만료하지않았을 때
            try{
                String username = jwtManager.getUsername(token);
                UsernamePasswordAuthenticationToken authentication  = // 이름, 비밀번호, 권한 포함 인증 토큰 (Spring Security Authentication 객체 중 하나)
                    new UsernamePasswordAuthenticationToken(username, null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication); //인증 정보를 Security Context에 설정 (싱글톤객체)
                // ㄴ> 현재 인증된 사용자의 정보 보관하는 객체. 인증 정보 저장 및 인증된 상태에서 요청 처리 됨
            } catch (ExpiredJwtException e){
                //토큰 만료된 경우
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT Token is expried");
            }
        }
        filterChain.doFilter(request, response); //jwt 인증 완료 후, 다음 필터(jwt 외 security config에서 설정한) 로 요청 전달.
    }

    //Authorization 헤더로 jwt 토큰 추출
    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization"); //소유한 토큰
        if (bearerToken != null && bearerToken.startsWith("Baerer ")){
            return bearerToken.substring(7);    // "Bearer " 제거
        }
        return null;
    }
}
