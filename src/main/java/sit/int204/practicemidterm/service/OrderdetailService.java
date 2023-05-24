package sit.int204.practicemidterm.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.repository.OrderdetailRepository;

import java.util.List;

@Service
public class OrderdetailService {

    @Autowired
    private OrderdetailRepository orderdetailRepository ;

    public List<Orderdetail> getOrderdetails(){
        return orderdetailRepository.findAll();
    }
    public Orderdetail getdetailByid(int id){
      return   orderdetailRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

}
