Create University
url: http://localhost:8080/university
method: post
body: university JSON
example: {
             "name": "Taras Shevchenko National University "
             "country": "Ukraine "
         }
         
Get University
url: http://localhost:8080/university/1
method: get
         
Get all University
url: http://localhost:8080/universities
method: get

Update University
url: http://localhost:8080/university
method: put
body: university JSON
example: {
             "id": 1,
             "name": "Updated name"
             "country": "Ukraine "
         }
         
Delete University
url: http://localhost:8080/university/1
method: delete

Create Student 
url: http://localhost:8080/student
method: post
body: student JSON
example:     {
                 "nameView": "Name",
                 "specialization": "Specialization",
                 "university": {
                     "id": 1,
                     "name": "Taras Shevchenko National University",
                     "country": "Ukraine"
                 }
             }

Get Student 
url: http://localhost:8080/student/1
method: get

Get All Students
url: http://localhost:8080/students
method: get

Update Student
url: http://localhost:8080/student
method: put
body: student JSON
example:     {
                 "id": 1,
                 "nameView": "new name",
                 "specialization": "new specialization"
             }
             
Delete Student
url: http://localhost:8080/student/1
method: delete
