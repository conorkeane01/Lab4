package ie.atu.userservice.userservice;

import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    private RegistrationServiceClient registrationServiceClient;

    @Autowired
    public UserController(RegistrationServiceClient registrationServiceClient) {
        this.registrationServiceClient = registrationServiceClient;
    }


    @PostMapping("/confirm-and-register")
    public Map<String, String> confirmAndRegister(@RequestBody UserDetails userDetails) {
        String confirm = registrationServiceClient.someDetails(userDetails);
        Map<String, String>responseMessage = new HashMap<>();
        responseMessage.put("Message", confirm);
        return responseMessage;
    }



    /*
    @PostMapping("/confirm-and-register")
    public String confirmAndRegister(@RequestBody UserDetails userDetails) {
        String confirm = registrationServiceClient.someDetails(userDetails);
        String responseMessage = confirm + " Part1 of Lab 4 done ";
        return responseMessage;
    }

     */

}
