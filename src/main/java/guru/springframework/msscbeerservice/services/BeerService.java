package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getByID(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDt);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
