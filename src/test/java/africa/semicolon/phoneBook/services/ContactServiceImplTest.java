//package africa.semicolon.phoneBook.services;
//
//import africa.semicolon.phoneBook.exception.ContactNotFoundException;
//import africa.semicolon.phoneBook.dto.request.AddContactRequest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactServiceImplTest {
//
//    ContactService contactService;
//    @BeforeEach
//
//
//    void setUp() {
//        contactService = new ContactServiceImpl();
//    }
//
//      private AddContactRequest addContactRequest(){
//        AddContactRequest addContactRequest = new AddContactRequest();
//        addContactRequest.setFirstName("Afolabi");
//        addContactRequest.setMiddleName("Muideen");
//        addContactRequest.setLastName("Sanni");
//        addContactRequest.setMobile("07038396219");
//        addContactRequest.setOffice("08123741508");
//        return addContactRequest;
//
//    }
//
//    @Test
//    void afterContactIsCreated_repositoryContainsOneElement() {
//        AddContactRequest newContact = addContactRequest();
//        contactService.addContactResponse(newContact);
//
//        assertEquals(1, contactService.getRepository().count());
//
//    }
//
//    @Test
//    public void findSavedContactByFirstNameTest() {
//        AddContactRequest newContact = addContactRequest();
//        contactService.addContactResponse(newContact);
//
//        FindByFirstNameResponse response = contactService.findByF_N_Response(newContact.getFirstName());
//
//        assertEquals(response.getFirstName(), "Afolabi");
//        assertEquals(response.getLastName(), "Sanni");
//    }
//
//    @Test
//    public void findingUnRegisteredContact_throwsExceptionTest() {
//        AddContactRequest newContact = addContactRequest();
//        contactService.addContactResponse(newContact);
//
//        assertThrows(ContactNotFoundException.class, () -> contactService.findByF_N_Response("Fola"));
//
//    }
//
//    }