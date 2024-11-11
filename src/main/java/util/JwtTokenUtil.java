package util;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;  // Jwts 클래스 import
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private String secretKey = "testkey";
    private long expirationTime = 1000 * 60 * 60 ; //토큰 만료 시간 (1시간)

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact(); //생성

    }

}
