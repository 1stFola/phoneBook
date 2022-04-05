package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dto.requests.AddContactRequest;
import africa.semicolon.phoneBook.dto.responses.DeleteContactResponse;
import africa.semicolon.phoneBook.dto.responses.FindContactResponse;
import africa.semicolon.phoneBook.dto.responses.AddContactResponse;

import java.util.List;

public interface ContactService {

    AddContactResponse saveContact(AddContactRequest request);
    List <FindContactResponse> findContactByName(String name);
//    DeleteContactResponse deleteContact(String name, String mobile);
    DeleteContactResponse deleteContact(String name, String mobile);
    ContactRepository getRepository();
}


