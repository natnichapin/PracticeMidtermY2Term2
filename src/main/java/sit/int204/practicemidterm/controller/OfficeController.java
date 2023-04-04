package sit.int204.practicemidterm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.practicemidterm.dto.OfficeDTO;
import sit.int204.practicemidterm.entity.Office;
import sit.int204.practicemidterm.service.OfficeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
@Autowired
    private OfficeService service ;
@Autowired
    private ModelMapper modelMapper ;

@GetMapping("")
    public List<OfficeDTO> getOffice(){
    return service.getAllOffice().stream().map(x->modelMapper.map(x, OfficeDTO.class)).collect(Collectors.toList());
}

@GetMapping("/{id}")
public OfficeDTO getOfficeById(@PathVariable String id){
    return   modelMapper.map(service.getOfficeById(id), OfficeDTO.class)   ;
}

@PostMapping("")
    public Office createOffice (@RequestBody Office office){
    Office targetoffice = service.creatOffice(office) ;
    return  targetoffice;
}

@PutMapping("/{id}")
    public Office updateOffice (@PathVariable String id ,@RequestBody Office newObj){
    return  service.updateOffice(id,newObj);
}












}
