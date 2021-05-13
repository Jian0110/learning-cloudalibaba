CREATE TABLE user_account
(
    id          INT AUTO_INCREMENT COMMENT '账户ID'
        PRIMARY KEY,
    user_id     VARCHAR(32)                        NOT NULL COMMENT '用户编码',
    balance     DECIMAL(10, 2)                     NULL COMMENT '余额',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP NULL COMMENT '更新时间'
)
    COMMENT '用户账号表';

INSERT INTO account.user_account (id, user_id, balance, update_time) VALUES (1, '1234', 975.50, '2021-05-11 22:42:26');
INSERT INTO account.user_account (id, user_id, balance, update_time) VALUES (2, '4567', 2000.00, '2021-05-11 22:42:26');