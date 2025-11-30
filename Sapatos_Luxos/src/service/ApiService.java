package service;

import model.Address;

public class ApiService {

    public Address getAddressByCep(String cep) {
        // Sem internet, sem JSON — super simples
        return new Address(
                cep,
                "Rua Padrão",
                "Cidade Padrão",
                "PE"
        );
    }
}
