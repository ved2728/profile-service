package com.demo.profileservice.controller;

import com.demo.profileservice.model.ProfileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
public class Controller {
    private Random random = new Random();

    @RequestMapping("/profileInfo/accounts/{accountId}")
    public ProfileInfo getProfileInfoByAccountId(@PathVariable("accountId") long id) {
        log.info("Handling getProfileInfoByAccountId: id={}", id);

        this.randomDelay();

        return new ProfileInfo(id, new Date());
    }

    private void randomDelay() {
        try {
            // sleep a bit
            Thread.sleep((long)(2*random.nextDouble()*1000));
        } catch (Exception e) {
            // ignore
        }
    }
}
