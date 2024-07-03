package ru.sberbank.jd.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.repository.GiftRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;

    public Gift createGift(@NonNull GiftInput taskInput) {
        Gift gift = Gift.of(taskInput);
        giftRepository.saveGift(gift);
        return gift;
    }

    public List<Gift> getAllGifts() {
        return giftRepository.getGifts();
    }

    public Gift getGiftById(String id) {
        return giftRepository.getGiftById(id);
    }

    public Gift deleteGiftById(String id) {
        return giftRepository.removeGiftById(id);
    }
}
