var res = document.querySelector('input#result')
var number1 = 0
var number2 = 0
var op = ''
var resulted = false

function printInput(n) {
    if (op != '' || resulted == true)
        res.value = ''

    if(!(res.value == '' && (n == '00' || n == 0))) {
        res.value += n
        resulted = false
    }
}

function operation(type) {    
    if (type == 'clear') {
        res.value = ''
        return
    }
    if(op == ''){
        number1 = res.value
        op = type
    }  
}

function result() {
    number2 = res.value
    calc(number1, number2, op)
    op = ''
    resulted = true
}


function calc(n1, n2, op) {
    switch (op) {
        case '+':
            res.value = parseInt(n1) + parseInt(n2)
            break
        case '-':
            res.value = parseInt(n1) - parseInt(n2)
            break
        case '*':
            res.value = parseInt(n1) * parseInt(n2)
            break
        case '/':
            res.value = parseInt(n1) / parseInt(n2)
            break
        default:
            alert('Ocorreu algum erro inesperado, tente novamente.')
            break
    }
}