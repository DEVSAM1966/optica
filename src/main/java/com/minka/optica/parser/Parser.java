package com.minka.optica.parser;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.exceptions.BdNotSaveException;

import java.util.Objects;

public class Parser {

    public static void Evaluator(PatientsDh patientsDh, String action) {
        if ((Objects.equals(patientsDh.getName(), null)) || (patientsDh.getName().isBlank()) || (patientsDh.getName().trim().isEmpty())) {
                throw new BdNotSaveException(action + " - Parameters are incorrect for field name - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getDni(), null)) || (patientsDh.getDni().isBlank()) || (patientsDh.getDni().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field DNI - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getAddress(), null)) || (patientsDh.getAddress().isBlank()) || (patientsDh.getAddress().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field address - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getLocality(), null)) || (patientsDh.getLocality().isBlank()) || (patientsDh.getLocality().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field locality - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getProvince(), null)) || (patientsDh.getProvince().isBlank()) || (patientsDh.getProvince().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field province - is null. empty or blank.");
        }

        if ((Objects.equals(patientsDh.getLocality(), null)) || (patientsDh.getLocality().isBlank()) || (patientsDh.getLocality().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field locality - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getZipCode(), null)) || (patientsDh.getZipCode().isBlank()) || (patientsDh.getZipCode().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field zipCode - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getPhone(), null)) || (patientsDh.getPhone().isBlank()) || (patientsDh.getPhone().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field phone - is null, empty or blank.");
        }

        if ((Objects.equals(patientsDh.getDischargeDate(), null)) || (patientsDh.getDischargeDate().isBlank()) || (patientsDh.getDischargeDate().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field dischargeDate - is null, empty or blank.");
        }
    }

    public static void Evaluator(OptometriesDh optometriesDh, String action) {
        if ((Objects.equals(optometriesDh.getDischargeDate(), null)) || (optometriesDh.getDischargeDate().isBlank()) || (optometriesDh.getDischargeDate().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field dischargeDate - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getOptometrist(), null)) || (optometriesDh.getOptometrist().isBlank()) || (optometriesDh.getOptometrist().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field optometrist - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getSymptons(), null)) || (optometriesDh.getSymptons().isBlank()) || (optometriesDh.getSymptons().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field symptons - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getVaReNc(), null)) || (optometriesDh.getVaReNc().isBlank()) || (optometriesDh.getVaReNc().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field vaReNc - is null, empty or blank.");
        }

        if (Objects.equals(optometriesDh.getReAxis(), null)) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field reAxis - is null.");
        }

        if ((Objects.equals(optometriesDh.getReCylinder(), null)) || (optometriesDh.getReCylinder().isBlank()) || (optometriesDh.getReCylinder().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field reCylinder - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getReSphere(), null)) || (optometriesDh.getReSphere().isBlank()) || (optometriesDh.getReSphere().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field reSphere - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getReAdd(), null)) || (optometriesDh.getReAdd().isBlank()) || (optometriesDh.getReAdd().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field reAdd - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getVaReWc(), null)) || (optometriesDh.getVaReWc().isBlank()) || (optometriesDh.getVaReWc().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field vaRecWc - is null, empty or blank.");
        }
        if ((Objects.equals(optometriesDh.getVaLeNc(), null)) || (optometriesDh.getVaLeNc().isBlank()) || (optometriesDh.getVaLeNc().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field vaLeNc - is null, empty or blank.");
        }

        if (Objects.equals(optometriesDh.getLeAxis(), null)) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field leAxis - is null.");
        }

        if ((Objects.equals(optometriesDh.getLeCylinder(), null)) || (optometriesDh.getLeCylinder().isBlank()) || (optometriesDh.getLeCylinder().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field LeCylinder - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getLeSphere(), null)) || (optometriesDh.getLeSphere().isBlank()) || (optometriesDh.getLeSphere().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field leSphere - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getLeAdd(), null)) || (optometriesDh.getLeAdd().isBlank()) || (optometriesDh.getLeAdd().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field leAdd - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getVaLeWc(), null)) || (optometriesDh.getVaLeWc().isBlank()) || (optometriesDh.getVaLeWc().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field vaLeWc - is null, empty or blank.");
        }

        if ((Objects.equals(optometriesDh.getDnp(), null)) || (optometriesDh.getDnp().isBlank()) || (optometriesDh.getDnp().trim().isEmpty())) {
            throw new BdNotSaveException(action + " - Parameters are incorrect for field dnp - is null, empty or blank.");
        }
    }
}
