package sit.int204.practicemidterm.controller;


import org.apache.catalina.Service;
import org.apache.catalina.users.SparseUserDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import sit.int204.practicemidterm.dto.OrderDTO;
import sit.int204.practicemidterm.dto.PageDto;
import sit.int204.practicemidterm.dto.SimpleCustomerDTO;
import sit.int204.practicemidterm.entity.Customer;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.service.CustomerService;
import sit.int204.practicemidterm.service.OrderService;
import sit.int204.practicemidterm.utils.ListMapper;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service ;
    @Autowired
    private CustomerService serviceCus ;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private ListMapper listMapper ;

    @GetMapping("/DTO")
    public List<OrderDTO> getOrdersDTO(){
       // SimpleCustomerDTO cusDto =
       List<Order> orders =service.getAllOrders() ;
//        List<Order> Orders = (List<Order>) service.getAllOrders().stream().map(x->{
//               SimpleCustomerDTO cus = modelMapper.map(serviceCus.getCustomerById(x.getCustomerNumber()),SimpleCustomerDTO.class)
        List<OrderDTO> orders1 = listMapper.mapList( orders,OrderDTO.class,modelMapper) ;
//        }
//        List<OrderDTO> orderDTOS =orders1.stream().map((x)->{
//            x.setCustomerDTO(modelMapper.map(serviceCus.getCustomerById(x.getCustomerNumber()),SimpleCustomerDTO.class));
//            return x ;
//        }).collect(Collectors.toList());
        return  orders1 ;
    }

    @GetMapping("")
    public List<Order> getOrders(){
       return   service.getAllOrders();
    }


    @GetMapping("/{id}")
    public Order getOrders(@PathVariable Integer id){
        //System.out.println(service.getOrderById(id).getOrderdetailList());
       // return  service.getOrderById(id).getCustomer();
        Order orderTarget = service.getOrderById(id);
        return  orderTarget;
    }

    @GetMapping("/pages")
    public OrderDTO getPageOrders(@RequestParam (defaultValue = "0")Integer page,@RequestParam(defaultValue = "10")
                                     Integer pageSize ){
        List<Order> p = service.getAllOrders();
        return        modelMapper.map(p,OrderDTO.class) ;
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id,@RequestBody Order order){
        return  service.updateOrder(id,order) ;
    }


    @PostMapping("")
    public Order createOrder(@RequestBody Order order){
        return  service.createOrder(order) ;
    }




    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        service.DeleteOrder(id);
    }




}
