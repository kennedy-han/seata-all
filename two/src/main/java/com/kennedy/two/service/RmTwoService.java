package com.kennedy.two.service;

import com.kennedy.two.dao.TblTwoDao;
import com.kennedy.two.entity.TblTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RmTwoService
 * @Description TODO
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:30
 * @Version 1.0
 **/
@Service
public class RmTwoService {

    @Autowired
    TblTwoDao mapper;

    public String rm2() {
        TblTwo o = new TblTwo();
        o.setId(2);
        o.setName("rm2");
        mapper.insertSelective(o);

        return "";
    }
}
