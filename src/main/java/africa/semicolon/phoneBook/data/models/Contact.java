package africa.semicolon.phoneBook.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor // The instance variable with @NonNull must be present if the constructor is activated.
@EqualsAndHashCode
@Document("Contacts") // <-- This links contact with mongoDB It creates a table for "Contacts" in MongoDB Repo.
@NoArgsConstructor // <-- Constructor overloading... Meaning we can have an instance of this created without and argument.
public class Contact {

    @Id
    private String id;

    private String firstName;
    @NonNull
    private String lastName;

    private String middleName;
    @NonNull
    private String mobile;

    private String office;

//    public Contact(String name, String mobile) {
//    lastName  = name;
//    this.mobile = mobile;
//}
}
