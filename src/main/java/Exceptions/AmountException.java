package Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AmountException extends RuntimeException {

    public AmountException(String message) {
        super(message);
    }
}
