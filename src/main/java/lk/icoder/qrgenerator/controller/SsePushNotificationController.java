package lk.icoder.qrgenerator.controller;

import lk.icoder.qrgenerator.sse.SsePushNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Project qr-generator
 * @Author DILAN on 2/2/2020
 */
@RestController
@Slf4j
@CrossOrigin
public class SsePushNotificationController {

    private SsePushNotificationService service;
    final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SsePushNotificationController(SsePushNotificationService service) {
        this.service = service;
    }

    @GetMapping("/notification")
    public ResponseEntity<SseEmitter> doNotify() throws InterruptedException, IOException {
        log.info("notifying....");
        final SseEmitter emitter = new SseEmitter();
        service.addEmitter(emitter);
        service.doNotify();
        emitter.onCompletion(() -> service.removeEmitter(emitter));
        emitter.onTimeout(() -> service.removeEmitter(emitter));
        return new ResponseEntity<>(emitter, HttpStatus.OK);
    }
}












