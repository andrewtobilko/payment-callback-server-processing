package com.tobilko.formatter;

import com.tobilko.callback.PaymentSystemCallback;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public interface PaymentSystemCallbackFormatter<T extends PaymentSystemCallback>
        extends PaymentSystemCallbackParser<T>, PaymentSystemCallbackPrinter<T>  {}
