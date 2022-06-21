package top.werls.vben.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 初始化数据库 用户 ，创建 vben/123456
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/21
 */
@Component
public class InitData {
    @Resource
    private PasswordEncoder passwordEncoder;


}
