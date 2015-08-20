A = load 'input' using PigStorage('#') as (USERID:int, MOVIEID:int, RATING:double, TIMESTAMP:chararray);
a = GROUP A ALL;
b = FOREACH a GENERATE MAX(A.USERID) AS val;

-- STORE b INTO 'output';