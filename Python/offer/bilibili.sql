SELECT
	t1.userid,
	t1.user_name,
	t1.recharge,
	t1.count,
	t1.ts 
FROM
	(
SELECT
	*,
	row_number ( ) over ( PARTITION BY t.userid ORDER BY t.count DESC, t.ts DESC ) AS rank 
FROM
	( SELECT *, count( id ) over ( PARTITION BY userid, recharge ) AS count FROM user_recharge ORDER BY count DESC LIMIT 100 ) t 
	) t1 
WHERE
	t1.rank = 1;