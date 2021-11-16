# Update using Filters

#### Ingresar Datos
```javascript
db.users.insertMany([
    {
        name: "Luis",
        hobbies: [
            {
                title: "Sport",
                frecuency: 2
            },
            {
                title: "Competitive Programming",
                frecuency: 5
            }
        ]
    },
    {
        name: "Max",
        hobbies: [
            {
                title: "Sport",
                frecuency: 3
            },
            {
                title: "chess",
                frecuency: 7
            }
        ]
    }
]);

db.users.find().pretty();
```

### `Output:`

```javascript
{
        "_id" : ObjectId("611d5d10f9030b6d7afbe417"),
        "name" : "Luis",
        "hobbies" : [
                {
                        "title" : "Sport",
                        "frecuency" : 2
                },
                {
                        "title" : "Competitive Programming",
                        "frecuency" : 5
                }
        ]
}
{
        "_id" : ObjectId("611d5d10f9030b6d7afbe418"),
        "name" : "Max",
        "hobbies" : [
                {
                        "title" : "Sport",
                        "frecuency" : 3
                },
                {
                        "title" : "chess",
                        "frecuency" : 7
                }
        ]
}
```

#### Filtro

```javascript
db.users.updateMany({
        "hobbies.frecuency": {$gte: 2}
    },
    {
        $set: {
            "hobbies.$[el].goodFrecuency": true
        }
    },{
        arrayFilters: [
            {
                "el.frecuency": {
                    $gte: 5
                }
            }
        ]
    }
)
db.users.find().pretty();
```

### `Output:`

```javascript
{
        "_id" : ObjectId("611d5d10f9030b6d7afbe417"),
        "name" : "Luis",
        "hobbies" : [
                {
                        "title" : "Sport",
                        "frecuency" : 2
                },
                {
                        "title" : "Competitive Programming",
                        "frecuency" : 5,
                        "goodFrecuency" : true
                }
        ]
}
{
        "_id" : ObjectId("611d5d10f9030b6d7afbe418"),
        "name" : "Max",
        "hobbies" : [
                {
                        "title" : "Sport",
                        "frecuency" : 3
                },
                {
                        "title" : "chess",
                        "frecuency" : 7,
                        "goodFrecuency" : true
                }
        ]
}
```