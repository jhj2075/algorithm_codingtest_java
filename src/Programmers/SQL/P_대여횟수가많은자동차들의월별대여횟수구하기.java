package Programmers.SQL;

public class P_대여횟수가많은자동차들의월별대여횟수구하기 {
//    WITH t as (SELECT month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
//    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
//    GROUP BY MONTH, CAR_ID
//    HAVING MONTH between 8 and 10 and RECORDS != 0)
//
//    SELECT MONTH, CAR_ID, RECORDS
//    FROM t
//    WHERE CAR_ID in (SELECT CAR_ID FROM t GROUP BY CAR_ID
//            HAVING sum(RECORDS) >= 5)
//    ORDER BY MONTH ASC, CAR_ID DESC
}
