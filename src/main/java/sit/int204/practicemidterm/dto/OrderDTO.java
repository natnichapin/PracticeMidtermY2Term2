package sit.int204.practicemidterm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Orderdetail;

import java.util.Date;


public class OrderDTO {
    private Integer orderNumber ;
    private String status ;
    @JsonIgnore
    private Date requiredDate ;


    //ควรทำใน Order detail ไม่ควรมีค่าเป็น List ใน Entity ให้ใช้ Many to one แทน
//    public String statusAll (){
//        return  this.status +" ---> " +this.requiredDate ;
//    }
}
