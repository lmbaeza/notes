function validarParametro(nombre, val, tipo, obligatorio, cifrasInt, cifrasDec) {
    var mensaje = '';
    if (typeof val == 'undefined' || val == null || val.length == 0) {
        if (obligatorio) mensaje = 'Variable ' + nombre + ' es un campo obligatorio y está indefinida';
    } else {
        var valor = val.toString();
        switch (tipo) {
            case 'String':
                var patternStr = /^[0-9a-zA-ZáéíóúñÁÉÍÚÓÑ#@.,\-_\s]+$/;
                var validPatternStr = true;
                validPatternStr = validPatternStr && patternStr.test(valor);
                if (!validPatternStr) mensaje = 'Parametro String ' + nombre + ' invalido';
                else if (valor.length > cifrasInt) {
                    mensaje = 'Longitud de ' + nombre + ' invalida';
                }
                break;
            case 'Integer':
                if (isNaN(valor)) mensaje = 'La variable ' + nombre + ' debe ser numerica';
                else if (!Number.isInteger(Number(valor))) mensaje = 'La variable ' + nombre + ' debe ser un valor entero';
                else if (valor.length > cifrasInt) {
                    mensaje = 'Longitud de ' + nombre + ' invalida';
                }
                break;
            case 'Float':
                if (isNaN(valor)) mensaje = 'La variable ' + nombre + ' debe ser numerica';
                var vecDecimales = valor.split('.');
                if (vecDecimales[0]) {
                    if (vecDecimales[0].length > cifrasInt) {
                        mensaje = 'Cifra entera de ' + nombre + ' invalida';
                    }
                }
                if (vecDecimales[1]) {
                    if (vecDecimales[1].length > cifrasDec) {
                        mensaje = 'Cifra decimal de ' + nombre + ' invalida';
                    }
                }
                break;
            case 'Date':
                var datePattern = /^((2[0-9]|19)[0-9]{2})-(1[0-2]|0[1-9])-(0[1-9]|[12][0-9]|3[01])$/;
                var validDates = true;
                validDates = validDates && datePattern.test(valor);
                if (!validDates) mensaje = 'Formato de fecha para ' + nombre + ' invalido, formato valido AAAA-MM-DD';
                break;
            case 'Email':
                var emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var validEmails = true;
                validEmails = validEmails && emailPattern.test(valor);
                if (!validEmails) mensaje = 'Formato de email para ' + nombre + ' invalido';
                break;
            case 'Boolean':
                if (typeof val !== "boolean") mensaje = 'La variable ' + nombre + ' debe tener un valor booleano (true, false)';
                break;
        }
    }
    if (mensaje != '') {
        console.log('400', 'Error interno', 'ParametersException', `${mensaje}`);
        return false;
    }
    return true;
}

// return this.validarParametro('x1', body.x1, 'String', true, 200)
//     && this.validarParametro('x2', body.x2, 'String', false, 30)
//     && this.validarParametro('x3', body.x3, 'String', true, 5)
//     && this.validarEnumeracion('x3', body.x3, ["CC", "CE", "PA"])
//     && this.validarParametro('x4', body.x4, 'Integer', true, 17)
//     && this.validarParametro('x5', body.x5, 'Date', true)
//     && this.validarParametro('x6', body.x6, 'String', true, 20)
//     && this.validarParametro('x7', body.x7, 'String', false, 20)
//     && this.validarParametro('x7', body.x7, 'String', true, 20)
//     && this.validarParametro('x8', body.x8, 'String', true, 10)
//     && this.validarParametro('x9', body.x9, 'Email', true, 100)
//     && this.validarParametro('x10', body.x10, 'String', false, 100)
//     && this.validarParametro('x11', body.x11, 'String', false, 100);