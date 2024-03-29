//package com.example.microserviceredis2.jwt;
//
//import com.example.microserviceredis2.model.StudentUserDetails;
//import org.springframework.stereotype.Component;
//import io.jsonwebtoken.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Date;
//
//@Component
//@Slf4j
//public class JwtTokenProvider {
//    private final String JWT_SECRET = "lantuong";
//
//    //Thời gian có hiệu lực của chuỗi jwt
//    private final long JWT_EXPIRATION = 604800000L;
//
//    // Tạo ra jwt từ thông tin user
//    public String generateToken(StudentUserDetails userDetails) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
//        // Tạo chuỗi json web token từ id của user.
//        return Jwts.builder().subject(Long.toString(userDetails.getStudent().getId())).issuedAt(now)
//                .expiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                .compact();
//    }
//
//    // Lấy thông tin user từ jwt
//    public Long getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(JWT_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return Long.parseLong(claims.getSubject());
//    }
//
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
//            return true;
//        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
//        }
//        return false;
//    }
//}
