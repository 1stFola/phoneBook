package africa.semicolon.phoneBook.dto.responses;

import africa.semicolon.phoneBook.data.models.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FindContactResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String office;

    public FindContactResponse (Contact contact){
        firstName =contact.getFirstName();
        middleName= contact.getMiddleName();
        lastName=contact.getLastName();
        mobile= contact.getMobile();
        office=contact.getOffice();
    }

    public FindContactResponse() {

    }
}
