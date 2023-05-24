package sit.int204.practicemidterm.entity;



        import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="orders")
public class Order {

    @Id
    private  int orderNumber ;

    private Date orderDate;
    private Date shippedDate ;
    private String status ;
    private String comments ;
    private Integer customerNumber ;



//    @ManyToOne
//    @JoinColumn(name = "customerNumber")
//    private Customer customer ;

    //ไม่เคยมี col ไม่ต้อง @column
    //ถ้า many to one ต้องแอด เหมือนจะได้เอา object ไป map ที่ตัว office ก้อนนั้น ที่มีก้อนเดียว
}
