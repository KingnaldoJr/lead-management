package dev.rmjr.leadmanagement.infrastructure.exception;

import dev.rmjr.leadmanagement.application.exception.BadRequestException;
import dev.rmjr.leadmanagement.application.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new BadRequestException("Invalid zip code");
            case 404 -> new NotFoundException("Zip code not found");
            default -> new RuntimeException("Generic error");
        };
    }
}
