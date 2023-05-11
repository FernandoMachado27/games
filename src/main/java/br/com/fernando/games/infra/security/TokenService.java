package br.com.fernando.games.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.com.fernando.games.domain.user.User;

@Service
public class TokenService {
	
	@Value("{api.security.token.secret}")
	private String secret;
	
	public String generateToken(User user) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("API games")
					.withSubject(user.getUsername())
					.withExpiresAt(dateExpiration())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token JWT", exception);
		}
	}
	
	private Instant dateExpiration() {
		return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00"));
	}

}
