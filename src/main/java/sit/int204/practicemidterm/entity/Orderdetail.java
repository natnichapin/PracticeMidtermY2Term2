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


    private int quantityOrdered ;
    private Double priceEach ;
    @Column(name="orderLineNumber")
    private int LineNo ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="productCode")
    private Product product ;

    @Id
    private Integer orderNumber;
    @ManyToOne
    @JoinColumn(name="Orders")
    private Order order ;
}
