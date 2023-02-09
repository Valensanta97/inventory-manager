package tech.konex.inventorymanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Medicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String factoryLaboratory;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dateOfManufacture;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;
    private Long stock;
    private Double unitValue;

    public Medicine() {}

    public Medicine(Long id, String name, String factoryLaboratory, Date dateOfManufacture, Date dueDate, Long stock, Double unitValue) {
        this.id = id;
        this.name = name;
        this.factoryLaboratory = factoryLaboratory;
        this.dateOfManufacture = dateOfManufacture;
        this.dueDate = dueDate;
        this.stock = stock;
        this.unitValue = unitValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFactoryLaboratory(String factoryLaboratory) {
        this.factoryLaboratory = factoryLaboratory;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public String getName() {
        return name;
    }

    public String getFactoryLaboratory() {
        return factoryLaboratory;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Long getStock() {
        return stock;
    }

    public Long getId() {
        return id;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", factoryLaboratory='" + factoryLaboratory + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", dueDate=" + dueDate +
                ", stock=" + stock +
                ", unitValue=" + unitValue +
                '}';
    }
}
