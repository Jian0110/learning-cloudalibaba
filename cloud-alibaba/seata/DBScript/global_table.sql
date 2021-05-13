CREATE TABLE global_table
(
    xid                       VARCHAR(128)  NOT NULL
        PRIMARY KEY,
    transaction_id            BIGINT        NULL,
    status                    TINYINT       NOT NULL,
    application_id            VARCHAR(32)   NULL,
    transaction_service_group VARCHAR(32)   NULL,
    transaction_name          VARCHAR(128)  NULL,
    timeout                   INT           NULL,
    begin_time                BIGINT        NULL,
    application_data          VARCHAR(2000) NULL,
    gmt_create                DATETIME      NULL,
    gmt_modified              DATETIME      NULL
)
    CHARSET = utf8;

CREATE INDEX idx_gmt_modified_status
    ON global_table (gmt_modified, status);

CREATE INDEX idx_transaction_id
    ON global_table (transaction_id);

