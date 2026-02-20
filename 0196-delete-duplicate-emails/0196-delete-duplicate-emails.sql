# query using groupby  

delete from Person 
Where id not in (
 select id from(
    select min(id) as id
    from Person
    group by email
) as temp
);