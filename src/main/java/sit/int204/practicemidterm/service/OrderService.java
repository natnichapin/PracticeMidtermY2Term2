package sit.int204.practicemidterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.int204.practicemidterm.entity.Customer;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.repository.CustomerRepository;
import sit.int204.practicemidterm.repository.OrderRepository;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository ;
    private CustomerRepository repositoryCus;
    public List<Order> getAllOrders (){
        return repository.findAll();
    }
    public Page<Order> getPageOrders (int page,int size)
    {

        Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable);


    }

    public Order createOrder(Order order){
       return repository.saveAndFlush(order) ;
    }

    public Order updateOrder(int id,Order order) {
       // Customer customer = repositoryCus.findById(order.getCustomerNumber()).orElseThrow(()->new RuntimeException());;
        Order exOrder = repository.findById(id).orElseThrow(()->new RuntimeException());
        exOrder.setOrderDate(order.getOrderDate());
        exOrder.setShippedDate(order.getShippedDate());
        exOrder.setStatus(order.getStatus());
        exOrder.setComments(order.getComments());
        exOrder.setCustomerNumber(order.getCustomerNumber());
        return repository.saveAndFlush(exOrder) ;
    }



    public void DeleteOrder(int id){

        repository.deleteById(id);
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
