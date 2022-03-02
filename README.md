# springboot-jwt-authentication

Create New user in H2 DB
http://localhost:8080/api/users/signup

Method: POST

Content-Type: application/json

Request:

{
    "name":"JWT-User",
    "email":"jwt@test.com",
    "password":"JwtPassword@123"
}

Response:

{
    "id": 1,
    "name": "JWT-User",
    "email": "jwt@test.com",
    "password": null
}

Get JWT token with above created user
http://localhost:8080/api/authenticate

Method: POST

Content-Type: application/json

Request:
{
    "name":"JWT-User",
    "password":"JwtPassword@123"
}

Response:
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKV1QtVXNlciIsImV4cCI6MTY0NjIzMTc3MSwiaWF0IjoxNjQ2MjEzNzcxfQ.LBmniwps-Zw0K6e6_iWeDUp2zwoeknitcD8RClfEhlAFib_NQa3qqtMx275i9-D6EkWFtEsEj4dmuc0lkRAofw"
}



Access protected API's using above token
http://localhost:8080/api/users/protected

Method: GET

Bearer Token: <Tonen from authenticate API>
