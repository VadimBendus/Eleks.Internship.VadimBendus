package com.example.atm.service;

import com.example.atm.domain.ATM;
import com.example.atm.repository.ATMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ATMService {

    @Autowired
    ATMRepository repository;

    public List<ATM> getAllKupuru() {
        //do some smth
        return repository.getAllKupuru();
    }

    public List<ATM> getKupuru() {
        //do some smth
        return repository.getKupuru();
    }

    public List<ATM> getKupuruWithCount() {
        //do some smth
        return repository.getKupuruWithCount();
    }

    public List<ATM> getKupuruByKname(int kupura) {
        //do some smth
        return repository.getKupuruByKname(kupura);
    }

    public int getCount(int kname) {
        //do some smth
        return repository.getCount(kname);
    }

    public int getAccount() {
        //do some smth
        return repository.getAccount();
    }


public String deleteKupuruByKname(String kname) {
    List<ATM> kupur_count = repository.getKupuru();
    List<Integer> deposit = kupurDeposit(kupur_count,kname);

    for (Integer kupura : deposit) {
        repository.deleteKupuruByKname(String.valueOf(kupura));
    }

    return deposit.toString();
}

    private List<Integer> kupurDeposit(List<ATM> kupuru, String kname) {
        int suma = 0;
        int requestedSuma = Integer.parseInt(kname);
        List<Integer> result = new ArrayList<>();
        for (ATM kupura : kupuru) {
            int intKupura = kupura.getKname();
            if (suma < requestedSuma) {
                if(suma+intKupura <= requestedSuma){
               if (intKupura <= requestedSuma){
                result.add(intKupura);
                suma += intKupura;
            }}} else {
                break;
            }
        }
       return result;

    }



    public boolean insertKupuru(ATM atm){
        return repository.insertKupuru(atm);
    }

}
