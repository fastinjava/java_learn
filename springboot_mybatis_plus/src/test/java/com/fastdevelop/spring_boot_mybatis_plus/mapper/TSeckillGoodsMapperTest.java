package com.fastdevelop.spring_boot_mybatis_plus.mapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelop.spring_boot_mybatis_plus.entity.TSeckillGoods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@RunWith(
        SpringRunner.class
)
public class TSeckillGoodsMapperTest {

    @Resource
    private TSeckillGoodsMapper seckillGoodsMapper;

    @Test
    public void test() {
        List<TSeckillGoods> tSeckillGoods = seckillGoodsMapper.selectList(null);
        if (CollectionUtil.isNotEmpty(tSeckillGoods)) {
            for (int i = 0; i < tSeckillGoods.size(); i++) {
                System.out.println(i + 1 + " " + JSONUtil.toJsonStr(tSeckillGoods.get(i)));
            }
        }
    }

}