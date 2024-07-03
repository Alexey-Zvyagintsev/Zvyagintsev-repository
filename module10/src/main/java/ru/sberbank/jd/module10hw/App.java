package ru.sberbank.jd.module10hw;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberbank.jd.module10hw.service.HttpService;

@SpringBootApplication
@AllArgsConstructor
public class App
{

    HttpService httpService;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void execute() {
        httpService.getHttp();
    }
}
