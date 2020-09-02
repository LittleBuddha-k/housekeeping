package com.littlebuddha.housekeeping.service.system;

import com.littlebuddha.housekeeping.entity.other.Page;
import com.littlebuddha.housekeeping.entity.system.Operator;
import com.littlebuddha.housekeeping.mapper.system.OperatorMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperatorService extends BaseService<Operator,OperatorMapper> {

    @Autowired
    private OperatorMapper operatorMapper;

    public Operator get(String id) {
        return operatorMapper.get(id);
    }

    public Operator findByNameAndPassword(String name,String password){
        return operatorMapper.selectByNameAndPassword(name,password);
    }

    public Operator findByName(String name){
        return operatorMapper.selectByName(name);
    }

    public List<Operator> findList(Operator operator) {
        List<Operator> list = operatorMapper.list(operator);
        return list;
    }

    public Page<Operator> findPage(Page<Operator> page,Operator operator){
        Page<Operator> operatorPage = super.findPage(page, operator);
        return operatorPage;
    }

    @Transactional
    public int save(Operator operator) {
        int row = 0;
        if (operator.getIsNewData()) {
            operator.preInsert();
            row = operatorMapper.insert(operator);
        } else {
            operator.preUpdate();
            row = operatorMapper.update(operator);
        }
        return row;
    }

    @Transactional
    public void deleteByLogic(String id){
        operatorMapper.deleteByLogic(id);
    }

    @Transactional
    public void deleteByPhysics(String id){
        operatorMapper.deleteByPhysics(id);
    }
}
