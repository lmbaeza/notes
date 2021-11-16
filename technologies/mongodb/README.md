# Demo MongoDB

##  `One to Many`

#### Usar una Base de datos

```javascript
use university_db;
```

#### Agregar Schema Validation

`OnetoMany relationship`

* ##### University
    ```javascript
    db.createCollection('university', {
        validator: {
            $jsonSchema: {
                bsonType: 'object',
                required: ['name', 'faculties'],
                properties: {
                    name: {
                        bsonType: 'string',
                        description: 'some description'
                    },
                    faculties: {
                        bsonType: 'array',
                        description: 'some description for faculties',
                        items: {
                            bsonType: 'objectId'
                        }
                    }
                }
            }
        }
    });
    ```
* ##### Faculty
    ```javascript
    db.createCollection('faculty', {
        validator: {
            $jsonSchema: {
                bsonType: 'object',
                required: ['name', 'careers'],
                properties: {
                    name: {
                        bsonType: 'string',
                        description: 'some description'
                    },
                    careers: {
                        bsonType: 'array',
                        description: 'some description for careers',
                        items: {
                            bsonType: 'objectId'
                        }
                    }
                }
            }
        }
    });
    ```

#### Ingresando Datos

```javascript
// Insertar Facultades
db.faculty.insertOne({name: 'Faculty 1', careers: []});
// ObjectId("611c2929e6b84f431b24791a")
db.faculty.insertOne({name: 'Faculty 2', careers: []});
// ObjectId("611c292de6b84f431b24791b")

// Insertar Universidades
db.university.insertOne({name: 'University 1', faculties: [ObjectId("611c2929e6b84f431b24791a"), ObjectId("611c292de6b84f431b24791b")]});
// ObjectId("611c2990e6b84f431b24791c")
```

#### Unir Relación `One to Many`

```javascript
db.university.aggregate([
    {
        $lookup: {
            from: 'faculty',
            localField: 'faculties',
            foreignField: '_id',
            as: 'faculties'
        }
    },
     {
        "$project": {
          "faculties._id": 0,
        }
    }
]).pretty()
```

* **from:** the collection we want to join with
* **localField:** the field we want to join by in the local collection (the collection we are running the query on)
* **foreignField:** the field we want to join by in the foreign collection (the collection we want to join with)
* **as:** the name of the output array for the results

## Referencias

[MongoDB $lookup in 5 Minutes](https://www.stackchief.com/tutorials/%24lookup%20Examples%20%7C%20MongoDB)
