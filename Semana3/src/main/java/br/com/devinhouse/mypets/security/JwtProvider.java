package br.com.devinhouse.mypets.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtProvider {
    private String secret = "SECRET";

    private int expiration = 24 * 60 * 60 * 1000 * 2;

    // Método de geração de token
    public String generateToken(String username) {
        String token = Jwts
                .builder()
                .setSubject(username)
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        return token;
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(this.secret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getToken(String authorization) {
        String token = authorization;

        if (StringUtils.hasText(token) && token.startsWith("Bearer")) {
            return token.substring(7, token.length());
        }

        return null;
    }
}
