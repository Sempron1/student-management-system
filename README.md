My entity student has the fields:
firstName, lastName, email, phoneNumber and Age

Insomnia: 

Get all students: http://localhost:8080/student-management-system/api/v1/students/

Get by lastName: http://localhost:8080/student-management-system/api/v1/students/getbylastname?lastName=lastnamehere

Get by id: http://localhost:8080/student-management-system/api/v1/students/idhere

Create student: http://localhost:8080/student-management-system/api/v1/students

JSON body:
{
"firstName": "fName",
"lastName": "lName",
"age": "age",
"email": "email",
"phoneNumber": "phoneNumber"
}

Update student: http://localhost:8080/student-management-system/api/v1/students/

JSON body:

{
"id": 1,
"firstName": "fName",
"lastName": "lName",
"age": "age",
"email": "email",
"phoneNumber": "phoneNumber"
}

Delete student: http://localhost:8080/student-management-system/api/v1/students/idhere


I have also done a custom exception called: InvalidAgeException which throws and exception when the student isn't between the high school
age interval(14-18). Also, I have been using the exceptionMapper to organize my exceptions.



