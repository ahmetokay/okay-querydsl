---DELETE TABLE---
DROP TABLE IF EXISTS "rl_user_role";
DROP TABLE IF EXISTS "rl_role";
DROP TABLE IF EXISTS "rl_user";

---CREATE TABLE---
CREATE TABLE "rl_user" (
	"pkid" serial NOT NULL,
	"name" varchar(50) NOT NULL,
	"surname" varchar(50) NOT NULL,
	"username" varchar(50) NOT NULL UNIQUE,
	"password" varchar(50) NOT NULL,
	"register_date" date,
	"type" varchar(50),
	CONSTRAINT "rl_user_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rl_user_role" (
    "pkid" serial NOT NULL,
	"fk_user_id" integer NOT NULL,
	"fk_role_id" integer NOT NULL,
	CONSTRAINT "rl_user_role_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rl_role" (
	"pkid" serial NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(50) NOT NULL,
	CONSTRAINT "rl_role_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "rl_user_role" ADD CONSTRAINT "rl_user_role_fk0" FOREIGN KEY ("fk_user_id") REFERENCES "rl_user"("pkid");
ALTER TABLE "rl_user_role" ADD CONSTRAINT "rl_user_role_fk1" FOREIGN KEY ("fk_role_id") REFERENCES "rl_role"("pkid");

---INSERT DATA---
INSERT INTO "rl_role" (pkid, name, description) VALUES (DEFAULT, 'ROLE_A', 'Rol A Açıklama');
INSERT INTO "rl_role" (pkid, name, description) VALUES (DEFAULT, 'ROLE_B', 'Rol B Açıklama');
INSERT INTO "rl_role" (pkid, name, description) VALUES (DEFAULT, 'ROLE_C', 'Rol C Açıklama');

INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet1', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet2', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet3', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet4', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet5', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet6', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet7', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet8', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet9', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet', 'Okay', 'ahmet10', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz1', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz2', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz3', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz4', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz5', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz6', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz7', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz8', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz9', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yılmaz', 'Yılmaz', 'ahmetyilmaz10', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Ahmet Yıkılmaz', 'Yıkılmaz', 'ahmetyikilmaz', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Hasan', 'Okay', 'hasan', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Hüseyin', 'Yıkılmaz', 'huseyin', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Mahmut', 'Okay', 'mahmut', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Mehmet', 'Okay', 'mehmet', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Müfide', 'Yıkılmaz', 'mufide', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Alp', 'Okay', 'alp', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Turkuaz', 'Okay', 'turkuaz', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Mert', 'Okay', 'mert', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Özhan', 'Okay', 'ozhan', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Gökhan', 'Yılmaz', 'gokhan', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Bilal', 'Okay', 'bilal', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Haluk', 'Okay', 'haluk', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Esin', 'Yılmaz', 'esin', '123', now(), 'USER');
INSERT INTO "rl_user" (pkid, name, surname, username, password, register_date, type) VALUES (DEFAULT, 'Banu', 'Okay', 'banu', '123', now(), 'USER');

INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (DEFAULT, 1, 1);
INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (DEFAULT, 2, 2);
INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (DEFAULT, 3, 3);