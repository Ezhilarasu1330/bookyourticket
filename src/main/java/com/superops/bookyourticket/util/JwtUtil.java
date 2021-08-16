package com.superops.bookyourticket.util;

import com.superops.bookyourticket.controller.ShowController;
import com.superops.bookyourticket.model.UserInfo;
import com.superops.bookyourticket.vo.UserDetailVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiry}")
    private long expiryTime;

    private final int passwordStrength = 12;

    public String extractUserName(final String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(final String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(final String token) {
        return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(final String token) {
        return this.extractExpiration(token).before(new Date());
    }

    public String generateToken(final UserInfo userInfo, final UserDetailVO userDetail) {
        final Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("role", userDetail.getUserRole());
        claims.put("userId", userDetail.getUserId());
        return this.createToken(claims, userInfo.getEmailId());
    }

    private String createToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiryTime))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    public Boolean validateToken(final String token, final UserDetails userDetails) {

        final String userName = extractUserName(token);
        final Boolean isValid = userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
        if (isValid) {
            final Claims claims = this.extractAllClaims(token);

            ShowController.userId = Long.valueOf(claims.get("userId").toString());
        }
        return isValid;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(this.passwordStrength);
    }
}
