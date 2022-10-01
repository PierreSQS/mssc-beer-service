package guru.springframework.msscbeerservice.web.mappers;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by Pierrot on 2022-10-01.
 */
@Mapper
public interface BeerMapper {
    // Not Mapped just for Documentation purposes
//    @Mapping(target = "quantityOnHand", source = "minOnHand")
    BeerDto beerToBeerDto(Beer beer);

// Not Mapped just for Documentation purposes
//    @Mapping(target = "minOnHand", source = "quantityOnHand")
    Beer beerDtoToBeer(BeerDto beerDto);
}
