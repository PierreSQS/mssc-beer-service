package guru.springframework.msscbeerservice.repositories;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Modified by Pierrot on 2022-12-08.
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageRequest);

    Page<Beer> findAllByBeerName(String beerName, Pageable pageRequest);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageRequest);
}
