CREATE TABLE lock_table
(
    row_key        VARCHAR(128) NOT NULL
        PRIMARY KEY,
    xid            VARCHAR(96)  NULL,
    transaction_id BIGINT       NULL,
    branch_id      BIGINT       NOT NULL,
    resource_id    VARCHAR(256) NULL,
    table_name     VARCHAR(32)  NULL,
    pk             VARCHAR(36)  NULL,
    gmt_create     DATETIME     NULL,
    gmt_modified   DATETIME     NULL
)
    CHARSET = utf8;

CREATE INDEX idx_branch_id
    ON lock_table (branch_id);

