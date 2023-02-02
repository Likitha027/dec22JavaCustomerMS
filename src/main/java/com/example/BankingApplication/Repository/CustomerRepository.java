package com.example.BankingApplication.Repository;
import com.example.BankingApplication.CustomerMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerMS, Integer> {
}
