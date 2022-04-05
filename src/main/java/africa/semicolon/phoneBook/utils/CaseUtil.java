package africa.semicolon.phoneBook.utils;

import africa.semicolon.phoneBook.dto.requests.AddContactRequest;


public class CaseUtil {

    public static void toSentenceCase(AddContactRequest addContactRequest){
        addContactRequest.setFirstName(convert(addContactRequest.getFirstName()));
        addContactRequest.setMiddleName(convert(addContactRequest.getMiddleName()));
        addContactRequest.setLastName(convert(addContactRequest.getLastName()));
    }

    private static String convert(String string){
        return Character.toUpperCase(string.charAt(0)) + (string.substring(1)).toLowerCase();

//        string = Character.toUpperCase(string.charAt(0)) + string.substring(string.charAt(1)).toLowerCase();
////        string = string.replace(string.charAt(0), Character.toUpperCase(string.charAt(0)));
//        return string;
    }
}

