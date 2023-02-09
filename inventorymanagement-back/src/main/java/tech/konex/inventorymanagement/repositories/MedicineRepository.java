package tech.konex.inventorymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.konex.inventorymanagement.model.Medicine;

import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    void deleteMedicineById(Long id);
    Optional<Medicine> findMedicineById(Long id);
}
