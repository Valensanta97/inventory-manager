package tech.konex.inventorymanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.konex.inventorymanagement.model.Medicine;
import tech.konex.inventorymanagement.services.MedicineService;

import java.util.List;

@RestController
@RequestMapping("/medicine")

public class MedicineResource {

    private final MedicineService medicineService;

    public MedicineResource(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicine (){
        List<Medicine> medicines = medicineService.findMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable("id") Long id){
        Medicine medicines = medicineService.findMedicineById(id);
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine){
        Medicine medicines = medicineService.createMedicine(medicine);
        return new ResponseEntity<>(medicines, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine){
        Medicine medicines = medicineService.updateMedicine(medicine);
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medicine> deleteMedicine(@PathVariable("id") Long id){
        medicineService.deleteMedicineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

