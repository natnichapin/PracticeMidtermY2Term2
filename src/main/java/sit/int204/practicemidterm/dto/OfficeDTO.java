package sit.int204.practicemidterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeDTO {
    private String OfficeId;
    private String City ;
    private String phone ;

    public String Call (){
        return "call--->"+this.phone ;
    }
}
