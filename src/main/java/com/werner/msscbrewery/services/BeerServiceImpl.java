package com.werner.msscbrewery.services;

import com.werner.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Coors")
                .beerStyle("Lager")
                .upc(1234L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .upc(beerDto.getUpc())
                .beerStyle(beerDto.getBeerStyle())
                .beerName(beerDto.getBeerName())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo add real impl
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer with id ", beerId.toString());
    }
}
