import { Hospital } from "./hospital.model";

export interface PatientStatus {
    patientId: number;
    patient: Hospital;
    status: string;
    statusUpdatedTime: Date;
    notes: string;
}
  