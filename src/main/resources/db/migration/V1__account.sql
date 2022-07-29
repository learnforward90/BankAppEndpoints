CREATE TABLE Account (
     account_id NVARCHAR(80) NOT NULL,
     client_id NVARCHAR(80)  NOT NULL,
     balance DOUBLE  NOT NULL,
     account_type NVARCHAR(80) NOT NULL,
     withdraw_allowed BOOLEAN NOT NULL,
     CONSTRAINT PK_Account PRIMARY KEY (account_id)
);