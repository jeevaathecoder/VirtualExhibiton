//package com.virtualexhibiton.config;
//
//
//import com.virtualexhibiton.services.UserDetailsImpl;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseCookie;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.WebUtils;
//
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtUtils {
//    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
//
//    @Value("${twt.app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${twt.app.jwtExpirationMs}")
//    private int jwtExpirationMs;
//
//    @Value("${twt.app.jwtCookieName}")
//    private String jwtCookie;
//
//    public String getJwtFromCookies(HttpServletRequest request) {
//        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
//        if (cookie != null) {
//            return cookie.getValue();
//        } else {
//            return null;
//        }
//    }
//
//    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
//        String jwt = generateTokenFromUsername(userPrincipal.getEmail());
//        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
//        return cookie;
//    }
//
//    public ResponseCookie getCleanJwtCookie() {
//        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
//        return cookie;
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(key()).build()
//                .parseClaimsJws(token).getBody().getSubject();
//    }
//
//    private Key key() {
//        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    }
//
//
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
//            return true;
//        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("Unsupported JWT token: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
//        } catch (SignatureException e) {
//            logger.error("JWT signature validation failed: {}", e.getMessage());
//        } catch (SecurityException e) {
//            logger.error("JWT security exception: {}", e.getMessage());
//        }
//
//        return false;
//    }
//
//    public String generateTokenFromUsername(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
//                .signWith(key(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//}