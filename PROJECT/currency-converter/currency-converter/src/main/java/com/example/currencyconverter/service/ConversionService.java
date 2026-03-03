package com.example.currencyconverter.service;

import com.example.currencyconverter.component.ExchangeRateClient;
import com.example.currencyconverter.dto.ConvertRequest;
import com.example.currencyconverter.dto.ConvertResponse;
import com.example.currencyconverter.entity.ConversionRecord;
import com.example.currencyconverter.repository.ConversionRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final ExchangeRateClient rateClient;
    private final ConversionRecordRepository repo;

    public ConvertResponse convert(ConvertRequest req, String apiUser) {

        double rate = rateClient.getRate(req.getFrom(), req.getTo());
        double result = req.getAmount() * rate;

        ConversionRecord record = new ConversionRecord();
        record.setApiUser(apiUser);
        record.setFromCurrency(req.getFrom());
        record.setToCurrency(req.getTo());
        record.setAmount(req.getAmount());
        record.setRate(rate);
        record.setResultAmount(result);
        repo.save(record);

        return new ConvertResponse(req.getFrom(), req.getTo(), req.getAmount(), rate, result);
    }
}
