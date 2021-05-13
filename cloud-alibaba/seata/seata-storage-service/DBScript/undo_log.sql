CREATE TABLE undo_log
(
    id            BIGINT AUTO_INCREMENT
        PRIMARY KEY,
    branch_id     BIGINT       NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT          NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    ext           VARCHAR(100) NULL,
    CONSTRAINT ux_undo_log
        UNIQUE (xid, branch_id)
)
    CHARSET = utf8;

