-- todoUser 접속
-- 2021.05.24.

CREATE TABLE tbl_todolist(
    td_seq	    NUMBER		    PRIMARY KEY,
    td_date	    VarCHAR2(10)	NOT NULL,	
    td_time	    VarCHAR2(8)	    NOT NULL,
    td_todo	    nVarCHAR2(2000)	NOT NULL,	
    td_place	nVarCHAR2(125)		
);


CREATE VIEW view_todolist AS (
SELECT td_seq AS "No.",
        td_date AS 작성일자,
        td_todo AS 할일,
        td_place AS 장소
FROM tbl_todolist 
);
  
CREATE SEQUENCE seq_todo
START WITH 1
INCREMENT BY 1;

DROP SEQUENCE seq_todo ;
  
INSERT INTO tbl_todolist 
(td_seq, td_date, td_time, td_todo, td_place) 
VALUES ( seq_todo.NEXTVAl, '2021-05-23', '11:20:35', 'Oracle 복습', '집') ;

INSERT INTO tbl_todolist 
(td_seq, td_date, td_time, td_todo, td_place) 
VALUES ( seq_todo.NEXTVAl, '2021-05-23', '12:30:05', 'TEST 공부', '집') ;

INSERT INTO tbl_todolist 
(td_seq, td_date, td_time, td_todo, td_place) 
VALUES ( seq_todo.NEXTVAl, '2021-05-23', '17:50:10', '커피', '카페') ;

INSERT INTO tbl_todolist 
(td_seq, td_date, td_time, td_todo, td_place) 
VALUES ( seq_todo.NEXTVAl, '2021-05-23', '19:05:06', '청소', '집') ;


SELECT* FROM view_todolist;

SELECT * FROM tbl_todolist
ORDER BY td_seq DESC ;

DELETE FROM tbl_todolist
WHERE 1=1 ;

UPDATE tbl_todolist SET 
td_date = '2021-05-22',  td_time = '10:00:20',  td_todo = '수정좀하자',  td_place = '집' 
 WHERE td_seq = 22  ;


UPDATE INTO tbl_todolist SET
td_date = '2021-05-22',  td_time = '10:00:20',  td_todo = 'dsfdffffff',  td_place = '집' 
 WHERE td_seq = 22 ; 











