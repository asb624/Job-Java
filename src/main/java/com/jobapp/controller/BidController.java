package com.example.jobapp.controller;

import com.jobapp.model.Bid;
import com.example.jobapp.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.createBid(bid);
    }

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }
}