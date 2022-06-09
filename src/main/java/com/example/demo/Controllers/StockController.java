package com.example.demo.Controllers;

import com.example.demo.dto.StockDto;
import com.example.demo.model.Stock;
import com.example.demo.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stock")
public class StockController {

     StockService stockService;
    @GetMapping
    public List<Stock> getAllStocks(){
        return  stockService.getAllStocks();

    }
    @GetMapping("/id")
    public StockDto getStockById(long id){
        return  stockService.getStockById(id);
    }

    @PostMapping("add")
    public ResponseEntity<StockDto> addStock(StockDto stockDto){
        return  stockService.addStock(stockDto);
    }


    @PutMapping("/update/id")
    public  StockDto updateStock(StockDto stockDto, long id){
        return  stockService.updateStock(stockDto,id);
    }

    @DeleteMapping("/id")
    public void deleteStockById(Long id){
         stockService.deleteStockById(id);
    }

}
