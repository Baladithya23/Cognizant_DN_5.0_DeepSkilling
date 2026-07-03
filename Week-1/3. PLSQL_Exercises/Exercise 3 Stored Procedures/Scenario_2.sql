CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    FOR acc IN (SELECT account_id, balance FROM savings_accounts) LOOP
        UPDATE savings_accounts
        SET balance = balance + (balance * 0.01)
        WHERE account_id = acc.account_id;
        
        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || acc.account_id);
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
        ROLLBACK;
END;
/
SET SERVEROUTPUT ON;
EXEC ProcessMonthlyInterest;
SELECT * FROM savings_accounts;