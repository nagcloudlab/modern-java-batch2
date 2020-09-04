package com;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/*
 * 
 * 
 *  reactive stream spec
 *  --------------------------
 *  
 *  
 * 
 * 
 * 
 */

public class Ex2 {

	public static void main(String[] args) throws InterruptedException{

		// ---------------------------------------------
		// Trainer
		// ---------------------------------------------

		Observable<String> observableStream = Observable.create(emitter -> {
			System.out.println("subscribed....");
			int i = 1;
			while (i <= 5) {
				String topic = "topic-" + i;
				System.out.println("T-"+Thread.currentThread());
				emitter.onNext(topic); // push
				if (i == 3) {
					// emitter.onError(new IllegalStateException("charger not working"));
				}
				i++;
				if (i == 5)
					emitter.onComplete();
				TimeUnit.SECONDS.sleep(1);
			}
		});

		// ---------------------------------------------

		// ---------------------------------------------
		// Participant-1
		// ---------------------------------------------

		observableStream
		.subscribeOn(Schedulers.io())
		.observeOn(Schedulers.computation())
		.subscribe(nextItem -> {
			System.out.println("P1-"+Thread.currentThread());
			System.out.println("P1:" + nextItem);
		}, error -> {
			System.out.println(error);
		}, () -> {
			System.out.println("------complete------");
		});

		// ---------------------------------------------
		// Participant-2
		// ---------------------------------------------

		observableStream
		.subscribeOn(Schedulers.io())
		.observeOn(Schedulers.computation())
		.subscribe(nextItem -> {
			System.out.println("P1-"+Thread.currentThread());
			System.out.println("P2:" + nextItem);
		}, error -> {
			System.out.println(error);
		}, () -> {
			System.out.println("------complete------");
		});
		
		
		
		TimeUnit.SECONDS.sleep(10);

	}

}
