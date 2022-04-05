package africa.semicolon.phoneBook.dto.responses;

import lombok.Data;

@Data
public class AddContactResponse {
    private String fullName;
    private String mobile;
    private String message;
}
