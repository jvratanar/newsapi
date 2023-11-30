CREATE DATABASE newsapidb
    WITH
    OWNER = root
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE USER newsapiapp WITH PASSWORD 'newsapiapp';

GRANT ALL PRIVILEGES ON DATABASE newsapidb TO newsapiapp;

GRANT ALL ON SCHEMA public TO newsapiapp;