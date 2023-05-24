package sit.int204.practicemidterm.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper (){return new ModelMapper();}
    @Bean
    public  static  ListMapper listMapper() {
        return ListMapper.getInstance();

    }
}
