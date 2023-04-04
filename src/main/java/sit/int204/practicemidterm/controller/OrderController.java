package sit.int204.practicemidterm.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import sit.int204.practicemidterm.dto.OrderDTO;
import sit.int204.practicemidterm.entity.Customer;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.service.OrderService;


import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service ;
    @Autowired
    private ModelMapper modelMapper ;

    @GetMapping("")
    public List<Order> getOrders(){
        return  service.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrders(@PathVariable Integer id){
        //System.out.println(service.getOrderById(id).getOrderdetailList());
       // return  service.getOrderById(id).getCustomer();
        Order orderTarget = service.getOrderById(id);
        return  orderTarget;
    }

    @GetMapping("/pages")
    public Page<Order> getPageOrders(@RequestParam (defaultValue = "0")Integer page,@RequestParam(defaultValue = "10")
                                     Integer pageSize ,@RequestParam String sortBy  ){
        return  service.getPageOrders(page,pageSize,sortBy) ;
    }
}
