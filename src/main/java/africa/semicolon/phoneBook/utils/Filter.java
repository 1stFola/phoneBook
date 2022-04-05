package africa.semicolon.phoneBook.utils;

import africa.semicolon.phoneBook.dto.requests.AddContactRequest;


public class Filter {

    public static void filter(AddContactRequest addContactRequest){
        addContactRequest.setFirstName(covert(addContactRequest.getFirstName()));
        addContactRequest.setMiddleName(covert(addContactRequest.getMiddleName()));
        addContactRequest.setLastName(covert(addContactRequest.getLastName()));
    }

    public static String filterName(String name){
        return covert(name);
    }

    private static String covert(String string){
        return Character.toUpperCase(string.charAt(0)) + (string.substring(1)).toLowerCase();

    }

}
