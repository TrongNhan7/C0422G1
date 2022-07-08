package test.product.common;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(String message) {
        super(message);
    }
}
