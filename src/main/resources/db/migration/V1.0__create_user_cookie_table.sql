CREATE TABLE user
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    sub        VARCHAR(256) NOT NULL,
    email      VARCHAR(256) NOT NULL,
    gmo_token  VARCHAR(256),
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    UNIQUE (sub),
    UNIQUE (email)
);