package com.workintech.fswebs18challengemaven.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CardErrorResponse {
    private String massage;
    private HttpStatus status;

    public CardErrorResponse(String massage, HttpStatus status) {
        this.massage = massage;
        this.status = status;
    }

    public CardErrorResponse(String massage) {
        this.massage = massage;
    }

    public String getMessage() {
        return massage;
    }
}
