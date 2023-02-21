package com.example.BankingApplication;
import com.example.BankingApplication.Exception.ResourceNotFoundException;
import com.example.BankingApplication.Repository.CustomerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.apache.log4j.Level;

@RestController
@RequestMapping("/bank")
public class CustomerController {
    @Autowired
    private CustomerRepository cRepo;
    private final static Logger LOGGER = Logger.getLogger(CustomerController.class);

    @PostMapping("/addCustomer")
    @ResponseBody
    public String AddCustomer(@RequestBody CustomerMS customerMS) {
        return cRepo.save(customerMS) + "Customer added successfully";
    }

    @GetMapping("/all")
    public List<CustomerMS> getAllCustomers() {

        LOGGER.log(Level.INFO, "Executing CustomerMS");
        LOGGER.info("Checking all Customer");
        return cRepo.findAll();
    }

    @GetMapping("/getCustomer{CustomerId}")
    public ResponseEntity<CustomerMS> getCustomer(@PathVariable Integer CustomerId) {
        CustomerMS customerMS = cRepo.findById(CustomerId).orElseThrow(() -> new ResourceNotFoundException("customer not exist with Id:" + CustomerId));
        LOGGER.log(Level.INFO, "Executing CustomerMS");
        LOGGER.info("Checking Customer By Id " + CustomerId);
        return ResponseEntity.ok(customerMS);
    }

    @PutMapping("/update{CustomerId}")
    @ResponseBody
    public ResponseEntity<CustomerMS> updateCustomer(@PathVariable Integer CustomerId, @RequestBody CustomerMS customerMS) {
        CustomerMS updateCustomer = cRepo.findById(CustomerId).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id:" + CustomerId));
        updateCustomer.setCustomerId(customerMS.getCustomerId());
        updateCustomer.setCustomerName(customerMS.getCustomerName());
        updateCustomer.setEmailId(customerMS.getEmailId());
        updateCustomer.setGender(customerMS.getGender());
        updateCustomer.setPanCard(customerMS.getPanCard());
        updateCustomer.setAddress(customerMS.getAddress());
        cRepo.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/delete/{CustomerId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer CustomerId) {
        CustomerMS deleteCustomer = cRepo.findById(CustomerId).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id:" + CustomerId));
        cRepo.delete(deleteCustomer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
