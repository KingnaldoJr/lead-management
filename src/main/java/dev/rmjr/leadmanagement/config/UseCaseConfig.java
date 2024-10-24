package dev.rmjr.leadmanagement.config;

import dev.rmjr.leadmanagement.application.gateway.ZipCodeGateway;
import dev.rmjr.leadmanagement.application.repository.ZipCodeHistoryRepository;
import dev.rmjr.leadmanagement.application.usecase.GetAddressDataByZipCodeUseCase;
import dev.rmjr.leadmanagement.application.usecase.SaveZipCodeSearchHistoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase(ZipCodeHistoryRepository zipCodeHistoryRepository) {
        return new SaveZipCodeSearchHistoryUseCase(zipCodeHistoryRepository);
    }

    @Bean
    public GetAddressDataByZipCodeUseCase createLeadUseCase(ZipCodeGateway zipCodeGateway, SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase) {
        return new GetAddressDataByZipCodeUseCase(zipCodeGateway, saveZipCodeSearchHistoryUseCase);
    }
}
