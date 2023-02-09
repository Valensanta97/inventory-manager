import { HttpErrorResponse } from '@angular/common/http';
import { Component, ModuleWithProviders, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';
import { MedicineService } from './medicine.service';
import * as dayjs from 'dayjs';
import * as _ from 'lodash';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public medicines: Observable<Medicine[]>;
  public selectedMedicine: Medicine;
  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.getMedicine();
  }

  public getMedicine(): void {
    this.medicines = this.medicineService.getMedicines();
  }

  public onAddMedicine(addForm: NgForm): void {
    const formData = addForm.value;
    const sub = this.medicineService.addMedicine({
      ...formData,
      dateOfManufacture: dayjs(formData.dateOfManufacture).format('YYYY/MM/DD')
    }).subscribe((data) => {
      document.getElementById('modal-close')?.click();
      this.getMedicine();
      sub.unsubscribe();
    });
  }

  public onUpdateMedicine(medicine: Medicine): void {
    const sub = this.medicineService.updateMedicine({
      ...medicine,
      dateOfManufacture: dayjs(medicine.dateOfManufacture).format('YYYY/MM/DD')
    }).subscribe((data) => {
      document.getElementById('modal-close-update')?.click();
      this.getMedicine();
      sub.unsubscribe();
    });
  }

  public onDelete(): void {
    const sub = this.medicineService.deleteMedicine(this.selectedMedicine.id).subscribe((data) => {
      console.log(data)
      document.getElementById('modal-close-delete')?.click();
      this.getMedicine();
      sub.unsubscribe();
    });
  }

  public onOpenModal(mode: string, medicine?: Medicine): void {
    const container = document.getElementById('main-container')
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    this.selectedMedicine = _.cloneDeep(medicine) ?? {} as Medicine;
    this.selectedMedicine.dateOfManufacture = dayjs(this.selectedMedicine.dateOfManufacture).format("YYYY-MM-DD")
    if (mode === 'add') {
      button.setAttribute('data-target', '#addMedicineModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateMedicineModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteMedicineModal');
    }
    container?.appendChild(button);
    button.click();
  }

}
