package sit.int204.practicemidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practicemidterm.entity.Order;


public interface OrderRepository extends JpaRepository<Order,Integer> {
}
