DROP TABLE IF EXISTS user_account;
DROP SEQUENCE IF EXISTS USER_ACCOUNT_PK_SEQ;

CREATE SEQUENCE USER_ACCOUNT_PK_SEQ START 1;

CREATE TABLE user_account (
  id                      BIGINT                   NOT NULL                DEFAULT nextval('USER_ACCOUNT_PK_SEQ'),
  uuid                    CHARACTER VARYING(36)    NOT NULL UNIQUE,
  first_name              CHARACTER VARYING(256)   NOT NULL,
  last_name               CHARACTER VARYING(256)   NOT NULL,
  phone                   CHARACTER VARYING(30)    NOT NULL,
  mail                    CHARACTER VARYING(256)   NOT NULL,
  created                 TIMESTAMP WITH TIME ZONE NOT NULL                DEFAULT now()
);

ALTER TABLE user_account
  ADD CONSTRAINT USER_ACCOUNT_PK PRIMARY KEY (id);