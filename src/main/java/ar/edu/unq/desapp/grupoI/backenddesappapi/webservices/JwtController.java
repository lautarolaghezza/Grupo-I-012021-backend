package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;

@RestController	public class JwtController {
    @GetMapping("/generate-token")
    @ResponseBody
    public String GenerateToken() {
        try{
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
            SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            HashMap<String, Object> header = new HashMap<String,Object>();
            header.put("alg", signatureAlgorithm.toString()); //HS256
            header.put("typ","JWT");
            JwtBuilder tokenJWT = Jwts
                    .builder()
                    .setHeader(header)
                    .setIssuer("http://trustyapp.com/")
                    .setId("1")
                    .setSubject("www.javadesde0.com")
                    .claim("name", "David Bernal")
                    .claim("scope", "admins")
                    .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                    .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L))).signWith(key);
            String tokenJWTString = tokenJWT.compact();
            System.out.println(tokenJWTString);
            return tokenJWTString;
        }catch (Exception e) {
                System.out.println(e);
                return "Error creating the token JWT" + e;
        }
    }

}