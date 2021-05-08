package com.today10sec.diary.customize.etc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test/config/{key}")
    public String testConfig(@PathVariable(value="key")String key){

        logger.info(key);
        return "";
    }

}
