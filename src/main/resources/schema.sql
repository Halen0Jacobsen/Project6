DROP TABLE IF EXISTS job;
CREATE TABLE job (

    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    jobid               varchar(255) NOT NULL,
    title               varchar(255) NOT NULL,
    description         varchar(255) NOT NULL,
    companyname         varchar(255) NOT NULL,
    skill1              varchar(255) NOT NULL,
    skill2              varchar(255) NOT NULL,
    created_date        timestamp NOT NULL,
    last_modified_date  timestamp NOT NULL,
    version             integer NOT NULL


);