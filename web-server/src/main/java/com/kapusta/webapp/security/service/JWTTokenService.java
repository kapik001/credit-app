package com.kapusta.webapp.security.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class JWTTokenService implements Clock, TokenService {

    private static final GzipCompressionCodec COMPRESSION_CODEC = new GzipCompressionCodec();

    private final String issuer;
    private final int expirationSec;
    private final int clockSkewSec;
    private final String secretKey;

    JWTTokenService(@Value("${jwt.issuer}") final String issuer,
                    @Value("${jwt.expiration-sec}") final int expirationSec,
                    @Value("${jwt.clock-skew-sec}") final int clockSkewSec,
                    @Value("${jwt.secret}") final String secret) {
        super();
        this.issuer = issuer;
        this.expirationSec = expirationSec;
        this.clockSkewSec = clockSkewSec;
        this.secretKey = secret;
    }

    @Override
    public String permanent(Map<String, String> attributes) {
        return newToken(attributes, 0);
    }

    @Override
    public String expiring(Map<String, String> attributes) {
        return newToken(attributes, expirationSec);
    }

    @Override
    public Map<String, String> untrusted(String token) {
        final JwtParser parser = Jwts.parserBuilder()
                .requireIssuer(issuer)
                .setClock(this)
                .setAllowedClockSkewSeconds(clockSkewSec)
                .build();

        final String withoutSignature = substringBeforeLast(token, ".") + ".";
        return parseClaims(() -> parser.parseClaimsJwt(withoutSignature).getBody());
    }

    @Override
    public Map<String, String> verify(String token) {
        Key aSecretKey = new SecretKeySpec(this.secretKey.getBytes(), "HmacSHA256");
        final JwtParser parser = Jwts.parserBuilder()
                .requireIssuer(issuer)
                .setClock(this)
                .setAllowedClockSkewSeconds(clockSkewSec)
                .setSigningKey(aSecretKey)
                .build();

        return parseClaims(() -> parser.parseClaimsJws(token).getBody());
    }

    private String newToken(final Map<String, String> attributes, final int expiresInSec) {
        Calendar calendar = Calendar.getInstance();

        final Claims claims = Jwts
                .claims()
                .setIssuer(issuer)
                .setIssuedAt(calendar.getTime());

        if (expiresInSec > 0) {
            calendar.add(Calendar.SECOND, expiresInSec);
            claims.setExpiration(calendar.getTime());
        }
        claims.putAll(attributes);
        Key aSecretKey = new SecretKeySpec(this.secretKey.getBytes(), "HmacSHA256");
        return Jwts
                .builder()
                .setClaims(claims)
                .signWith(aSecretKey)
                .compressWith(COMPRESSION_CODEC)
                .compact();
    }

    @Override
    public Date now() {
        return new Date();
    }

    private static Map<String, String> parseClaims(final Supplier<Claims> toClaims) {
        try {
            final Claims claims = toClaims.get();
            Map<String, String> toReturn = new LinkedHashMap<>();
            for (final Map.Entry<String, Object> e : claims.entrySet()) {
                toReturn.put(e.getKey(), String.valueOf(e.getValue()));
            }
            return toReturn;
        } catch (final IllegalArgumentException | JwtException e) {
            return new LinkedHashMap<>();
        }
    }

    private String substringBeforeLast(String origin, String delimeter) {
        try {
            String[] parts = origin.split(delimeter);
            return parts[parts.length - 2];
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }
}
