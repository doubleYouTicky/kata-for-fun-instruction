import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-kata-for-fun-form',
    templateUrl: './kata-for-fun-form.component.html'
})
export class KataForFunFormComponent {
    @Output() submitNumberOutput = new EventEmitter<number>();
    @ViewChild('formElement') formElement: ElementRef;
    

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
            this.resetForm();
        }
    }

    private resetForm() {
        this.numberForm.reset();

        Object.keys(this.numberForm.controls).forEach(key => {
            this.numberForm.get(key).markAsUntouched();
            this.numberForm.get(key).markAsPristine();
        });

        this.formElement.nativeElement.reset();
    }

    submitNumber(number: number) {
        this.submitNumberOutput.emit(number);
    }

}
