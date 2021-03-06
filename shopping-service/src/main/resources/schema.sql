DROP TABLE IF EXISTS TLB_INVOICES;
CREATE TABLE TBL_INVOICES (
    ID   INTEGER      NOT NULL AUTO_INCREMENT,
    NUMBER_INVOICE VARCHAR(100) NOT NULL,
	DESCRIPTION VARCHAR(250) NOT NULL,
	CUSTOMER_ID INTEGER      NOT NULL,
	CREATE_AT TIMESTAMP NOT NULL,
	STATE VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS TBL_INVOCE_ITEMS;
CREATE TABLE TBL_INVOCE_ITEMS (
    ID   INTEGER      NOT NULL AUTO_INCREMENT,
    INVOICE_ID  INTEGER      NOT NULL,
    PRODUCT_ID   INTEGER      NOT NULL,
	QUANTITY DECIMAL(10,2) NOT NULL,
	PRICE DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (INVOICE_ID) REFERENCES TBL_INVOICES(ID)
);