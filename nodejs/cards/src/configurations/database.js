const Datastore = require('nedb')
const dbName = './resources/database/cards.db'
let neDB

if (!neDB) {
    neDB = new Datastore({
        filename: dbName,
        autoload: true
    })
    console.log(`[Customers Application - ${(new Date()).toISOString()}] This database [${dbName}] is UP`)
}

module.exports = neDB