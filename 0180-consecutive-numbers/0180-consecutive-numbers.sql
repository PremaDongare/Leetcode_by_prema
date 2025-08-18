SELECT  DISTINCT  a.Num AS ConsecutiveNums FROM Logs a 
JOIN logs b ON a.id = b.id+1 AND a.Num = b.Num
JOIN logs c ON b.id = c.id+1 AND a.Num = c.Num 