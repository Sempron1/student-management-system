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

All other entities have the same crud endpoints with the same format. 

To connect a student and a subject, create a student and subject then use the endpoint:
http://localhost:8080/student-management-system/api/v1/students/studentId/subject/subjectId

JSON body subject: 

http://localhost:8080/student-management-system/api/v1/subjects

{
"name": "Math"
}

To connect a teacher and a subject, create a teacher and subject then use the endpoint:
http://localhost:8080/student-management-system/api/v1/teachers/teacherId/subject/subjectId

JSON body teacher:

http://localhost:8080/student-management-system/api/v1/teachers

{
"firstName": "Johan",
"lastName": "Johansson",
"age": "25",
"email": "jj@mail.se",
"phoneNumber": "1234467"
}

After that, use can use one of these endpoint to show relations between the tables:

getAllBySubject
http://localhost:8080/student-management-system/api/v1/subjects/all/subjectId

getBySubjectAndStudent
http://localhost:8080/student-management-system/api/v1/subjects/subjectId/student/studentId

The hardest problem I meet was to connect the tables together using java. I had other problems too but not noteworthy in my opinion 


