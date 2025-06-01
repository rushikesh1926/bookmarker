CREATE SEQUENCE IF NOT EXISTS bm_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS bookmarks (
    id bigint DEFAULT nextval('bm_id_seq') not null,
    title varchar(255) not null,
    url varchar(255) not null,
    created_at timestamp,
    primary key (id)
    );