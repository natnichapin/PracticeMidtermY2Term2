package sit.int204.practicemidterm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import sit.int204.practicemidterm.entity.Customer;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Orderdetail;
import sit.int204.practicemidterm.repository.CustomerRepository;
import sit.int204.practicemidterm.repository.OrderRepository;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private OrderRepository repository ;

    @Autowired
    private Integer orderNumber ;
    private Date orderDate ;
    private String status ;
    private Integer customerNumber ;
    private SimpleCustomerDTO customerDTO;
    private  Orderdetail orderdetail ;





    //ควรทำใน Order detail ไม่ควรมีค่าเป็น List ใน Entity ให้ใช้ Many to one แทน
//    public String statusAll (){
//        return  this.status +" ---> " +this.requiredDate ;
//    }
}
