package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.bootstrap.BeerLoader;
import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerServMock;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto beerDto;

    BeerDto savedBeerDto;

    BeerDto updatedBeerDto;

    @BeforeEach
    void setUp() {
        beerDto = BeerDto.builder()
                .beerName("33 Export")
                .beerStyle(BeerStyleEnum.PILSNER)
                .upc(BeerLoader.BEER_1_UPC)
                .price(BigDecimal.valueOf(12.5))
                .build();

        savedBeerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("33 Export")
                .beerStyle(BeerStyleEnum.PILSNER)
                .upc(BeerLoader.BEER_2_UPC)
                .price(BigDecimal.valueOf(12.5))
                .build();

        updatedBeerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("33 Export")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(BeerLoader.BEER_2_UPC)
                .price(BigDecimal.valueOf(24))
                .build();


    }

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/{uuid}" ,UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void saveNewBeer() throws Exception {
        // Given
        String beerDtoJsonToSave = objectMapper.writeValueAsString(beerDto);
        given(beerServMock.saveNewBeer(beerDto)).willReturn(savedBeerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJsonToSave))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(is(not(equalTo(null)))))
                .andExpect(jsonPath("$.beerName").value(equalTo("33 Export")))
                .andDo(print());

        verify(beerServMock).saveNewBeer(beerDto);
    }

    @Test
    void updateBeerById() throws Exception {
        // Given
        String beerDtoJsonToUpdate = objectMapper.writeValueAsString(beerDto);
        given(beerServMock.updateBeer(ArgumentMatchers.any(), ArgumentMatchers.any())).willReturn(updatedBeerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJsonToUpdate))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.beerStyle").value(equalTo("ALE")))
                .andExpect(jsonPath("$.price").value(equalTo("24")))
                .andDo(print());
    }
}