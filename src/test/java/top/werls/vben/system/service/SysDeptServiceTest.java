package top.werls.vben.system.service;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.werls.vben.system.entity.SysDept;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jiawei Lee
 * @version TODO
 * @date created 2022/7/1
 * @since on
 */
@SpringBootTest
class SysDeptServiceTest {

    @Resource
    private SysDeptService service;
    @Test
    void generateData(){
        List<SysDept> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            var entity = new SysDept();
            entity.setDeptName("test" + i);
            entity.setOrderNo(i);
            entity.setParentId(0);
            list.add(entity);
        }
        for (int i = 0; i < 10; i++) {
            var entity = new SysDept();
            entity.setDeptName("zi" + i);
            entity.setOrderNo(i);
            entity.setParentId(i);
            list.add(entity);
        }
        service.saveBatch(list);
    }
    @Test
    void getListVo() {
        var listVo = service.getListVo();
        Gson gson = new Gson();
        System.out.println(gson.toJson(listVo));
    }
}