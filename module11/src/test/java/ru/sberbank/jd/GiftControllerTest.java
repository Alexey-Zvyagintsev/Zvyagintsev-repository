package ru.sberbank.jd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftService;

@SpringBootTest
@AutoConfigureMockMvc
class GiftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private GiftService giftService;

    @Test
    public void createGift_post_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123")
                .name("balloons")
                .description("many colors")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.createGift(ArgumentMatchers.any())).thenReturn(mockGift);
        mockMvc.perform(post("/gifts").content("{\n" +
                "\t\"name\":\"balloons\",\n" +
                "\t\"description\":\"many colors\"\n" +
                "}").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void notFound_error_404() throws Exception {
        mockMvc.perform(get("/gifts/some-wrong-id")).andExpect(status().isNotFound());
    }

    @Test
    public void outAllGifts_get_200() throws Exception {
        List<Gift> mockGifts = new ArrayList<>();
        mockGifts.add(Gift.builder()
                .id("123")
                .name("balloons")
                .description("many colors")
                .createdDateTime(LocalDateTime.now())
                .build());
        Mockito.when(giftService.getAllGifts()).thenReturn(mockGifts);
        mockMvc.perform(get("/gifts/all").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void outGift_get_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123")
                .name("balloons")
                .description("many colors")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.getGiftById(ArgumentMatchers.anyString())).thenReturn(mockGift);
        mockMvc.perform(get("/gifts/id").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteGift_delete_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123")
                .name("balloons")
                .description("many colors")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.deleteGiftById(ArgumentMatchers.anyString())).thenReturn(mockGift);
        mockMvc.perform(delete("/gifts/id").accept(MediaType.APPLICATION_JSON));
    }
}