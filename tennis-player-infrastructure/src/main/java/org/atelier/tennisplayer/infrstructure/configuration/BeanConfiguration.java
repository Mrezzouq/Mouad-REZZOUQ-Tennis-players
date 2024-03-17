package org.atelier.tennisplayer.infrstructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atelier.tennisplayer.domain.port.in.TennisPlayerUseCase;
import org.atelier.tennisplayer.domain.port.out.TennisPlayerRepository;
import org.atelier.tennisplayer.domain.usecases.TennisPlayerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public TennisPlayerUseCase tennisPlayerUseCase(TennisPlayerRepository tennisPlayerRepository) {
        return new TennisPlayerService(tennisPlayerRepository);
    }
}
