package com.kennedy.one.controller;

import com.kennedy.one.service.RmOneService;
import com.kennedy.one.service.RmOneTCCInterface;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OneController
 * @Description 服务1 调用服务2和服务3
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:15
 * @Version 1.0
 **/
@RestController
public class OneController {

    @Autowired
    private RmOneService rmOneService;

    /**
     * Seata AT模式
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/one")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String one() throws InterruptedException {
        rmOneService.rm1();
//        TimeUnit.MINUTES.sleep(1);
//        System.out.println(1/0);
        return "success";
    }

    //------ 测试 Seata TCC 模式 ------
    @Autowired
    private RmOneTCCInterface rmOneInterface;

    /**
     * Seata TCC 模式
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/one-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String oneTcc() throws InterruptedException {
        rmOneInterface.rm1(null);
        return "success";
    }
}
