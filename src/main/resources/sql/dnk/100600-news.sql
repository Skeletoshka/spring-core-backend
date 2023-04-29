CREATE TABLE news (
    news_id INTEGER NOT NULL,
    news_title VARCHAR(255) NOT NULL,
    news_text VARCHAR(5000) NOT NULL,
    CONSTRAINT news_pk PRIMARY KEY (news_id)
);