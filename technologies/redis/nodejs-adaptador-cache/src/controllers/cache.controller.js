const { getAsyncRedis, setAsyncRedis, deleteAsyncRedis, keysAsyncRedis } = require('../redis');

// GET: /api/cache
async function getKeys(request, response) {
    try {
        const reply = await keysAsyncRedis('*');
        return response.status(200).send(reply);
    } catch (error) {
        console.log(error);
        return response.send(error.message);
    }
}

// GET: /api/cache/:key
async function getKey(request, response) {
    try {
        const reply = await getAsyncRedis(request.params.key);
        return response.status(200).send(JSON.parse(reply) || {});
    } catch (error) {
        console.log(error);
        return response.send(error.message);
    }
}

// POST: /api/cache
async function saveKey(request, response) {
    await setAsyncRedis(request.body.llave, JSON.stringify(request.body.objeto));
    response.sendStatus(200);
}

// DELETE: /api/cache/:key
async function deleteKey(request, response) {
    try {
        await deleteAsyncRedis(request.params.key);
        return response.status(200).send({});
    } catch (error) {
        console.log(error);
        return response.send(error.message);
    }
}

module.exports = {
    getKeys,
    getKey,
    saveKey,
    deleteKey
}