package dev.rmjr.leadmanagement.infrastructure.exception;

import dev.rmjr.leadmanagement.application.exception.BadRequestException;
import dev.rmjr.leadmanagement.application.exception.NotFoundException;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomErrorDecoderTest {
    Request request = Request.create(Request.HttpMethod.GET, "", Map.of(), Request.Body.create(""), new RequestTemplate());

    @InjectMocks
    CustomErrorDecoder customErrorDecoder;

    @Test
    void givenBadRequestStatus_whenDecode_thenReturnsBadRequestException() {
        Response response = Response.builder()
                .status(400)
                .request(request)
                .build();

        Exception exception = customErrorDecoder.decode("methodKey", response);

        assertInstanceOf(BadRequestException.class, exception);
        assertEquals("Invalid zip code", exception.getMessage());
    }

    @Test
    void givenNotFoundStatus_whenDecode_thenReturnsNotFoundException() {
        Response response = Response.builder()
                .status(404)
                .request(request)
                .build();

        Exception exception = customErrorDecoder.decode("methodKey", response);

        assertInstanceOf(NotFoundException.class, exception);
        assertEquals("Zip code not found", exception.getMessage());
    }

    @Test
    void givenOtherStatus_whenDecode_thenReturnsRuntimeException() {
        Response response = Response.builder()
                .status(500)
                .request(request)
                .build();

        Exception exception = customErrorDecoder.decode("methodKey", response);

        assertInstanceOf(RuntimeException.class, exception);
        assertEquals("Generic error", exception.getMessage());
    }
}
