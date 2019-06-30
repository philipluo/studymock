package com.philip.studymock.service;

import org.springframework.stereotype.Service;

/**
 * Created by philipl on 2019/6/30.
 */
@Service
public class CustomerServiceImpl implements  CustomerService {

    @Override
    public String getCustomerByNo(Integer custNo) {
        String name;
        if(custNo==110486){
            name = "SYNNEX DEMO";
        }else{
            name = "NOT Found";
        }
        return name;
    }

}
