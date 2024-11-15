package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig  {
    private final JwtTokenFilter jwtTokenFilter;

    //jwtTokenFilter는 생성자 .. 의존성주입받기 위함이지만 꼭 써야하는가
    public SecurityConfig(JwtTokenFilter jwtTokenFilter){
        this.jwtTokenFilter = jwtTokenFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
          //      .antMatchers(HttpMethod.POST, "/api/users").permitAll()   //회원가입 : ALL
        //        .antMatchers(HttpMethod.POST,"/api/auth").permitAll()   //로그인 : ALL
            //    .anyRequest().authenticated()   //이외 요청 인증된 사용자만
                .antMatchers("/**").permitAll()   // 모든 경로에 대해 허가
                .anyRequest().permitAll()         // 다른 모든 요청에도 허가
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); //JWT 필터

        return  http.build();   // http 객체 빌드
    }

    @Bean  //?
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

}
