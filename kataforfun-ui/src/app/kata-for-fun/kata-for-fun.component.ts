import { Component, OnInit, OnDestroy } from '@angular/core';
import { ConvertedNumber, KataForFunService } from '../kata-for-fun.service';
import { take } from "rxjs/operators";

@Component({
    selector: 'app-kata-for-fun',
    templateUrl: './kata-for-fun.component.html'
})
export class KataForFunComponent {
    public convertedResults: NumberConverted[];
    private maxResults = 3;

    constructor(private kataForFunService: KataForFunService) {
        this.convertedResults = [];
    }

    convertNumber(inputNumber: number): void {
        this.kataForFunService.convertNumber(inputNumber)
            .pipe(take(1))
            .subscribe(result => this.addConvertedResult(inputNumber, result.result));
    }

    private addConvertedResult(numberToConvert: number, result: string) {
        if (this.convertedResults.length === this.maxResults) {
            this.convertedResults.shift();
        }
        this.convertedResults.push({ numberToConvert, result });
    }

}

interface NumberConverted {
    numberToConvert: number;
    result: string;
}
