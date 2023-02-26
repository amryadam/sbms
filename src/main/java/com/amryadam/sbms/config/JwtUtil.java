//package com.amryadam.sbms.config;
//
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtUtil {
//
//
//    private String SECRET_KEY = "JaNdRgUkXp2s5v8y/A?D(G+KbPeShVmYq3t6w9z$C&E)H@McQfTjWnZr4u7x!A%D";
//    public String extractUserName(String token){
//        return extractClaim(token,Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token){
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token){
//        var jwtParserBuilder =  Jwts.parserBuilder().setSigningKey(SECRET_KEY).build();
//        return jwtParserBuilder.parseClaimsJws(token).getBody();
//    }
//
//    private  Boolean isTokenExpired(String token){
//        return  extractExpiration(token).before(new Date());
//    }
//
//    public String generateToken(UserDetails userDetails){
//        Map<String,Object> claims = new HashMap<>();
//        return crateToken(claims,userDetails.getUsername());
//    }
//
//    private String crateToken(Map<String,Object> claims,String subject){
//         String token = Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.ES256,SECRET_KEY)
//                .compact();
//
//        return token;
//
//    }
//
//    public Boolean validateToken(String token,UserDetails userDetails){
//        final String username = extractUserName(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//
//
//}
