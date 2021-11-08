const express = require('express');
const router = express.Router();

const userController = require('../controllers/cache.controller');

router.get('/', userController.getKeys);
router.get('/:key', userController.getKey);
router.post('/', userController.saveKey);
router.delete('/:key', userController.deleteKey);

module.exports = router;