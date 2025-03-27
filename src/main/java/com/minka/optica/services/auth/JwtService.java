package com.minka.optica.services.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.security.Key;
import java.util.Map;

@Service
public class JwtService {
    // Se indica los minutos de vida del Token.
    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MINUTE;

    // Se pasa la clave secreta del Token.
    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails user, Map<String, Object> extraClaims)  {
        // Fecha actual de la creación del Token en milesegundos.
        Date issuedAt = new Date(System.currentTimeMillis());

        // Creamos la caducidad del Token mediante:
        // Se calcula los minutos para expirar (milesegundos) y se suma a la fecha creación del Token.
        Date expiration = new Date( (EXPIRATION_IN_MINUTE *60 *1000) + issuedAt.getTime());

        String jwt = Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }

    private Key generateKey() {

        // byte[] key= SECRET_KEY.getBytes();

        byte[] passwordDecoded = Decoders.BASE64.decode(SECRET_KEY);
        System.out.println(new String(passwordDecoded));
        return Keys.hmacShaKeyFor(passwordDecoded);

    }

    public String extractUsername(String jwt) {
        // Si el Token tiene algo invalido como formato, header, payload,
        // firma, caduciada se genera un error y por tanto una excepción.
        return extractAllClaims(jwt).getSubject();

    }

    private Claims extractAllClaims(String jwt) {
        // Extraemos todas las Claims del Token.
        return Jwts.parserBuilder().setSigningKey( generateKey()).build()
            .parseClaimsJws(jwt).getBody();
    }

}
