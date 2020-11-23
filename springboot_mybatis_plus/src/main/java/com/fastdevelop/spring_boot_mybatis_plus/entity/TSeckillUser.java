package com.fastdevelop.spring_boot_mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lify
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TSeckillUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("`name`")
    private String name;


}
