package com.kennedy.one.service;

import com.kennedy.one.dao.TblOneDao;
import com.kennedy.one.entity.TblOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RmOneService
 * @Description Seata AT模式
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:16
 * @Version 1.0
 **/
@Service
public class RmOneService {

    @Autowired
    private TblOneDao mapper;

    @Autowired
    private RestTemplate restTemplate;

    public String rm1() {
        TblOne obj = new TblOne();
        obj.setId(1);
        obj.setName("rm1");

        mapper.insertSelective(obj);

        //此处可以断点，观看 db1中的 undo_log表
        // DB 1 会插入数据
        // 如果后续操作中，有异常，根据undolog回滚 db 1
        rm2();
        rm3();

        return "";
    }

    public void rm2() {
        restTemplate.getForEntity("http://two/rm2", null);
    }

    public void rm3() {
        restTemplate.getForEntity("http://three/rm3", null);
    }
}
