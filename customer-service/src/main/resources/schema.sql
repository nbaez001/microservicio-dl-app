DROP TABLE IF EXISTS TBL_REGIONS;
CREATE TABLE TBL_REGIONS (
    ID   INTEGER      NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS TBL_CUSTOMERS;
CREATE TABLE TBL_CUSTOMERS (
    ID   INTEGER      NOT NULL AUTO_INCREMENT,
    NUMBER_ID VARCHAR(8) NOT NULL,
	FIRST_NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(250) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	PHOTO_URL VARCHAR(250) NOT NULL,
    STATE VARCHAR(50) NOT NULL,
    REGION_ID   INTEGER      NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (REGION_ID) REFERENCES TBL_REGIONS(ID)
    
);