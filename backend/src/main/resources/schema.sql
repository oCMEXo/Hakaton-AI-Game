CREATE TABLE "dialogues" (
                             "id" BIGSERIAL NOT NULL,
                             "name" TEXT,
                             PRIMARY KEY("id")
);

CREATE TABLE "headers" (
                           "id" BIGSERIAL NOT NULL,
                           "dialogue_id" BIGINT NOT NULL,
                           "title" TEXT NOT NULL,
                           "number" INTEGER NOT NULL,
                           PRIMARY KEY("id"),
                           UNIQUE ("dialogue_id", "number")
);

CREATE TABLE "contents" (
                            "id" BIGSERIAL NOT NULL,
                            "header_id" BIGINT NOT NULL,
                            "content" TEXT NOT NULL,
                            PRIMARY KEY("id")
);

ALTER TABLE "headers"
    ADD FOREIGN KEY("dialogue_id") REFERENCES "dialogues"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE "contents"
    ADD FOREIGN KEY("header_id") REFERENCES "headers"("id")
        ON UPDATE NO ACTION ON DELETE NO ACTION;