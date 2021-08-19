# Create VisitingResearcher

Creates a new VisitingResearcher.

**URL** : `/api/instructors/visiting-researchers`

**Method** : `POST`

**Sample Request Body**

```json
{
    "phoneNumber": "+905057570002",
    "name": "VS2",
    "address": "VS2Address",
    "hourlySalary": 12.53
}
```

## Success Response

**Code** : `201 CREATED`

**Sample Response Body** :

```json
{
    "success": true,
    "data": {
        "id": 5,
        "phoneNumber": "+905057570002",
        "name": "VS2",
        "address": "VS2Address",
        "hourlySalary": 12.53
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
