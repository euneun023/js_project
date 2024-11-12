package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;  // Jwts 클래스 import
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtTokenUtil {
 //   private String secretKey = "testkey"; // 비밀키는 일반적으로 환경변수나 별도의 설정 파일로 관리

    @Value("${jwt.secret")
    private String secretKey;

    @Value("${")

    private long expirationTime = 1000 * 60 * 60 ; //토큰 만료 시간 (1시간)

    public String generateToken(Long user_id, String username, String password){

        Claims claims = Jwts.claims().setSubject(username);
        //claims.put("id", user_id);
        //claims.put("username", username);
        //claims.put("password", password);
        Date now = new Date();
        Date validity = new Date(now.getTime()+ expirationTime);  //만료시간

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(now)
               //.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .setExpiration(validity)
                //.signWith(SignatureAlgorithm.HS512, secretKey) -> jjwt 0.11.x 이후 사용 X
                .signWith(key)
                .compact(); //생성
    }

    //jwt 토큰의 payload ( Claims 추출 )
    private Claims parseClaims (String token){
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())  // SecretKey를 byte 배열로 사용
                .parseClaimsJws(token)  //토큰 파싱 -> Claims 객체로 변환
                .getBody();  //Claims 객체 반환  ( = payload )
    }

    //jwt 토큰에서 사용자 정보 (username) 추출
    public String getUsername (String token){
        return parseClaims(token).getSubject();
    }

    //토크 유효한지 체크
    public boolean isTokenExpired(String token){
        return  parseClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username){
        return (username.equals(getUsername(token))&& !isTokenExpired(token));
    }


}
/*
        try {
            Claims claims = parseToken(token);
            return !claims.getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
 */