const { promisify } = require('util');

const redis = require('redis');

const client = redis.createClient({
    host: 'redis-cache',
    port: 6379
});

module.exports = {
    getAsyncRedis: promisify(client.get).bind(client),
    setAsyncRedis: promisify(client.set).bind(client),
    deleteAsyncRedis: promisify(client.del).bind(client),
    keysAsyncRedis: promisify(client.keys).bind(client),
}


