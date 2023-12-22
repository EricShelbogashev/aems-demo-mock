package ru.nsu.ooad.aemsdemo.config;

import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api",
                HandlerTypePredicate.forAnnotation(RestController.class));
    }
}