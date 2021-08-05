package com.yusufSevinc.auth;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TokenManager {
    private static final String secretKey = "sevinc";
    private static final int validity = 5 * 60 * 1000;
    public String generateToken(String username){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .setIssuer("sevinc")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.forSigningKey(key),secretKey)
                .compact();
        return jws;
    }

   public boolean tokenValidate(String token){
        if (getUsernameToken(token) != null
        && isExpired(token)){
            return true;
        }
        return false;
    }

   public String getUsernameToken(String token){
       Claims claims = getClaims(token);
       return claims.getSubject();

    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public boolean isExpired(String token){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
