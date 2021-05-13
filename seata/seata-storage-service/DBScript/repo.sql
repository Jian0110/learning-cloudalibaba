CREATE TABLE repo
(
    id     INT AUTO_INCREMENT COMMENT '商品ID'
        PRIMARY KEY,
    name   VARCHAR(100)   NOT NULL COMMENT '商品名称',
    amount INT            NOT NULL COMMENT '库存量',
    price  DECIMAL(10, 2) NOT NULL COMMENT '价格'
);

INSERT INTO storage.repo (id, name, amount, price) VALUES (1, 'product-1', 998, 12.25);
INSERT INTO storage.repo (id, name, amount, price) VALUES (2, 'product-2', 200, 22.20);
INSERT INTO storage.repo (id, name, amount, price) VALUES (3, 'product-3', 666, 100.00);