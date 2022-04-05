package africa.semicolon.phoneBook.utils;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.dto.requests.AddContactRequest;
import africa.semicolon.phoneBook.dto.responses.FindContactResponse;
import africa.semicolon.phoneBook.dto.responses.AddContactResponse;

public class ModelMapper {
    public static Contact map(AddContactRequest request) {
        Contact theContact = new Contact();
        theContact.setFirstName(request.getFirstName());
        theContact.setMiddleName(request.getMiddleName());
        theContact.setLastName(request.getLastName());
        theContact.setMobile(request.getMobile());
        theContact.setOffice(request.getOffice());
        return theContact;
    }
    public static AddContactResponse map (Contact theContact){
        AddContactResponse response = new AddContactResponse();
        response.setFullName(theContact.getFirstName() + " " + theContact.getMiddleName() + " " + theContact.getLastName());
        response.setMobile(theContact.getMobile());
        response.setMessage("Contact Saved");
        return response;
    }

    public static FindContactResponse contactToFindContactResponse(Contact contact) {
        FindContactResponse response = new FindContactResponse();
        response.setFirstName(contact.getFirstName());
        response.setMiddleName(contact.getMiddleName());
        response.setLastName(contact.getLastName());
        response.setMobile(contact.getMobile());
        response.setOffice(contact.getOffice());
        return response;
    }
}