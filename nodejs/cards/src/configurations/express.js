const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const routes = require('../routes/card-route')
const path = require('path')

app.set('clientPath', path.join(__dirname, '../..', 'client'))

app.use(express.static(app.get('clientPath')))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

routes(app)

module.exports = app