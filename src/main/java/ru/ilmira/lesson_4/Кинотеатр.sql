CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8;


CREATE TABLE `cinema`.`halls` (
  `id` INT(3) NOT NULL AUTO_INCREMENT,
  `name` TEXT(100) NOT NULL,
  `capacity` INT(5) NOT NULL,
  PRIMARY KEY (`id`))
 COMMENT = 'Кинозалы'; 


CREATE TABLE `cinema`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT(250) NOT NULL,
  `duration` INT(3) NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Кинофильмы';


CREATE TABLE `cinema`.`sessions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hall_id` INT(3) NOT NULL,
  `movie_id` INT NOT NULL,
  `begin_dt` DATETIME NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_halls_idx` (`hall_id` ASC) VISIBLE,
  INDEX `fk_movie_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_sessions_hall`
    FOREIGN KEY (`hall_id`)
    REFERENCES `cinema`.`halls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sessions_movie`
    FOREIGN KEY (`movie_id`)
    REFERENCES `cinema`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Киносеансы';


CREATE TABLE `cinema`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `session_id` INT NOT NULL,  
  PRIMARY KEY (`id`),
  INDEX `fk_tickets_session_idx` (`session_id` ASC) VISIBLE,
  CONSTRAINT `fk_tickets_session`
    FOREIGN KEY (`session_id`)
    REFERENCES `cinema`.`sessions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Билеты';


use cinema;

 insert into halls (name, capacity) 
 values ("Зал 1", 10),
        ("Зал 2", 15),
        ("Зал 3", 20);
		

insert into movies (name, duration)
values ("Фильм 1", 60),
       ("Фильм 2", 120),
       ("Фильм 3", 90),
       ("Фильм 4", 60),
       ("Фильм 5", 120);		
	   
	   
	   
insert into sessions (hall_id, movie_id, begin_dt, price)
values (1, 3,  "2022-08-25 09:00:00", 800),
       (2, 1,  "2022-08-25 14:00:00", 900), 
       (3, 2,  "2022-08-25 15:00:00", 700), 
       (1, 4,  "2022-08-25 12:00:00", 900), 
       (2, 5,  "2022-08-25 18:00:00", 900),  
       (3, 3,  "2022-08-25 21:00:00", 700), 
       (2, 1,  "2022-08-25 20:30:00", 900), 
       (2, 2,  "2022-08-25 18:30:00", 800),  # Ошибочно дублированный сеанс
       (3, 4,  "2022-08-25 22:30:00", 1000); # Начало сеанса без перерыва
	   


# Продаем 7 билетов на первый сеанс (вставка в таблицу tickets производится в момент продажи билета)
insert into tickets (session_id)
values (1),
       (1), 
       (1), 
       (1),
       (1),
       (1),
       (1);      
       
select count(*) from tickets where session_id = 1;

# Продаем 11 билетов на второй сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (2),
       (2), 
       (2), 
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2);
       
select count(*) from tickets where session_id = 2;       

# Продаем 5 билетов на третий сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (3),
       (3), 
       (3), 
       (3),       
       (3);
       
select count(*) from tickets where session_id = 3;

# Продаем 3 билета на четвертый сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (4),
       (4), 
       (4);
       
select count(*) from tickets where session_id = 4;


# Продаем 5 билетов на пятый сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (5),
       (5), 
       (5), 
       (5),       
       (5);
       
select count(*) from tickets where session_id = 5;  


# Продаем 10 билетов на шестой сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (6),
       (6), 
       (6), 
       (6),       
       (6),       
       (6),       
       (6),       
       (6),       
       (6),       
       (6);
       
select count(*) from tickets where session_id = 6;  


# Продаем 3 билета на седьмой сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (7),
       (7), 
       (7);
       
select count(*) from tickets where session_id = 7;  

# Продаем 8 билетов на восьмой сеанс (вставка в таблицу tickets производится в момент продажи билета)  
insert into tickets (session_id)
values (8),
       (8), 
       (8), 
       (8),       
       (8),       
       (8),       
       (8),       
       (8);
       
select count(*) from tickets where session_id = 8; 	   




# Задание №1

--ошибки в расписании (фильмы накладываются друг на друга), 
--отсортированные по возрастанию времени. Выводить надо колонки «фильм 1»,
--«время начала», «длительность», «фильм 2», «время начала», «длительность»;

with session_info as 
  (select s.id, 
          s.hall_id,
          h.name as hall_name,
          s.movie_id,
          m.name as movie_name,
          s.begin_dt, 
          timestampadd(MINUTE, m.duration, s.begin_dt) as end_dt,
          m.duration       
     from sessions s
     join halls h on h.id = s.hall_id
     join movies m on m.id = s.movie_id)
select s1.id as session_id
     , s1.hall_name
     , s1.movie_name  as first_movie_name
     , s1.begin_dt    as first_movie_begin_dt
     , s1.duration    as first_movie_duration
     , '<=>'         as "<=>"
     , s2.movie_name  as second_movie_name
     , s2.begin_dt    as second_movie_begin_dt
     , s2.duration    as second_movie_duration
  from session_info s1
  join session_info s2 on s1.hall_id = s2.hall_id
                      and s1.id <> s2.id
                      and (s1.begin_dt between s2.begin_dt and s2.end_dt or
                           s2.begin_dt between s1.begin_dt and s1.end_dt)
order by s1.begin_dt;


