package com.tobilko.formatter;

import com.tobilko.callback.PaymentSystemCallback;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public interface PaymentSystemCallbackParser<T extends PaymentSystemCallback> {

    T parse(String response);

}
