package top.werls.springboottemplate.common.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Component
public class JwtTokenUtils {

    private static final String CLAIM_KEY_USERNAME = "username";
    private static final String CLAIM_KEY_TIME = "time";

    @Value("${env.jwt.privateKey}")
    private RSAPrivateKey key;
    @Value("${env.jwt.publicKey}")
    private RSAPublicKey publicKey;

    @Value("${env.jwt.expire}")
    private Long expire;

    @Value("${env.jwt.tokenPrefix}")
    private String tokenPrefix;


    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setExpiration(getExpirationDate())
                .signWith(key)
                .compact();
    }

    public String generateToken(Map<String, Object> claims, Long time) {
        return Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setExpiration(getExpirationDate(time))
                .signWith(key)
                .compact();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = Map.of(CLAIM_KEY_USERNAME, username, CLAIM_KEY_TIME, new Date(System.currentTimeMillis()));
        return generateToken(claims);
    }

    public String generateToken(String username, Long time) {
        Map<String, Object> claims = Map.of(CLAIM_KEY_USERNAME, username, CLAIM_KEY_TIME, new Date(System.currentTimeMillis()));
        return generateToken(claims, time);
    }

    private Date getExpirationDate() {
        return new Date(Instant.now().plus(Duration.ofMinutes(expire)).toEpochMilli());
    }

    private Date getExpirationDate(Long time) {
        return new Date(Instant.now().plus(Duration.ofMillis(time)).toEpochMilli());
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).get(CLAIM_KEY_USERNAME, String.class);
    }

    /**
     * 获取token 创建时间
     *
     * @param token token
     * @return Date Milli
     */
    public Date getTimeFromToken(String token) {
        return getClaimsFromToken(token).get(CLAIM_KEY_TIME, Date.class);
    }

    public boolean validateToken(String token, String username) {
        String usernameFromToken = getUsernameFromToken(token);
        return usernameFromToken.equals(username) && !isTokenExpired(token);
    }


    private boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token).getBody();
    }

    public String refreshToken(String oldToken) {
        if (StringUtils.isBlank(oldToken)) {
            return null;
        }
        String token = oldToken.substring(tokenPrefix.length());
        Claims claims = getClaimsFromToken(token);
        if (isTokenExpired(token)) {
            return null;
        }
        Date createdDate = claims.get(CLAIM_KEY_TIME, Date.class);
        Date refreshDate = new Date(Instant.now().minus(Duration.ofMinutes(30)).toEpochMilli());
        if (createdDate.after(refreshDate) && createdDate.before(new Date())) {
            return oldToken;
        }
        String username = getUsernameFromToken(token);
        return generateToken(username);
    }


}
