package ru.sberbank.jd.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.model.Gift;
import java.util.HashMap;
import java.util.List;

@Repository
@NoArgsConstructor
public class GiftRepository {

    private HashMap<String, Gift> gifts = new HashMap<>();

    public List<Gift> getGifts(){
        return gifts.values().stream().toList();
    }

    public void saveGift(Gift gift) {
        gifts.put(gift.getId(), gift);
    }

    public Gift getGiftById(String id) {
        return gifts.get(id);
    }

    public Gift removeGiftById(String id) {
        Gift gift = gifts.get(id);
        gifts.remove(id);
        return gift;
    }
}
