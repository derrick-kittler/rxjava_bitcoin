package com.kittler.derrick.fulapprxjava.service;

import com.kittler.derrick.fulapprxjava.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinBaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);

}
