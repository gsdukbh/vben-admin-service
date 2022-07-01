package top.werls.vben;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leejiawei
 */
@SpringBootApplication
@Slf4j
public class VbenApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(VbenApplication.class, args);
        var env = context.getEnvironment();
        var applicationName = env.getProperty("env.appName");
        var version = env.getProperty("env.version");
        var port = env.getProperty("server.port");
        var databaseUrl = env.getProperty("spring.datasource.url");
        log.info("""
                
                |===========================================================
                | application.name: {}
                | application.version: {}
                | swagger-ui: http://localhost:{}/swagger-ui.html
                | application web: http://localhost:{}/
                | database: {}
                |=========================================================== 
                   
                """, applicationName, version, port, port, databaseUrl);
    }

}
