package com.kennedy.three.service;

import com.kennedy.three.dao.TblThreeDao;
import com.kennedy.three.entity.TblThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RmThreeService
 * @Description TODO
 * @Author kennedyhan
 * @Date 2020/10/20 0020 15:34
 * @Version 1.0
 **/
@Service
public class RmThreeService {

    @Autowired
    private TblThreeDao mapper;

    public String rm3() {
        TblThree o = new TblThree();
        o.setId(3);
        o.setName("rm3");
        mapper.insertSelective(o);

        return "";
    }

}
