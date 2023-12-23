package ru.nsu.ooad.aemsdemo.config;

import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Настраивает PathMatchConfigurer.
     * Добавляет префикс "/api" ко всем контроллерам, аннотированным @RestController.
     *
     * @param configurer Конфигуратор PathMatch для настройки
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api",
                HandlerTypePredicate.forAnnotation(RestController.class));
    }

    /**
     * Настройка параметров Cross-Origin Resource Sharing (CORS).
     * Разрешает определенные источники, методы HTTP и заголовки для URL-шаблонов "/api/v1/**".
     *
     * @param registry Реестр Cors для настройки
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}
