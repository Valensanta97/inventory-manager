import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Medicine } from './medicine';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  private apiServerUrl = environment.apiBaseUtl;
  
  constructor(private http: HttpClient) { }

  public getMedicines(): Observable<Medicine[]> {
    return this.http.get<any>(`${this.apiServerUrl}/medicine`)
  }

  public findMedicineById(medicineId: number): Observable<Medicine> {
    return this.http.get<Medicine>(`${this.apiServerUrl}/medicine/find/${medicineId}`);
  }

  public addMedicine(medicine: Medicine): Observable<Medicine> {
    return this.http.post<Medicine>(`${this.apiServerUrl}/medicine`, medicine)
  }

  public updateMedicine(medicine: Medicine): Observable<Medicine> {
    return this.http.put<Medicine>(`${this.apiServerUrl}/medicine`, medicine)
  }

  public deleteMedicine(medicineId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/medicine/${medicineId}`);
  }

}
