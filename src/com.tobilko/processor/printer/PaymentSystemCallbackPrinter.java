package com.tobilko.processor.printer;

import com.tobilko.callback.PaymentSystemCallback;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public interface PaymentSystemCallbackPrinter<T extends PaymentSystemCallback> {

    String print(T callback);

}
