package com.renlife.cloud.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {

    /**
     * Recursive algorithm for calculating factorial.
     */
    public Long calculate(int i) {
        if(i == 1){
            return 1l;
        }
        return i * calculate(--i);
    }
}
