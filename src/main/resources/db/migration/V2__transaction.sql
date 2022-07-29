CREATE TABLE Transaction (
         transaction_id INTEGER AUTO_INCREMENT NOT NULL,
         from_id NVARCHAR(40) NOT NULL,
         to_id NVARCHAR(40) NOT NULL,
         amount DOUBLE NOT NULL,
         date NVARCHAR(40) NOT NULL,
         is_done BOOLEAN NOT NULL,
         CONSTRAINT PK_Transaction PRIMARY KEY (transaction_id)
);