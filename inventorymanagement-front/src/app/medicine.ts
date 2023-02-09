export interface Medicine {
    id: number;
    name: string;
    factoryLaboratory: string;
    dateOfManufacture: string;
    dueDate: Date;
    stock: number;
    unitValue: DoubleRange
}