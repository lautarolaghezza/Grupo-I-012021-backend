package ar.edu.unq.desapp.grupoi.backenddesappapi.webservices;

import ar.edu.unq.desapp.grupoi.backenddesappapi.exceptions.UserNotFoundException;
import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.UserAbs;
import ar.edu.unq.desapp.grupoi.backenddesappapi.services.userService.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;



@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @PostMapping("register")
    public UserAbs register(@RequestBody UserAbs userBody) {
        String token = GenerateToken(userBody.getPassword());
        UserAbs user = new UserAbs();
        user.setNickname(userBody.getNickname());
        user.setPassword(token);
        userService.save(user);
        return user;
    }
    @PostMapping("login")
    public UserAbs login(@RequestBody UserAbs userBody) {
        UserAbs userLoaded = userService.findBy(1);
        System.out.println(userLoaded.getPassword());
        String token = GenerateToken(userBody.getPassword());
        System.out.println(token);
        System.out.println(userLoaded.getPassword().equals(token));

        if(userLoaded.getPassword().equals(token)){
            return userLoaded;
        }else{
            throw new UserNotFoundException();
        }
    }

    public String GenerateToken(String password) {
        try {
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
            //SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

            HashMap<String, Object> header = new HashMap<String, Object>();
            header.put("alg", signatureAlgorithm.toString()); //HS256
            header.put("typ", "JWT");
            JwtBuilder tokenJWT = Jwts
                    .builder()
                    .setHeader(header)
                    .setIssuer("resenia")
                    .setId("reseniaJWT")
                    .setSubject(password)
                    .claim("name", password)
                    .claim("scope", "authorities")
                    .setIssuedAt(java.sql.Date.from(Instant.ofEpochSecond(1466796822L)));
                    //.setExpiration(java.sql.Date.from(Instant.ofEpochSecond(4622470422L))).signWith(key);
            String tokenJWTString = tokenJWT.compact();
            System.out.println(tokenJWTString);
            return tokenJWTString;
        } catch (Exception e) {
            System.out.println(e);
            return "Error creating the token JWT" + e;
        }
    }
}
