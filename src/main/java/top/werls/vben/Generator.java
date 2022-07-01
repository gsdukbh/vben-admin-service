package top.werls.vben;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 使用 mybatis-plus 生成代码的工具类
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/16
 */
public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/vben_admin", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("Jiawei Lee") // 设置作者
                            .enableSwagger()
                            .outputDir(".\\Generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("top.werls") // 设置
                            .moduleName("vben") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, ".\\Generator\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude("vben_sys_menu") // 设置需要生成的表名
                            .addTablePrefix("vben") // 设置过滤表前缀
                            .entityBuilder()
//                            .enableTableFieldAnnotation() // 字段注解
                            .enableLombok(); // 开启 lombok 模式
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
