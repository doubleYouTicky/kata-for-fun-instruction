import { Component, OnInit, OnDestroy } from '@angular/core';
import { KataForFunService } from '../kata-for-fun.service';
import { take } from "rxjs/operators";

@Component({
    selector: 'app-kata-for-fun',
    templateUrl: './kata-for-fun.component.html'
})
export class KataForFunComponent {

    constructor(private kataForFunService: KataForFunService) { }

    convertNumber(inputNumber: number): void {
        const output = this.kataForFunService.convertNumber(inputNumber)
            .pipe(take(1))
            .subscribe(console.log);
    }

}

interface NumberConverted {
    numberToConvert: number;
    result: string;
}
