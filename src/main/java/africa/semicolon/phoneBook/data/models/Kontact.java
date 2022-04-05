package africa.semicolon.phoneBook.data.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode

public class Kontact {
    @NonNull
    private String mobile;
    private String firstName;
    @Getter@Setter
    private String lastName;
    @Getter
    private String middleName;
    private String office;


}
