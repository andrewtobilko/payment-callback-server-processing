package com.tobilko.processor.printer.implementation;

import com.tobilko.callback.implementation.PayPalCallback;
import com.tobilko.processor.printer.PaymentSystemCallbackPrinter;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public final class PayPalCallbackPrinter implements PaymentSystemCallbackPrinter<PayPalCallback> {

    public @Override String print(PayPalCallback callback) {
        return null;
    }

}
