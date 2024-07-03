package ru.sberbank.jd.module10hw.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DevHttpServiceImpl implements HttpService {

    @Override
    public String getHttp() {
        log.info("DevHttpServiceImpl");
        return "";
    }

}
