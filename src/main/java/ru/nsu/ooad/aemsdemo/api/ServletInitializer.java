package ru.nsu.ooad.aemsdemo.api;

import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.support.*;
import ru.nsu.ooad.aemsdemo.*;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AemsDemoApplication.class);
    }

}
