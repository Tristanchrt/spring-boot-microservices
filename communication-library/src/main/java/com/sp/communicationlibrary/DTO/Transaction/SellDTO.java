package com.sp.communicationlibrary.DTO.Transaction;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class SellDTO {
    @NotNull(message = "Invalid price")
    @Digits(integer =  99999, fraction = 0)
    Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
