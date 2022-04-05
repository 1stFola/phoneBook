package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.dto.responses.DeleteContactResponse;
import africa.semicolon.phoneBook.dto.responses.FindContactResponse;
import africa.semicolon.phoneBook.dto.responses.AddContactResponse;
import africa.semicolon.phoneBook.utils.CaseUtil;
import africa.semicolon.phoneBook.dto.responses.ApiResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.dto.requests.AddContactRequest;
import africa.semicolon.phoneBook.utils.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService theContactService;
    @PostMapping("/save")
    public ResponseEntity<?> saveContact(@RequestBody AddContactRequest request){
        Filter.filter(request);
//            return theContactService.saveContact(request);
        try{
            return new ResponseEntity<>(theContactService.saveContact(request), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<?> findContactByName(@PathVariable("keyword") String name){
        name = Filter.filterName(name);
        try{
            return new ResponseEntity<>(theContactService.findContactByName(name), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()),HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/delete/{name}/{mobile}")
    public ResponseEntity<?> deleteContact(@PathVariable String name, @PathVariable String mobile){
        name = Filter.filterName(name);
        try {
            theContactService.deleteContact(name,mobile);
            return new ResponseEntity<>(new ApiResponse(true,"Deleted Successfully"),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}




  /*  public AddContactResponse saveContact(@RequestBody AddContactRequest request){
        CaseUtil.toSentenceCase(request);
        return theContactService.saveContact(request);
    }
    @GetMapping("/{keyword}")
    public List<FindContactResponse> findContactByName(@PathVariable("keyword") String name){
        return theContactService.findContactByName(name);
    }
*//*
    @GetMapping("/{keyword}")
    public ResponseEntity<?> findContactByName(@PathVariable("keyword") String name){ // This and delete have the same dynamics
       try {
           return new ResponseEntity<>(theContactService.findContactByName(name), HttpStatus.OK);

       } catch (Exception ex) {
           return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
       }
    }*//*


    @DeleteMapping("/delete/{name}/{mobile}")
    public DeleteContactResponse deleteContact(@PathVariable String name, @PathVariable String mobile){
        return theContactService.deleteContact(name,mobile);
    }

}
*/
