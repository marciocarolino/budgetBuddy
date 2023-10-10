package br.com.BudgetBuddy.service.fixedRevenue;

import br.com.BudgetBuddy.domain.fixed_revenue.FixedRevenue;
import br.com.BudgetBuddy.repository.IFixedRevenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class FixedRevenueService {


    @Autowired
    private IFixedRevenue iFixedRevenueRepository;


    public ResponseEntity<List<FixedRevenue>> getAllFixedRevenue(){
        List<FixedRevenue> fixedRevenues = iFixedRevenueRepository.findAll();
        return ResponseEntity.ok(fixedRevenues);
    }




}
