import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class KataForFunService {
    constructor(private http: HttpClient) { }

    convertNumber(inputNumber: number): Observable<ConvertedNumber> {
        return this.http
            .get<ConvertedNumber>(`http://localhost:8080/kata-for-fun/${ inputNumber }`);
    }

}

export interface ConvertedNumber {
    result: string
}
