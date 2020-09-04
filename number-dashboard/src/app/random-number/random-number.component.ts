import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

import { RandomNumberService } from '../random-number.service'

@Component({
  selector: 'app-random-number',
  templateUrl: './random-number.component.html',
  styleUrls: ['./random-number.component.css']
})
export class RandomNumberComponent implements OnInit {

  randomNumber: number = 0;

  constructor(private cd: ChangeDetectorRef, private randomNumberService: RandomNumberService) { }

  ngOnInit(): void {
  }

  getRandomNumbers(event) {
    event.target.disabled=true
    this.randomNumberService.getRandomNumbers()
      .subscribe((nextRandomNumber: number) => {
        this.randomNumber = nextRandomNumber
        this.cd.detectChanges()
      })
  }

}