# Результат:
------------------------------------------------------------------------------------------------------------------------------------------------------------------
session_id| hall_name | first_movie_name |first_movie_begin_dt  | first_movie_duration | <=> | second_movie_name | second_movie_begin_dt | second_movie_duration |
------------------------------------------------------------------------------------------------------------------------------------------------------------------
5         | Зал 2     | Фильм 5          | 2022-08-25 18:00:00  | 120                  | <=> | Фильм 2           | 2022-08-25 18:30:00   | 120                   |

8         | Зал 2     | Фильм 2          | 2022-08-25 18:30:00  | 120                  | <=> | Фильм 5           | 2022-08-25 18:00:00   | 120                   |

6         | Зал 3     | Фильм 3          | 2022-08-25 21:00:00  | 90                   | <=> | Фильм 4           | 2022-08-25 22:30:00   | 60                    |

9         | Зал 3     | Фильм 4          | 2022-08-25 22:30:00  | 60                   | <=> | Фильм 3           | 2022-08-25 21:00:00   | 90                    |
------------------------------------------------------------------------------------------------------------------------------------------------------------------




# Задание №2

--перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
--Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

with session_info as 
  (select s.id, 
          s.hall_id,
          h.name as hall_name,
          s.movie_id,
          m.name as movie_name,
          s.begin_dt, 
          timestampadd(MINUTE, m.duration, s.begin_dt) as end_dt,
          lead(s.begin_dt, 1) over (partition by hall_id order by begin_dt) as next_begin_dt,
          timestampdiff(MINUTE, timestampadd(MINUTE, m.duration, s.begin_dt), lead(s.begin_dt, 1) over (partition by hall_id order by begin_dt)) as timeout,
          m.duration       
     from sessions s
     join halls h on h.id = s.hall_id
     join movies m on m.id = s.movie_id
    order by s.hall_id, s.begin_dt)
select s1.hall_name
     , s1.movie_name
     , s1.begin_dt
     , s1.end_dt
     , s1.duration
     , s1.timeout
     , s2.movie_name  as next_movie_name
     , s2.begin_dt    as next_begin_dt
     , timestampadd(MINUTE, s2.duration, s2.begin_dt) as next_end_dt
  from session_info s1
  join session_info s2 on s1.hall_id = s2.hall_id
                      and s1.id <> s2.id
                      and s1.next_begin_dt = s2.begin_dt
 order by s1.hall_id, s1.begin_dt;
 
 
# Результат:
---------------------------------------------------------------------------------------------------------------------------------------------------
hall_name | movie_name | begin_dt           | end_dt             | duration | timeout | next_movie_name | next_begin_dt      | next_end_dt        |
---------------------------------------------------------------------------------------------------------------------------------------------------
Зал 1     | Фильм 3    |2022-08-25 09:00:00 |2022-08-25 10:30:00 | 90       | 90      | Фильм 4         |2022-08-25 12:00:00 |2022-08-25 13:00:00 |

Зал 2     | Фильм 1    |2022-08-25 14:00:00 |2022-08-25 15:00:00 | 60       | 180     | Фильм 5         |2022-08-25 18:00:00 |2022-08-25 20:00:00 |

Зал 2     | Фильм 5    |2022-08-25 18:00:00 |2022-08-25 20:00:00 | 120      | -90     | Фильм 2         |2022-08-25 18:30:00 |2022-08-25 20:30:00 |

Зал 2     | Фильм 2    |2022-08-25 18:30:00 |2022-08-25 20:30:00 | 120      | 30      | Фильм 1         |2022-08-25 21:00:00 |2022-08-25 22:00:00 |

Зал 3     | Фильм 2    |2022-08-25 15:00:00 |2022-08-25 17:00:00 | 120      | 240     | Фильм 3         |2022-08-25 21:00:00 |2022-08-25 22:30:00 |    

Зал 3     | Фильм 3    |2022-08-25 21:00:00 |2022-08-25 22:30:00 | 90       | 0       | Фильм 4         |2022-08-25 22:30:00 |2022-08-25 23:30:00 |
---------------------------------------------------------------------------------------------------------------------------------------------------

  

# Задание №3

--список фильмов, для каждого — с указанием общего числа посетителей за все время,
--среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). 
--Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;


with session_calc as (
    select s.id as session_id
         , s.movie_id
         , count(t.id) * s.price as total_sum
         , count(t.id)           as count_visitors
      from sessions s
      left join tickets t on t.session_id = s.id
    group by s.id)
select if(grouping(sc.movie_id), 'Total:', sc.movie_id) as movie_id
     , sum(sc.count_visitors)           as total_visitors
     , format(avg(sc.count_visitors),0) as avg_visitors_by_session
     , sum(sc.total_sum)                as total_sum
  from session_calc sc
  group by sc.movie_id with rollup
  order by case when movie_id is null then 0 else null end, sum(sc.total_sum) desc ;
  
  
# Результат:
-----------------------------------------------------------------
movie_id | total_visitors | avg_visitors_by_session | total_sum |
-----------------------------------------------------------------
1        | 14             | 7                       | 12600.00  |
 
3        | 17             | 9                       | 12600.00  |

2        | 13             | 7                       | 9900.00   |
 
5        | 5              | 5                       | 4500.00   |

4        | 3              | 2                       | 2700.00   |
-----------------------------------------------------------------
Total:   | 52             | 6                       | 42300.00  |
-----------------------------------------------------------------