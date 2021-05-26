package br.com.contato.handler;

import br.com.contato.dao.ErrorMessage;
import br.com.contato.exception.ContatoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ContatoNotFoundHandler {
    private ErrorMessage errorMessage = new ErrorMessage();

    @ResponseBody
    @ExceptionHandler(ContatoNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Object contatoNotFoundHandler(ContatoNotFoundException contatoNotFound){
        errorMessage.setCode("001");
        errorMessage.setMessageError(contatoNotFound.getMessage());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
