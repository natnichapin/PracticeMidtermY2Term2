package sit.int204.practicemidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.int204.practicemidterm.entity.Customer;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.repository.OrderRepository;


import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository ;

    public List<Order> getAllOrders (){
        return repository.findAll();
    }
    public Page<Order> getPageOrders (int page,int size,String sortBy)
    {
        Sort sort = Sort.by(sortBy) ;
        Pageable pageable = PageRequest.of(page,size,sort);
        return repository.findAll(pageable);


    }

    public  Order getOrderById(Integer id){
        Order order =   repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"+id)) ;
        return order ;
    }
//    public Customer getCustomerOfOrderById (Integer id){
//        Order order =   repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"+id)) ;
//        return order.getCustomer();
//
//    }






}
