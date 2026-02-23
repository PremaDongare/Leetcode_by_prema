# Write your MySQL query statement below
select request_at As Day,
round(count(case when status like 'cancelled%' then status end)/count(status),2) 'Cancellation Rate'
from Trips
where client_id in(select users_id from users where banned = 'No')
and driver_id in(select users_id from users where banned='No')
and request_at between "2013-10-01" and "2013-10-03"
group by request_at