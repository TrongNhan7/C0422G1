package de_1.util;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(String errorLine) {
        super(errorLine);
    }

    @Override
    public String getMessage() {
        return "Lỗi nhập vào id: " + super.getMessage();
    }

}
