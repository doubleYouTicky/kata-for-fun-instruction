import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { KataForFunService } from '../kata-for-fun.service';

@Component({
    selector: 'app-kata-for-fun',
    templateUrl: './kata-for-fun.component.html'
})
export class KataForFunComponent implements OnInit, OnDestroy {

    constructor(private kataForFunService: KataForFunService) { }

    ngOnInit(): void {
    }

    ngOnDestroy(): void {
    }

    convertNumber(inputNumber: number): void {
        const output = this.kataForFunService.converNumber(inputNumber);
        console.log({ output });
    }

}

interface NumberConverted {
    numberToConvert: number;
    result: string;
}
