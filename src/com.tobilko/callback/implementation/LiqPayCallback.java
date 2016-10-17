package com.tobilko.callback.implementation;

import com.tobilko.callback.PaymentSystemCallback;
import lombok.Data;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
@Data
public class LiqPayCallback extends PaymentSystemCallback {

    private Integer version;

    private String status;
    private String token;
    private String description;

    private String customer;
    private Double amount;
    private String currency;

    private String errorCode;
    private String errorDescription;

}
