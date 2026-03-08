package lk.ijse.cmjd113.AirTicketCollector.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JWTUtils {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private long expiration;
    private Key key;

    @PostConstruct
    public void init(){
        byte [] keyBytes = Base64.getDecoder().decode(jwtSecret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
    //Token generate
    public String generateToken(String email, Collection<? extends GrantedAuthority> authorities){
        String role = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

      return   Jwts.builder()
                .setSubject(email)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();

    }
    //Token Validate
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //User name extraction
    public String getUsernameFromToken(String token){
        var body = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return body.getSubject();

    }
}
