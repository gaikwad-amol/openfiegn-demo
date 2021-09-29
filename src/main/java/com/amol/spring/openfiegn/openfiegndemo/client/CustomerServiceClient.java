package com.amol.spring.openfiegn.openfiegndemo.client;

import com.amol.spring.openfiegn.openfiegndemo.configuration.CustomerClientConfiguration;
import com.amol.spring.openfiegn.openfiegndemo.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        value = "customerClient", 
        url = "http://localhost:8081/",
        configuration = CustomerClientConfiguration.class
)
public interface CustomerServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/customers", produces = "application/json")
    List<Customer> getCustomers();

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}", produces = "application/json")
    Customer getCustomerById(@PathVariable("postId") Long postId);
}
