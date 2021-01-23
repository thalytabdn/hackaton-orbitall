const api = require('../controllers/card-controller')

module.exports = (app) => {

    app.get('/cards/paginationAndSorting', api.orderBy)
    app.get('/cards', api.findAll)
    app.post('/cards', api.save)
    app.put('/cards/:id', api.update)
    app.delete('/cards/:id', api.remove)
    app.get('/cards/:id', api.findById)

}