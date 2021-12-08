#JAVA TEST

###Endpoints
GET|DELETE
http://localhost:8080/patient/{id}

PUT
http://localhost:8080/patient/{id}

POST
http://localhost:8080/patient

###Important Notes

The app is not deployed, db has been set up locally. As mapping is conducted to provide a copy of the objects in the local db, the app will not run without a db connection.
Please see `application.properties` in task\src\main\resources



When writing Body for PUT and POST requests, the ENUM values must be written in all caps
i.e. "MALE" instead of "male"

e.g.
```
{
    "resourceType": "Patient",
    "identifier": [
        {
            "use": "USUAL",
            "value": "simonnewman"
        }
    ],
    "name": [
        {
            "family": "Newman",
            "given": [ "Simon", "Paul" ]
        }
    ],
    "telecom": [
        {
            "system": "PHONE",
            "value": "(03) 5555 6789",
            "use": "HOME"
        }
    ],
    "gender": "MALE",
    "birthDate": "1998-03-17",
    "address": [
        {
            "line": [
            "3300 Washtenaw"
            ],
            "city": "Ann Harbor",
            "state": "MI",
            "postalCode": "48104",
            "country": "US"
        }
    ]
}
  ```

