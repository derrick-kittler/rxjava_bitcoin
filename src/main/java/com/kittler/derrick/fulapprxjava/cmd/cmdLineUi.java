package com.kittler.derrick.fulapprxjava.cmd;

import com.kittler.derrick.fulapprxjava.Observer.ConsolePrintObserver;
import com.kittler.derrick.fulapprxjava.service.CoinBaseService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;


@Component
public class cmdLineUi implements CommandLineRunner {


    @Autowired
    private CoinBaseService coinBaseService;

    @Override
    public void run(String... args) throws Exception {

        System.out.print("\r\n----[ RxJava Coin Base Application ]----\r\n");

        /* Observable emits a tick every 3 seconds and calls for the current
         * price for BTC and ETH and prints the results via the ConsolePrintObserver
         * which is subscribed to the observer to the console window.
         */
        Observable.interval(3000,TimeUnit.MILLISECONDS, Schedulers.io() )
                .map(tick->
                        coinBaseService.getCryptoPrice("BTC-USD")
                ).subscribe(new ConsolePrintObserver());

        Observable.interval(3000,TimeUnit.MILLISECONDS, Schedulers.io() )
                .map(tick->
                        coinBaseService.getCryptoPrice("ETH-USD")
                ).subscribe(new ConsolePrintObserver());

    }
}


