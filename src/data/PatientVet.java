package data;

public class PatientVet {
    private Patient[] vet;
    private int nElem;

    public PatientVet(int tamanho) {
        vet = new Patient[tamanho];
        nElem = 0;
    }

    public int getNElem() {
        return nElem;
    }

    public Patient getPatient(int pos) {
        if (pos >= 0 && pos < nElem) {
            return vet[pos];
        }
        return null;
    }

    public int search(String cpf) {
        for (int i = 0; i < nElem; i++) {
            if (vet[i].getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    public int insert(Patient patient) {
        if (nElem >= vet.length) {
            return -1;
        }
        if (search(patient.getCpf()) != -1) {
            return -2;
        }
        vet[nElem++] = patient;
        return 0;
    }

    public boolean remove(String cpf) {
        int pos = search(cpf);
        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < nElem - 1; i++) {
            vet[i] = vet[i + 1];
        }
        vet[nElem - 1] = null;
        nElem--;
        return true;
    }
}
