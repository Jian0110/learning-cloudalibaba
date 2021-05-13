CREATE TABLE branch_table
(
    branch_id         BIGINT        NOT NULL
        PRIMARY KEY,
    xid               VARCHAR(128)  NOT NULL,
    transaction_id    BIGINT        NULL,
    resource_group_id VARCHAR(32)   NULL,
    resource_id       VARCHAR(256)  NULL,
    branch_type       VARCHAR(8)    NULL,
    status            TINYINT       NULL,
    client_id         VARCHAR(64)   NULL,
    application_data  VARCHAR(2000) NULL,
    gmt_create        DATETIME(6)   NULL,
    gmt_modified      DATETIME(6)   NULL
)
    CHARSET = utf8;

CREATE INDEX idx_xid
    ON branch_table (xid);

