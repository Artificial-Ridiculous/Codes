use test;
/*
drop table if exists transactions;
drop table if exists banks;
drop table if exists cards;
drop table if exists customers;
drop table if exists merchants;
drop table if exists terminals;
*/
create table IF NOT EXISTS banks(
    BankID BIGINT primary key,
    BankName varchar(100),
    City varchar(100),
    BankAddress varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table IF NOT EXISTS merchants(
    MerchantID BIGINT primary key,
    MerchantCity varchar(100),
    MerchantAddress varchar(100),
    BusinessType varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table IF NOT EXISTS customers(
    CustomerID BIGINT primary key,
    CustomerName varchar(100),
    BirthDate Date,
    Sex char(1),
    Income Int,
    Education varchar(20),
    NativePlace varchar(100),
    PhoneNumber varchar(11)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table IF NOT EXISTS cards(
    CardNumber BIGINT primary key,
    CardOwnerID BIGINT,
    IssuingBankID BIGINT,
    CardType TINYINT,
    IssuingDate Date,
    ValidUntil Date,
    FOREIGN KEY(CardOwnerID) REFERENCES customers(CustomerID),
    FOREIGN KEY(IssuingBankID) REFERENCES banks(BankID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table IF NOT EXISTS terminals(
    TerminalID INT primary key,
    MerchantID BIGINT,
    FOREIGN KEY(MerchantID) REFERENCES merchants(MerchantID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table IF NOT EXISTS transactions(
    TransactionID BIGINT primary key,
    CardNumber BIGINT,
    TerminalID INT,
    TransactionDate Date,
    TransactionTime Time,
    TransactionType TINYINT,
    Amount FLOAT,
    FOREIGN KEY(CardNumber) REFERENCES cards(CardNumber),
    FOREIGN KEY(TerminalID) REFERENCES terminals(TerminalID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

desc transactions;



