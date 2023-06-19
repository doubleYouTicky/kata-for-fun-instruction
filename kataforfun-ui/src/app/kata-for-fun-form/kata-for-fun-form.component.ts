import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-kata-for-fun-form',
    templateUrl: './kata-for-fun-form.component.html'
})
export class KataForFunFormComponent {
    submitNumberOutput: EventEmitter<number>;

    numberForm: FormGroup;

    constructor(private formBuilder: FormBuilder) {
        this.numberForm = this.formBuilder.group({
            inputNumber: ['', [Validators.required, Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
        });
    }

    submitForm() {
        if (this.numberForm.valid) {
            const numberToConvert = +this.numberForm.value.inputNumber;
            this.submitNumber(numberToConvert);
        }
    }

    submitNumber(number: number) {
        this.submitNumberOutput.emit(number);
    }

}
