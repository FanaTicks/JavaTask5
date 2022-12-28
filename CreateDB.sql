go
IF EXISTS (SELECT name FROM sys.objects
WHERE name = 'Car' AND type_desc = 'USER_DATABASE')
drop
database Car
go
CREATE
DATABASE Car