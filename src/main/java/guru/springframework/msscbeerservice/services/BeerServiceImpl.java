package guru.springframework.msscbeerservice.services;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.exceptions.BeerNotFoundException;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import guru.springframework.msscbeerservice.web.mappers.BeerMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepo;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getByID(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepo.findById(beerId)
                .orElseThrow(() -> new BeerNotFoundException("Beer not found!!")));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepo.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDtoUpdate) {
        Beer beerToUpdate = beerRepo.findById(beerId).orElseThrow(() -> new BeerNotFoundException("Beer not found!!"));

        beerToUpdate.setBeerName(beerDtoUpdate.getBeerName());
        beerToUpdate.setBeerStyle(beerDtoUpdate.getBeerStyle().toString());
        beerToUpdate.setCreatedDate(beerDtoUpdate.getCreatedDate());
        beerToUpdate.setUpc(beerDtoUpdate.getUpc());
        beerToUpdate.setLastModifiedDate(beerDtoUpdate.getLastModifiedDate());
        beerToUpdate.setPrice(beerDtoUpdate.getPrice());
        beerToUpdate.setMinOnHand(beerDtoUpdate.getQuantityOnHand());
        beerToUpdate.setVersion(beerDtoUpdate.getVersion().longValue());

        Beer savedBeer = beerRepo.save(beerToUpdate);
        return beerMapper.beerToBeerDto(savedBeer);
    }
}
