package Belebey.back_3_lab.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }
}
