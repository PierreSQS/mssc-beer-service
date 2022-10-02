package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Optimized by Pierrot on 2022-10-01.
 */
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerServ;

    @GetMapping("/{beerId}")
    public BeerDto getBeerById(@PathVariable UUID beerId){

        return beerServ.getByID(beerId);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BeerDto saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        return beerServ.saveNewBeer(beerDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{beerId}")
    public BeerDto updateBeerById(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto){
        return beerServ.updateBeer(beerId,beerDto);
    }

}
