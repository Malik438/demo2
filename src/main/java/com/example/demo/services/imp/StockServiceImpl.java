package com.example.demo.services.imp;

import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Repositories.StockRepository;
import com.example.demo.dto.StockDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Stock;
import com.example.demo.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class StockServiceImpl implements StockService {
    @Autowired
    public StockRepository stockRepository;
    @Autowired
    public ProductRepository productRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public StockDto getStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("stock", "id", id));
        return mapToDTO(stock);

    }

    public ResponseEntity<StockDto> addStock(StockDto stockDTO) {

        Stock stock= mapToEntity(stockDTO);
        Stock newStock = stockRepository.save(stock);
        StockDto stockResponse = mapToDTO(stock);
        return new ResponseEntity<StockDto>(stockResponse, HttpStatus.CREATED);


    }


    public StockDto updateStock(StockDto stockDTO, long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("stock", "id", id);
        });

        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        return mapToDTO(stock);
    }


    public void deleteStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("stock", "id", id));
        stockRepository.delete(stock);
    }


    // convert Entity into DTO
    private StockDto mapToDTO(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getStockId());
        stockDto.setUpdateAt(stock.getUpdateAt());
        stockDto.setQuantity(stock.getQuantity());
        return stockDto;
    }

    // convert DTO to entity
    private Stock mapToEntity(StockDto stockDTO) {
        Stock stock = new Stock();
        stock.setStockId(stockDTO.getId());
        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdateAt(stockDTO.getUpdateAt());
        return stock;
    }
}
