package com.fastdevelop.spring_boot_mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author lify
 * @since 2020-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TSeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    @TableField("`name`")
    private String name;

    /**
     * 订单状态 0 未支付 1 已支付 2 关闭
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;


}
