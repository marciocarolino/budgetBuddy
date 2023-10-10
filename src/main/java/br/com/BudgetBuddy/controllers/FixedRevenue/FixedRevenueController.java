package br.com.BudgetBuddy.controllers.FixedRevenue;


import br.com.BudgetBuddy.domain.fixed_revenue.FixedRevenue;
import br.com.BudgetBuddy.service.fixedRevenue.FixedRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fixedRevenue")
public class FixedRevenueController {


    @Autowired
   private FixedRevenueService fixedRevenueService;


    @GetMapping
    public ResponseEntity<List<FixedRevenue>> getAllFixedRevenue(){
        return fixedRevenueService.getAllFixedRevenue();
    }
}
