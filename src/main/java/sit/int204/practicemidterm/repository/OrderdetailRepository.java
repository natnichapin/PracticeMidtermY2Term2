package sit.int204.practicemidterm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.practicemidterm.entity.Orderdetail;

public interface OrderdetailRepository  extends JpaRepository<Orderdetail,Integer> {
}
