package ru.sberbank.jd.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftService;

@RestController
@RequestMapping("/gifts")
@Slf4j
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;

    /**
     * Создание записи о подарке.
     *
     * @param giftInput используем record для ввода
     * @return подарок
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gift createGift(@RequestBody GiftInput giftInput) {
        Gift gift = giftService.createGift(giftInput);
        log.info("Gift created id = {}", gift.getId());
        return gift;
    }

    /**
     * Получение всех записей о подарках.
     *
     * @return json список подарков
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Gift> outAllGifts() {
        log.info("All gifts requested");
        return giftService.getAllGifts();
    }

    /**
     * Получение подарка по id.
     *
     * @param id записи о подарке
     * @return подарок
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gift outGift(@PathVariable("id") String id) {
        log.info("Gift requested by id = {}", id);
        Gift gift = giftService.getGiftById(id);
        if (gift == null) {
            log.info("Wrong gift's id = {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong gift's ID!");
        }
        return giftService.getGiftById(id);
    }

    /**
     * Удаление подарка по id.
     *
     * @param id уникальный идентификатор подарка
     * @return возвращает удаленный обьект подарка
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gift deleteGift(@PathVariable("id") String id) {
        log.info("Gift deleted id = {}", id);
        return giftService.deleteGiftById(id);
    }
}

