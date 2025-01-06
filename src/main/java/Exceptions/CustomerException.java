package Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomerException extends RuntimeException {

    public CustomerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Покупателя не существует";
    }
}
