package kr.wonil.myspringboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/my-sms/**",
                                "/my-expense/**",
                                "/memo/**",
                                "/yahoo-finance/**",
                                "/stock/**",
                                "/invest/**",
                                "/dividend/**",
                                "/manage/**"
                        ).permitAll()  // Swagger 관련 경로는 인증 없이 접근 허용
                        .anyRequest().authenticated()  // 그 외는 인증 필요
                )
                .httpBasic(Customizer.withDefaults()) // 기본 로그인 창 허용
                .csrf(csrf -> csrf.disable()); // CSRF 비활성화 (테스트 시 편의)

        return http.build();
    }
}