# Update VisitingResearcher

Updates the VisitingResearcher.

**URL** : `/api/instructors/visiting-researchers/:id`

**URL Parameters** : `id=[long]`

**Method** : `PUT`

**Sample Request Body**

```json
{
    "phoneNumber": "+905055557555",
    "name": "updateVS2",
    "address": "updateVS2Address",
    "hourlySalary": 66.43
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
        "VisitingResearcher not found for parameters {id='1'}."
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
        "'phoneNumber' must be unique. {rejectedValue: +905055557556}"
    ]
}
```
