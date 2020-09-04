import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class RandomNumberService {

  randomNumberStream: BehaviorSubject<number> = new BehaviorSubject<number>(0); // stream

  constructor() { }


  getRandomNumbers() {
    // setInterval(()=>{
    //   this.randomNumberStream.next(Math.floor(Math.random()*1000))
    // },1000);

    //SSE
    var eventSource = new EventSource("http://localhost:8080/api/random/numbers");
    eventSource.onmessage = (message) => {
      this.randomNumberStream.next(Number.parseInt(message.data, 10))
    }

    return this.randomNumberStream;

  }

}
