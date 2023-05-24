package sit.int204.practicemidterm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sit.int204.practicemidterm.entity.Order;
import sit.int204.practicemidterm.entity.Product;

@Entity
@Setter
@Getter
@Table(name="orderdetails")
public class Orderdetail {

    @Id
    private Integer orderNumber;
    private String productCode ;
//    @OneToOne
//    @JoinColumn(name="productCode")
//    private Product product ;
    private int quantityOrdered ;
    private Double priceEach ;
    @Column(name="orderLineNumber")
    private int LineNo ;



}
