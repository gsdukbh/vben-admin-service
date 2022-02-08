package top.werls.springboottemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.werls.springboottemplate.system.Security.CustomizeAccessDeniedHandler;
import top.werls.springboottemplate.system.Security.CustomizeAuthEntryPoint;
import top.werls.springboottemplate.system.Security.JwtAuthenticationTokenFilter;
import top.werls.springboottemplate.system.service.impl.UserDetailsServiceImpl;

import javax.annotation.Resource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private CustomizeAuthEntryPoint authEntryPoint;
    @Resource
    private CustomizeAccessDeniedHandler accessDeniedHandler;

    @Resource
    public UserDetailsServiceImpl userDetailsService;
    @Value("${env.isEnableSwagger}")
    private  boolean isEnableSwagger;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (isEnableSwagger){
            http.authorizeRequests().antMatchers("/swagger-ui.html",
                    "/webjars/**",
                    "/swagger-ui*/**",
                    "/v3/**").permitAll();
        }
        http.
                cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }
}
