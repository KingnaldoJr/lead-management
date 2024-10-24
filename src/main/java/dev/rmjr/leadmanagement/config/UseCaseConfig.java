package dev.rmjr.leadmanagement.config;

import dev.rmjr.leadmanagement.application.gateway.ZipCodeGateway;
import dev.rmjr.leadmanagement.application.repository.LeadRepository;
import dev.rmjr.leadmanagement.application.repository.ZipCodeHistoryRepository;
import dev.rmjr.leadmanagement.application.usecase.CreateLeadUseCase;
import dev.rmjr.leadmanagement.application.usecase.FindLeadByEmailUseCase;
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
    public GetAddressDataByZipCodeUseCase getAddressDataByZipCodeUseCase(ZipCodeGateway zipCodeGateway, SaveZipCodeSearchHistoryUseCase saveZipCodeSearchHistoryUseCase) {
        return new GetAddressDataByZipCodeUseCase(zipCodeGateway, saveZipCodeSearchHistoryUseCase);
    }

    @Bean
    public CreateLeadUseCase createLeadUseCase(LeadRepository leadRepository) {
        return new CreateLeadUseCase(leadRepository);
    }

    @Bean
    public FindLeadByEmailUseCase findLeadByEmail(LeadRepository leadRepository) {
        return new FindLeadByEmailUseCase(leadRepository);
    }
}
