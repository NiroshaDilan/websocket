package lk.icoder.qrgenerator.controller;

import lk.icoder.qrgenerator.model.EmployeeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Project qr-generator
 * @Author DILAN on 1/29/2020
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<String> getEmployeeById (@PathVariable("id") int id)
    {
        log.info("invoking qr engine.....");
            EmployeeVO employee =
                    new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
            return new ResponseEntity<String>("Pending", HttpStatus.OK);
    }
}
