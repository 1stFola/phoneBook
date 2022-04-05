package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface ContactRepository extends MongoRepository<Contact, String> { // MongoDB is asked to create lists of type "Contact & String - Shed more light
    List <Contact> findContactByFirstName(String firstName);
    List <Contact> findContactByLastName(String lastName);
    List <Contact> findContactByMiddleName(String middleName);
    Contact findByMobile(String mobile);
//    Contact findContactByFirstNameAndLastName(String firstName, String lastName);
//    List<Contact> findContactByFirstNameOrLastName(String firstName, String lastName);
}
