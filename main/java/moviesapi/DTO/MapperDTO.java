package moviesapi.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperDTO {
	
	@Bean // Configuração que será gerenciado pelo Spring
	public ModelMapper modelMapper() {
		
		return  new ModelMapper();
	}
	
	 
	
	

}
