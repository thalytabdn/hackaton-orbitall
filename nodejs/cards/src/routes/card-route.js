const api = require('../controllers/card-controller')

module.exports = (app) => {
    app.route('')
        .get(api.findAll)

}