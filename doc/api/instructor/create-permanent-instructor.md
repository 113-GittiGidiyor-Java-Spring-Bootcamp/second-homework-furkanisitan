
# Create PermanentInstructor

Creates a new PermanentInstructor.

**URL** : `/api/instructors/permanent-instructors`

**Method** : `POST`

**Sample Request Body**

```json
{
    "phoneNumber": "905057570001",
    "name": "PI2",
    "address": "PI2Address",
    "fixedSalary": 5675.55
}
```

## Success Response

**Code** : `201 CREATED`

**Sample Response Body** :

```json
{
    "success": true,
    "data": {
        "id": 3,
        "phoneNumber": "905057570001",
        "name": "PI2",
        "address": "PI2Address",
        "fixedSalary": 5675.55
    }
}
```

**Header Examples** :

* **Location**: `/api/instructors/:id`

## Error Responses

**Code** : `409 CONFLICT`

**Sample Response Body** : 
```json
{
    "success": false,
    "message": "A unique constraint error has occurred.",
    "errors": [
        "'phoneNumber' must be unique. {rejectedValue: +905055557556}"
    ]
}
```
