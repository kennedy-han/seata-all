package com.kennedy.two.controller;

import com.kennedy.two.service.RmTwoService;
import com.kennedy.two.service.RmTwoTCCInterface;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TwoController
 * @Description 服务2
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:29
 * @Version 1.0
 **/
@RestController
public class TwoController {

    @Autowired
    private RmTwoService rmTwoService;

    /**
     * 被服务1调用，seata AT模式
     * @return
     */
    @GetMapping("/rm2")
    public String two() {
        rmTwoService.rm2();
//        int i = 1 / 0;
        return "success";
    }

    // Seata TCC 模式
    @Autowired
    private RmTwoTCCInterface rmTwoInterface;

    @GetMapping("/rm2-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String twoTcc(){

        rmTwoInterface.rm2(null);
//        int i = 1/0;
        return "success";
    }
}
