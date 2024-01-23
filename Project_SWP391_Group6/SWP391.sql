create table account (
	role_ID int primary key,
	email nvarchar(50),
	password nvarchar(50),
	role int,
);

create table "admin" (
	adminID int primary key,
	adEmail nvarchar(50),
	adPassword nvarchar(50),
	role_ID int,
	foreign key (role_ID) references account(role_ID),
	role int,
);

create table student (
	student_ID int primary key,
	student_name nvarchar(50),
	student_age int,
	student_email nvarchar(50),
	student_password nvarchar(50),
	student_msv varchar(8),
	student_ava varbinary(max),
	role_ID int,
	dob date,
	gender varchar(10),
	foreign key (role_ID) references account(role_ID),
	role int,
);

create table teacher (
	teacher_ID int primary key,
	teacher_name nvarchar(50),
	teacher_email nvarchar(50),
	teacher_password nvarchar(50),
	role_ID int,
	dob date,
	gender varchar(10),
	foreign key (role_ID) references account(role_ID),
	role int,
);

create table "phong_dao_tao" (
	systemUser_ID int primary key,
	systemUser_email nvarchar(50),
	systemUser_password nvarchar(50),
	role_ID int,
	foreign key (role_ID) references account(role_ID),
	role int,
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

create table class (
	class_ID int primary key,
	student_ID int,
	subject_ID int,
	teacher_ID int,
	foreign key (student_ID) references student(student_ID),
	foreign key (subject_ID) references "subject"(subject_ID),
	foreign key (teacher_ID) references teacher(teacher_ID),
	class_name nvarchar(100),
	"date" date,

);

create table attendance (
	attendance_ID int primary key,
	student_ID int,
	subject_ID int,
	teacher_ID int,
	foreign key (student_ID) references student(student_ID),
	foreign key (subject_ID) references "subject"(subject_ID),
	foreign key (teacher_ID) references teacher(teacher_ID),
	"status" bit,
	"date" date,

);

create table lesson (
	lesson_ID int primary key,
	lesson_name nvarchar(250),
	subject_ID int,
	foreign key (subject_ID) references "subject"(subject_ID),
	student_ID int,
	foreign key (student_ID) references student(student_ID),
	teacher_ID int,
	foreign key (teacher_ID) references teacher(teacher_ID),
	attendance_ID int,
	foreign key (attendance_ID) references attendance(attendance_ID),
	"date" date,
);

create table class_subject_mapping (
	subject_ID int,
	class_ID int,
	lesson_ID int,
	primary key(subject_ID, class_ID,lesson_ID),
	foreign key (subject_ID) references "subject"(subject_ID),
	foreign key (class_ID) references class(class_ID),
	foreign key (lesson_ID) references lesson(lesson_ID),
	class_name nvarchar(100),
	subject_name nvarchar(100),
	"date" date,
);

