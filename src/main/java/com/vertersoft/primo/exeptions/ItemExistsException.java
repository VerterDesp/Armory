package com.vertersoft.primo.exeptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.CONFLICT)
public class ItemExistsException extends RuntimeException {

}
