-- 코드를 작성해주세요
select f.id,fn.fish_name,f.length as length 
from fish_info f
inner join fish_name_info fn
on f.fish_type = fn.fish_type
where f.length = (select max(length) from fish_info where fish_type = f.fish_type)
order by id;