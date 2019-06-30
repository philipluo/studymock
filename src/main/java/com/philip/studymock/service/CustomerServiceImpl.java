package com.philip.studymock.service;

import com.philip.studymock.util.StaticHelper;
import org.springframework.stereotype.Service;

/**
 * Created by philipl on 2019/6/30.
 */
@Service
public class CustomerServiceImpl implements  CustomerService {

    @Override
    public String getCustomerByNo(Integer custNo) {
        String name;
        Integer randomCustPhoneNo = StaticHelper.getRandomInteger();
        if(custNo==110486){
            name = "SYNNEX DEMO";
        }else{
            name = "NOT Found";
        }
        return randomCustPhoneNo + "-" + name;
    }

}
