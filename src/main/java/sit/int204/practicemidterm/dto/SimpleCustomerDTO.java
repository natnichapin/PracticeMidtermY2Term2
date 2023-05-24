package sit.int204.practicemidterm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String contactLastName;
    private String contactFirstName ;

    public String customerFirstName (){
        return this.contactFirstName;
    }
    public String customerLastName(){
        return this.contactLastName;
    }


}
