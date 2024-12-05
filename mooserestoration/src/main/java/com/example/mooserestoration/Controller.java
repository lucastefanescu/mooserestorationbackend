package com.example.mooserestoration;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = {"https://mooserestoration.onrender.com", "https://mooserestoration.ca"})

public class Controller {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/quote")
    public ResponseEntity<String> quoteForm(@RequestBody QuoteForm quoteForm){
        try{
            if(!quoteForm.getName().isEmpty() && !quoteForm.getEmail().isEmpty()
                    && !quoteForm.getPhoneNumber().isEmpty()
                    && !quoteForm.getDescription().isEmpty()){
                emailSenderService.sendEmail("mooserestorationca@gmail.com",
                        "New Quote Request From Website",
                        "Email: " + quoteForm.getEmail() + "\n"
                            + "Phone Number: " + quoteForm.getPhoneNumber() + "\n"
                            + "Description: " + quoteForm.getDescription());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Message Sent Successfully");
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing/Incorrect Form Fields");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
