create table class (
	class_ID int primary key,
	class_name nvarchar(100),
	"date" date,

);
create table account (
	role_ID int primary key,
	role int,
);

create table "admin" (
	adminID int primary key,
	adEmail nvarchar(50),
	adPassword nvarchar(50),
	role_ID int,
	foreign key (role_ID) references account(role_ID),

);

create table student (
	student_ID int primary key,
	student_name nvarchar(50),
	student_email nvarchar(50),
	student_password nvarchar(50),
	student_msv varchar(8),
	student_ava varbinary(max),
	role_ID int,
	dob date,
	gender varchar(10),
	class_ID int,
	foreign key (role_ID) references account(role_ID),
	foreign key (class_ID) references class(class_ID),

);

create table teacher (
	teacher_ID int primary key,
	teacher_name nvarchar(50),
	teacher_email nvarchar(50),
	teacher_password nvarchar(50),
	role_ID int,
	dob date,
	class_ID int,
	gender varchar(10),
	foreign key (role_ID) references account(role_ID),
	foreign key (class_ID) references class(class_ID),

);

create table class_teacher_mapping(
	teacher_ID int,
	class_ID int,
	primary key(teacher_ID,class_ID),
	foreign key (teacher_ID) references teacher(teacher_ID),
	foreign key (class_ID) references class(class_ID),
	teacher_name varchar(200),
);

create table "phong_dao_tao" (
	systemUser_ID int primary key,
	systemUser_email nvarchar(50),
	systemUser_password nvarchar(50),
	role_ID int,
	foreign key (role_ID) references account(role_ID),

);

create table feedback (
	feedback_ID int primary key,
	student_ID int,
	foreign key (student_ID) references student(student_ID),
	question nvarchar(250),
);

create table "subject" (
	subject_ID int primary key,
	subject_name nvarchar(100),

);
create table lesson (
	lesson_ID int primary key,
	lesson_name nvarchar(250),
	subject_ID int,
	foreign key (subject_ID) references "subject"(subject_ID),
	"date" date,
);


create table attendance (
	attendance_ID int primary key,
	lesson_ID int,
	foreign key (lesson_ID) references lesson(lesson_ID),
	student_ID int,
	foreign key (student_ID) references student(student_ID),
	teacher_ID int,
	foreign key (teacher_ID) references teacher(teacher_ID),
	"status" bit,
	"date" date,

);


