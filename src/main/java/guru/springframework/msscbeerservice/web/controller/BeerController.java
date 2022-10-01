package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Optimized by Pierrot on 2022-10-01.
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    @GetMapping("/{beerId}")
    public BeerDto getBeerById(@PathVariable("beerId") UUID beerId){

        //todo impl
        return BeerDto.builder().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        //todo impl
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto){

        //todo impl
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
