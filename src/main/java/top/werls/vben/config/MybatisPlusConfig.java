package top.werls.vben.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejiawei
 * @version TODO
 * @since on 2022/2/8
 **/
@Configuration
@MapperScan("top.werls.vben.**.mapper*")
public class MybatisPlusConfig {


}
