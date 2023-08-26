package com.junioroffers.domain.offer;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferFacadeConfiguration {

    @Bean
    OfferFacade offerFacade(OfferFetchable offerFetchable, OfferRepository repository) {
        OfferService offerService = new OfferService(offerFetchable, repository);
        return new OfferFacade(repository, offerService);
    }
}