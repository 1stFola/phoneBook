package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dto.requests.AddContactRequest;
import africa.semicolon.phoneBook.dto.responses.FindContactResponse;
import africa.semicolon.phoneBook.dto.responses.AddContactResponse;
import africa.semicolon.phoneBook.dto.responses.DeleteContactResponse;
import africa.semicolon.phoneBook.exceptions.ContactException;
import africa.semicolon.phoneBook.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service // <--- Can you please state the essence of this again, thanks! ?

public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository repository; // <-- Instead of having " = new ContactServiceImplementation " It's been wired to mongoDB implementation.
    @Override
    public AddContactResponse saveContact(AddContactRequest request) {
        Contact contact = ModelMapper.map(request);
        if (mobileExist(request.getMobile()))
            throw new ContactException("Contact exists already");
        Contact theContact = repository.save(contact);
        return ModelMapper.map(theContact);
    }

    private boolean mobileExist(String mobile) {
        Contact contact = repository.findByMobile(mobile);
        return contact != null;
    }

    @Override
    public ContactRepository getRepository() {
        return repository;
    }

    private List<Contact> findContactByFirstNameOrMiddleNameOrLastname(String name){
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(repository.findContactByFirstName(name));
        contacts.addAll(repository.findContactByLastName(name));
        contacts.addAll(repository.findContactByMiddleName(name));
        return contacts;
    }


    @Override
    public List<FindContactResponse> findContactByName(String name) {
        List<Contact> contacts = findContactByFirstNameOrMiddleNameOrLastname(name);
        if (contacts.isEmpty()) throw new ContactException(name + " not found");
        List<FindContactResponse> responses = new ArrayList<>();

        contacts.forEach(contact -> {
//            responses.add(new FindContactResponse(contact));
           responses.add(ModelMapper.contactToFindContactResponse(contact));


        });
        return responses;
    }

    @Override
    public DeleteContactResponse deleteContact(String name, String mobile) {
        List<Contact> theContact = findContactByFirstNameOrMiddleNameOrLastname(name);
        if (theContact.isEmpty()) throw new ContactException(name + " not found");
        theContact.forEach(contact -> {
            if (contact.getMobile().equals(mobile))
                repository.delete(contact);
        });

        DeleteContactResponse response = new DeleteContactResponse();
        response.setMessage("Contact Deleted");
        return response;

    }

//    @Override
//    public AddContactResponse deleteContact(String name, String mobile) {
//        List<Contact> theContact = findContactByFirstNameOrMiddleNameOrLastname(name);
//        theContact.forEach(contact -> {
//            if (contact.getMobile().equals(mobile))
//                repository.delete(contact);
//        });
//        AddContactResponse response = new AddContactResponse();
//        response.setMessage("Contact Deleted");
//        return response;
//
//    }

    //    public void uselessService(){
//        Optional<Contact> optionalContact = repository.findContactByFirstNameAndLastName("No","no");
//        if (optionalContact.isEmpty())throw new IllegalArgumentException();
//        Contact contact = optionalContact.get();
//    }


}
