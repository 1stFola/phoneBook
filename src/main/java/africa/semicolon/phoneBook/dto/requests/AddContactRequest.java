package africa.semicolon.phoneBook.dto.requests;

import lombok.Data;

@Data
public class AddContactRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String office;
}
