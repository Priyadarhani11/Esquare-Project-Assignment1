create table EMPLOYEE_Department (
	uuid_ VARCHAR(75) null,
	depId LONG not null primary key,
	depName VARCHAR(75) null,
	depNo VARCHAR(75) null,
	depAddress VARCHAR(75) null
);

create table EMPLOYEE_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	employeeName VARCHAR(75) null,
	employeeAddress VARCHAR(75) null,
	depId LONG
);