package SQL;

public class P_특정기간동안대여가능한자동차들의대여비용구하기 {
//    select c.CAR_ID, c.CAR_TYPE, round(DAILY_FEE * (1 - (DISCOUNT_RATE * 0.01)) * 30) as FEE
//    from CAR_RENTAL_COMPANY_CAR as c left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d
//    on c.CAR_TYPE = d.CAR_TYPE and DURATION_TYPE = '30일 이상'
//    where c.CAR_TYPE in ('SUV', '세단')
//    and not exists (
//            select 1
//                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
//                    where h.CAR_ID = c.CAR_ID and START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01')
//    having FEE between 500000 and 1990000
//    order by FEE DESC, CAR_TYPE ASC, CAR_ID DESC
}
