const api = require('../controllers/card-controller')

module.exports = (app) => {
    // app.route('/cards')
    //     .get(api.findAll)
    //     .post(api.save)
    //     .delete('/:id', api.remove)

    app.get('/cards', api.findAll)
    app.post('/cards', api.save)
    app.put('/cards/:id', api.update)
    app.delete('/cards/:id', api.remove)
    app.get('/cards/:id', api.findById)
    app.get('/cards/paginationAndSorting', api.orderBy)
    


}