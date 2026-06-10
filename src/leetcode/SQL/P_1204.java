package leetcode.SQL;

public class P_1204 {
//    select cc.person_name
//    from (
//                    select c.person_name, c.total
//                            from (
//                            select q.person_id, q.weight, q.person_name, (select sum(weight) from queue t where t.turn <= q.turn) as total
//    from queue q
//    order by turn
//    ) c
//    where c.total <= 1000
//            ) cc
//    order by cc.total desc
//    limit 1
}
