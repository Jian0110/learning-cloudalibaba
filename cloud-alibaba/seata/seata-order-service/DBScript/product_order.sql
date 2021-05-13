CREATE TABLE product_order
(
    id          INT AUTO_INCREMENT COMMENT '订单ID'
        PRIMARY KEY,
    product_id  INT                                NOT NULL COMMENT '商品ID',
    account_id  INT                                NOT NULL COMMENT '用户账户ID',
    pay_amount  DECIMAL(10, 2)                     NOT NULL COMMENT '实际支付金额',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建订单时间'
);

INSERT INTO `order`.product_order (id, product_id, account_id, pay_amount, create_time) VALUES (4, 1, 1, 12.25, '2021-05-11 23:47:14');
INSERT INTO `order`.product_order (id, product_id, account_id, pay_amount, create_time) VALUES (5, 1, 1, 12.25, '2021-05-11 23:52:22');