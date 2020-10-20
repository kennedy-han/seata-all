package com.kennedy.three.controller;

import com.kennedy.three.service.RmThreeService;
import com.kennedy.three.service.RmThreeTCCInterface;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ThreeController
 * @Description 服务3
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:34
 * @Version 1.0
 **/
@RestController
public class ThreeController {

    @Autowired
    private RmThreeService rmThreeService;

    /**
     * 被服务1调用，Seata AT模式
     * @return
     */
    @GetMapping("/rm3")
    public String rm3() {
        rmThreeService.rm3();
//        int i = 1/0;
        return "成功";
    }

    @Autowired
    private RmThreeTCCInterface rmThreeInterface;

    @GetMapping("/rm3-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String threeTcc(){

        rmThreeInterface.rm3(null);
        return "成功";
    }
}
