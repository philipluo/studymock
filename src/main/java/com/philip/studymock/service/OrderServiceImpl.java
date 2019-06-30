package com.philip.studymock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by philipl on 2019/6/30.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CustomerService customerService;

    @Override
    public String getOrderSource() {
        String custName = customerService.getCustomerByNo(110486);
        return custName;
    }
}
