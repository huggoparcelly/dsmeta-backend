package com.devsuperior.dsmeta.services.serviceImp;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImp implements SmsService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
        String msg = "O vendedor " + sale.getSellerName() + " foi destaque em " + date
                + " com um total de R$ " + String.format("%.2f", sale.getAmount());


        System.out.println(msg);
    }
}
