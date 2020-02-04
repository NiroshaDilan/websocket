package lk.icoder.qrgenerator.controller;

import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * @Project qr-generator
 * @Author DILAN on 2/1/2020
 */
@RestController
@CrossOrigin
public class GreetingController {

    private Gson gson = new Gson();

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public String greeting(@Payload String message, Principal principal) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello " + HtmlUtils.htmlEscape(helloMessage.getName()) + " !");

        return message;

    }

   @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
   }
}
