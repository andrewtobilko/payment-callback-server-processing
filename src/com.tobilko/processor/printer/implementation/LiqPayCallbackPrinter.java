package com.tobilko.processor.printer.implementation;

import com.tobilko.callback.implementation.LiqPayCallback;
import com.tobilko.processor.printer.PaymentSystemCallbackPrinter;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public final class LiqPayCallbackPrinter implements PaymentSystemCallbackPrinter<LiqPayCallback> {

    public @Override String print(LiqPayCallback callback) {
        return null;
    }

}
