package leetcode.SQL;

public class P_3497 {
//    select u.user_id, trial_avg_duration, paid_avg_duration
//    from useractivity u join (select user_id, round(avg(activity_duration), 2) as trial_avg_duration
//    from useractivity
//    where activity_type = "free_trial"
//    group by user_id, activity_type
//    order by user_id) as t on u.user_id = t.user_id
//    join (select user_id, round(avg(activity_duration), 2) as paid_avg_duration
//    from useractivity
//    where activity_type = "paid"
//    group by user_id, activity_type
//    order by user_id) as p
//    on u.user_id = p.user_id
//    group by u.user_id
//    order by u.user_id
}
