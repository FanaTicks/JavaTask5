use
Car
go
IF EXISTS(SELECT name FROM sys.objects
WHERE name = 'Type_Car' AND type_desc = 'USER_TABLE')
drop table Type_Car
    go
CREATE TABLE Type_Car
(
    Id_Type          char(10)  NOT NULL primary key,
    Name_Type        char(30)  NOT NULL,
    Description_Type char(800) NOT NULL
) go
IF EXISTS(SELECT name FROM sys.objects
WHERE name = 'Car' AND type_desc = 'USER_TABLE')
drop table Car
    go
CREATE TABLE Car
(
    Id_Car          char(10)     NOT NULL primary key,
    Description_Car varchar(800) NOT NULL,
    ID_Type         char(10)     NOT NULL,
    FOREIGN KEY (ID_Type) References Type_Car (Id_Type)
)