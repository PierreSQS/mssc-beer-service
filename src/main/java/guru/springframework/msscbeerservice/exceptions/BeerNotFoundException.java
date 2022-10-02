package guru.springframework.msscbeerservice.exceptions;

public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(String message) {
        super(message);
    }
}
