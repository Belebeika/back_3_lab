CREATE TABLE "task_db"
(
    id bigserial,
    title varchar(40),
    text varchar(255),
    CONSTRAINT pr_id PRIMARY KEY (id)
)