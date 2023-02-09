package tech.konex.inventorymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.konex.inventorymanagement.exceptions.MedicineNotFoundException;
import tech.konex.inventorymanagement.model.Medicine;
import tech.konex.inventorymanagement.repositories.MedicineRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicineService {

    private MedicineRepository medicineRepository;
    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Medicine createMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public List<Medicine> findMedicines(){
        return medicineRepository.findAll();
    }

    public Medicine findMedicineById(Long id){
        return medicineRepository.findMedicineById(id)
                .orElseThrow(()->new MedicineNotFoundException("Medicine by id " + id + "not found"));
    }

    @Transactional
    public void deleteMedicineById(Long id){
        medicineRepository.deleteMedicineById(id);
    }

    public Medicine updateMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }
}
