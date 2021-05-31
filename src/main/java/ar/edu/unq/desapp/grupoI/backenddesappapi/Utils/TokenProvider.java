package ar.edu.unq.desapp.grupoi.backenddesappapi.Utils;

import ar.edu.unq.desapp.grupoi.backenddesappapi.model.user.PlatformUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class TokenProvider {

    Algorithm algorithmHS = Algorithm.HMAC256("secret");

    public String createToken(PlatformUser user) {
        //Retorna un token que contiene el nombre de usuario
        String token = "";
        try {
            token = JWT.create()
                    .withClaim("userName", user.getNickname())
                    .withIssuer("auth0")
                    .sign(algorithmHS);
            return token;
        } catch (JWTCreationException exception) {
        }
        return token;
    }

    public DecodedJWT verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException exception) { //Invalid signature/claims
        }
        return jwt;
    }

    public DecodedJWT decodeToken(String token) {
        //Decodifica el token y devuelve el contenido
        DecodedJWT jwt = null;
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException exception) { //Invalid token
        }
        return jwt;
    }

    public String getUserToken(String token) {
        //retorna el nombre de usuario que contiene el token obtenido por parametro
        return decodeToken(token).getClaims().get("userName").asString();
    }
}
