CREATE TABLE "USER"(
 "cod_user" BigSerial NOT NULL,
 "nick" VARCHAR NOT NULL,
 "pass" VARCHAR NOT NULL,
 "email" VARCHAR NOT NULL,
 "banned" BOOLEAN DEFAULT false NOT NULL,
 "registered" TIMESTAMP WITH TIME ZONE NOT NULL,
 "username" VARCHAR,
 "surname" VARCHAR
);


ALTER TABLE "USER" ADD CONSTRAINT "key_cod_user" PRIMARY KEY ("cod_user");
ALTER TABLE "USER" ADD CONSTRAINT "key_nick" UNIQUE ("nick");
