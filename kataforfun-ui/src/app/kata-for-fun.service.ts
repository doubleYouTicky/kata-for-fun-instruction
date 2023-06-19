import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class KataForFunService {
    constructor() { }

    converNumber(inputNumber: number): string {
        return `${ inputNumber }`;
    }

}
