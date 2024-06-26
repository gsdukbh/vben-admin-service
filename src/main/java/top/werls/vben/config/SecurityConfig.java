package top.werls.vben.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import top.werls.vben.system.Security.CustomizeAccessDeniedHandler;
import top.werls.vben.system.Security.CustomizeAuthEntryPoint;
import top.werls.vben.system.Security.JwtAuthenticationTokenFilter;

@Configuration
public class SecurityConfig {

  @Resource private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

  @Resource private CustomizeAuthEntryPoint authEntryPoint;
  @Resource private CustomizeAccessDeniedHandler accessDeniedHandler;

  @Value("${env.isEnableSwagger}")
  private boolean isEnableSwagger;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager CustomAuthenticationManager(AuthenticationConfiguration auth)
      throws Exception {
    return auth.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    if (isEnableSwagger) {
      http.authorizeHttpRequests(
          requests ->
              requests
                  .requestMatchers("/swagger-ui.html", "/webjars/**", "/swagger-ui*/**", "/v3/**")
                  .permitAll());
    }
    http.cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            requests -> requests.requestMatchers("/login").permitAll().anyRequest().authenticated())
        .exceptionHandling(
            authorizeRequests ->
                authorizeRequests
                    .accessDeniedHandler(accessDeniedHandler)
                    .authenticationEntryPoint(authEntryPoint))
        .logout(
            logout ->
                logout.logoutSuccessHandler(
                    new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
        .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(
            sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
    return http.build();
  }
}
