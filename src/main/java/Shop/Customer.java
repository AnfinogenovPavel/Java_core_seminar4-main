package Shop;

import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    private String surnameFirstNamePatronymic;
    private int age;
    private String phone;
    private String gender;

    public boolean isMale() {
        return "муж".equalsIgnoreCase(gender);
    }
}
