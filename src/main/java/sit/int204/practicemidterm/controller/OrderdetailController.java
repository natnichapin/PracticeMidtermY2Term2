package sit.int204.practicemidterm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.service.OrderdetailService;

import java.util.List;

@RestController
@RequestMapping("/api/Orderdetail")
public class OrderdetailController {
    @Autowired
    private OrderdetailService orderdetailService ;

    @GetMapping("")
    public List<Orderdetail> getOrderdatail(){

        return orderdetailService.getOrderdetails();
    }

    @GetMapping("/{id}")
    public Orderdetail getOrderdetail(@PathVariable int id){
        return orderdetailService.getdetailByid(id);
    }
}
