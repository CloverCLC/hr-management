package cn.cloverclc.service;

import cn.cloverclc.model.entity.Salgrade;
import cn.cloverclc.dao.SalgradeDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalService extends ServiceImpl<SalgradeDao,Salgrade> {
    public List<Salgrade> findAll() {
        return baseMapper.selectList(null);
    }
}
