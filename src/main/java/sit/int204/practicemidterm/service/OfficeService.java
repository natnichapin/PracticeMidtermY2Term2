package sit.int204.practicemidterm.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.int204.practicemidterm.entity.Office;
import sit.int204.practicemidterm.repository.OfficeRepository;

import java.util.List;

@Setter
@Service
public class OfficeService {
    @Autowired
    private OfficeRepository repository ;
    public List<Office> getAllOffice(){
        return repository.findAll();
    }

    public  Office creatOffice(Office o){
       return   repository.saveAndFlush(o) ;
    }
    public  Office getOfficeById(String id){
        return   repository.findOfficeById(id) ;
    }

    public void deleteOffice(String officeCode){
         repository.deleteById(officeCode);
    }
    public Office updateOffice(String id,Office o){
        Office existOffice = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Not found"+o.getId())) ;
        existOffice.setCity(o.getCity());
        existOffice.setPhone(o.getPhone());
        existOffice.setAddressLine1(o.getAddressLine1());
        existOffice.setAddressLine2(o.getAddressLine2());
        existOffice.setState(o.getState());
        existOffice.setCountry(o.getCountry() );
        existOffice.setPostalCode(o.getPostalCode());
        existOffice.setTerritory(o.getTerritory());
        return repository.saveAndFlush(o);
    }
}
