//package africa.semicolon.phoneBook.data.repositories;
//
//import africa.semicolon.phoneBook.data.models.Contact;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactRepositoryImplTest {
//
//    ContactRepository contactRepository;
//    @BeforeEach
//
//    void setUp() {
//        contactRepository = new ContactRepositoryImpl();
//    }
//
//    @Test
//    void contactCanBeAddedListTest(){
//        //Given
//        Contact fola = new Contact("070383962319", "Afolabi");
//        // When
//        Contact createdContact = contactRepository.addContact(fola);
//        // Assert
//        assertEquals(createdContact.getMobile(), "070383962319");
//        assertEquals(1, contactRepository.count());
//    }
//
//    @Test
//    void contactCanBeSearchedWithANameTest(){
//        //Given
//        Contact fola = new Contact("070383962319", "Afolabi", "Sanni", "Fola", "0812");
//        // When
//        contactRepository.addContact(fola);
//        Contact foundContact = contactRepository.findByName("Sanni");
//        assertEquals("070383962319", foundContact.getMobile());
//    }
//    @Test
//    void contactCanBeDeletedTest(){
//        //Given
//        Contact fola = new Contact("070383962319", "Afolabi", "Sanni", "Fola", "0812");
//        // When
//        contactRepository.addContact(fola);
//        contactRepository.deleteContact("Fola");
//        // Assert
//        assertEquals(0, contactRepository.count());
//    }
//    @Test
//    void contactCanBeEditedTest(){
//        //Given
//        Contact fola = new Contact("070383962319", "Afolabi", "Sanni", "Fola", "0812");
//        // When
//        contactRepository.addContact(fola);
//        assertEquals(fola.getMiddleName(), "Fola");
//        fola.setMiddleName("Folabi");
//        assertEquals("Folabi", fola.getMiddleName());
//    }
//
//}
