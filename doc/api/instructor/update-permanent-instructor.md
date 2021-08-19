# Update PermanentInstructor

Updates the PermanentInstructor.

**URL** : `/api/instructors/permanent-instructors/:id`

**URL Parameters** : `id=[long]`

**Method** : `PUT`

**Sample Request Body**

```json
{
    "phoneNumber": "+905055557556",
    "name": "updatePI1",
    "address": "updatePI1Address",
    "fixedSalary": 7975.22
}
```

## Success Response

**Code** : `204 NO CONTENT`

## Error Responses

**Code** : `404 NOT FOUND`

**Sample Response Body** : 
```json
{
    "success": false,
    "message": "No Records Found.",
    "errors": [
        "PermanentInstructor not found for parameters {id='2'}."
    ]
}
```

----

**Code** : `409 CONFLICT`

**Sample Response Body** : 
```json
{
    "success": false,
    "message": "A unique constraint error has occurred.",
    "errors": [
        "'phoneNumber' must be unique. {rejectedValue: +905055557555}"
    ]
}
```
