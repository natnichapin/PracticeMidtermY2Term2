package sit.int204.practicemidterm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practicemidterm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {



}
