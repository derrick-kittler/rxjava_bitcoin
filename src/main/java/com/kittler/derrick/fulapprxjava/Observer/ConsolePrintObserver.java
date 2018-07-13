package com.kittler.derrick.fulapprxjava.Observer;

import com.kittler.derrick.fulapprxjava.model.CoinBaseResponse;
import io.reactivex.observers.DefaultObserver;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class ConsolePrintObserver extends DefaultObserver {
    @Override
    /*
     * The response from the query to the coin base is consumed by the lambda and
     * prints the timestamp and the data for the coin.
     */
    public void onNext(Object o) {
        Mono<CoinBaseResponse> responseMono = (Mono<CoinBaseResponse>)o;
        responseMono.subscribe(
                coinBaseResponse -> System.out.println("["+LocalDateTime.now()
                        + coinBaseResponse.getData().getBase()
                        + " Buy Price: $ " + coinBaseResponse.getData().getAmount()
                        + " Currency Type: " + coinBaseResponse.getData().getCurrency())
        );
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("[ Error ] " + e.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[ COMPLETED WITHOUT ERROR ]");
    }
}
