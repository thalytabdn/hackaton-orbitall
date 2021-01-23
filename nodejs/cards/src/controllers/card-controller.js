const { request, response } = require('express')
const neDB = require('../configurations/database')
const api = {}

api.findAll = (request, response) => {
    neDB.find({}).exec((exception, cards) => {
        if (exception) {
            const setence = 'An error occurred while trying to list all cards!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }

        response.status(200)
        response.json(cards)
    })
}

api.save = (request, response) => {
    const canonical = request.body

    neDB.insert(canonical, (exception, card) => {
        if(exception){
            const sentence = 'An error occurred while trying to create a card!'
            console.log(sentence, exception)
            
            response.status(exception.status | 400)
            response.json( { 'message': sentence } )
        }

        response.status(201)
        response.json(card)
    })
}

api.update = (request, response) => {
    const id = request.params.id;
    const canonical = request.body
    
    neDB.update({ _id: id }, canonical, {}, (exception, numReplaced) => {
        if(exception){
            const sentence = 'An error occurred while trying to update the card!'
            console.log(sentence, exception)
            
            response.status(exception.status | 400)
            response.json( { 'message': sentence } )
        }
        response.status(200)
        response.json(numReplaced)
    }) 
}

api.remove = (request, response) => {
    const id = request.params.id;
    
    neDB.remove( { _id : id }, {}, (exception, numRemoved) =>{
        if(exception){
            const sentence = 'An error occurred while trying to remove the card!'
            console.log(sentence, exception)
            
            response.status(exception.status | 400)
            response.json( { 'message': sentence } )
        }

        response.status(200)
        response.json(numRemoved)
    } )
}

api.findById = (request, response) => {
    const id = request.params.id;
    
    neDB.find( { _id : id }, {}, (exception, card) =>{
        if(exception){
            const sentence = 'An error occurred while trying to find the card!'
            console.log(sentence, exception)
            
            response.status(exception.status | 400)
            response.json( { 'message': sentence } )
        }

        response.status(200)
        response.json(card)
    } )
}

api.orderBy = (request, response) => {
    
    const orderBy = request.query

    neDB.find({}).sort(orderBy).exec((exception, cards) => {
        if (exception) {
            const setence = 'An error occurred while trying to order the cards!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }

        response.status(200)
        response.json(cards)
    })
}

module.exports = api