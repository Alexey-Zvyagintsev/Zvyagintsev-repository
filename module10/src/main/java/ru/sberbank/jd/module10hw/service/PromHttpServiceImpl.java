package ru.sberbank.jd.module10hw.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
public class PromHttpServiceImpl implements HttpService {

    private String httpEndpoint;

    @Override
    public String getHttp() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(httpEndpoint, String.class);
        log.info("Response : {}",response);
        return "";
    }
}
