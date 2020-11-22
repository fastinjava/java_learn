# spring boot mybatis plus学习总结

## data.sql

```sql
CREATE TABLE `t_seckill_goods` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT 'iPhone 11 Pro' COMMENT '名称',
  `limit` int NOT NULL DEFAULT '1' COMMENT '限购',
  `count` int NOT NULL COMMENT '库存',
  `sale` int NOT NULL COMMENT '已售',
  `version` int NOT NULL COMMENT '乐观锁，版本号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品表'




```
```sql
CREATE TABLE `t_seckill_order` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int NOT NULL COMMENT '商品ID',
  `name` varchar(30) COLLATE utf8mb4_bin NOT NULL DEFAULT 'iPhone 11 Pro' COMMENT '商品名称',
  `status` int NOT NULL DEFAULT '0' COMMENT '订单状态 0 未支付 1 已支付 2 关闭',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2408 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表'

```