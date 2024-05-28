package ru.sberbank.jd.module10hw.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.sberbank.jd.module10hw.service.HttpService;
import ru.sberbank.jd.module10hw.service.PromHttpServiceImpl;
import ru.sberbank.jd.module10hw.service.DevHttpServiceImpl;

@Slf4j
@Configuration
public class AppConfig {

    @Value("${app.http}")
    private String http;

    @Profile("prom")
    @Bean
    public HttpService clientServiceImpl() {
        log.info("http = {}", http);
        return new PromHttpServiceImpl(http);
    }

    @Profile("dev")
    @Bean
    public HttpService clientServiceStubImpl() {
        log.info("http = {}", http);
        return new DevHttpServiceImpl();
    }
}
