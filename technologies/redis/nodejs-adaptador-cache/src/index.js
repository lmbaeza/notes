const express = require('express');

const responseTime = require('response-time');

const usersRouter = require('./routes/cache.router');

const app = express();

app.use(express.json());

app.use(responseTime());

app.use('/api/cache', usersRouter);

const PORT = process.env.PORT || 3000;

app.listen(PORT, console.log(`server listen on port ${PORT}`));