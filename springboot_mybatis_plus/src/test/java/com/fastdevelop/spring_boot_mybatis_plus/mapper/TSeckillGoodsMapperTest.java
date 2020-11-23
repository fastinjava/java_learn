package com.fastdevelop.spring_boot_mybatis_plus.mapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fastdevelop.spring_boot_mybatis_plus.entity.TSeckillGoods;
import com.fastdevelop.spring_boot_mybatis_plus.entity.TSeckillUser;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@RunWith(
        SpringRunner.class
)
public class TSeckillGoodsMapperTest {

    @Resource
    private TSeckillGoodsMapper seckillGoodsMapper;

    @Resource
    private TSeckillUserMapper seckillUserMapper;

    //增加操作

    //非空自增整型

    /**
     * @TableId(value = "id", type = IdType.AUTO)
     * 针对自增类型，新增后会赋值自增主键，得到插入记录的id值
     */
    @Test
    public void insertIdType1(){

        TSeckillGoods tSeckillGoods = new TSeckillGoods();
        tSeckillGoods.setId(null);
        tSeckillGoods.setCount(999);
        tSeckillGoods.setCreateTime(new Date());
        tSeckillGoods.setName("iPhone 8plus");
        tSeckillGoods.setLimit(2);
        tSeckillGoods.setSale(12);
        tSeckillGoods.setUpdateTime(new Date());
        tSeckillGoods.setVersion(1);

        int insert = seckillGoodsMapper.insert(tSeckillGoods);

        Assert.isTrue(insert > 0);

        System.out.println(JSONUtil.toJsonStr(tSeckillGoods));

    }


    // 非空字符串类型主键

    @Test
    public void insertIdType2() {
        TSeckillUser tSeckillUser = new TSeckillUser();
        tSeckillUser.setName("lify");

        int insert = seckillUserMapper.insert(tSeckillUser);

        Assert.isTrue(insert > 0);

        System.out.println(JSONUtil.toJsonStr(tSeckillUser));

    }


    @Test
    public void delete(){

        QueryWrapper<TSeckillUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id","bb5ac807a36a31ddf97e4285a1cfba4c");

        int delete = seckillUserMapper.delete(queryWrapper);

        Assert.isTrue(delete > 0);

    }

    @Test
    public void delete1(){


        Set<Integer> ids = Sets.newHashSet(1,2,3);
        int delete = seckillGoodsMapper.deleteBatchIds(ids);
        Assert.isTrue(delete > 0);

    }

    @Test
    public void delete2(){
        int delete = seckillGoodsMapper.deleteById(4);
        Assert.isTrue(delete > 0);
    }

    @Test
    public void delete3(){
        Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("id",5);
        int delete = seckillGoodsMapper.deleteByMap(columnMap);
        Assert.isTrue(delete > 0);
    }



    @Test
    public void update1(){

        TSeckillUser seckillUser = seckillUserMapper.selectById("c623f037c7a0c0e3f3884f927eecc036");
        seckillUser.setName("李长军");
        UpdateWrapper<TSeckillUser> updateWrapper = new UpdateWrapper<TSeckillUser>().eq("id", seckillUser.getId());
        int update = seckillUserMapper.update(seckillUser, updateWrapper);

    }

//
//    @Test
//    public void test() {
//        List<TSeckillGoods> tSeckillGoods = seckillGoodsMapper.selectList(null);
//        if (CollectionUtil.isNotEmpty(tSeckillGoods)) {
//            for (int i = 0; i < tSeckillGoods.size(); i++) {
//                System.out.println(i + 1 + " " + JSONUtil.toJsonStr(tSeckillGoods.get(i)));
//            }
//        }
//    }

}