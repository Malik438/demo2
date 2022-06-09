package com.example.demo.services;

import com.example.demo.dto.StockDto;
import com.example.demo.model.Stock;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StockService {


    public List<Stock> getAllStocks();

    public StockDto getStockById(long id);


    public ResponseEntity<StockDto> addStock(StockDto stockDTO) ;





    public StockDto updateStock(StockDto stockDTO, long id) ;



    public void deleteStockById(long id) ;




}
