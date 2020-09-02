package com.littlebuddha.housekeeping.test;

import com.littlebuddha.housekeeping.mapper.test.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public int save(TestEntity testEntity){
        System.out.println("save服务层执行");
        testMapper.save(testEntity);
        return 0;
    }
}
