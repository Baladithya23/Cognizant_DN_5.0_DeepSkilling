-- Savings accounts table (Scenario 1)
CREATE TABLE savings_accounts (
    account_id   NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    balance      NUMBER
);

INSERT INTO savings_accounts VALUES (1, 'Baladithya', 10000);
INSERT INTO savings_accounts VALUES (2, 'Raju', 5000);
INSERT INTO savings_accounts VALUES (3, 'Gaius', 20000);
COMMIT;

-- Employees table (Scenario 2)
CREATE TABLE employees (
    emp_id     NUMBER PRIMARY KEY,
    emp_name   VARCHAR2(50),
    department VARCHAR2(50),
    salary     NUMBER
);

INSERT INTO employees VALUES (1, 'Baladithya', 'IT', 50000);
INSERT INTO employees VALUES (2, 'Raju', 'IT', 45000);
INSERT INTO employees VALUES (3, 'Gaius', 'Sales', 40000);
COMMIT;

-- Accounts table (Scenario 3 - for fund transfer)
CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    owner_name VARCHAR2(50),
    balance    NUMBER
);

INSERT INTO accounts VALUES (201, 'Baladithya', 15000);
INSERT INTO accounts VALUES (202, 'Raju', 3000);
COMMIT;