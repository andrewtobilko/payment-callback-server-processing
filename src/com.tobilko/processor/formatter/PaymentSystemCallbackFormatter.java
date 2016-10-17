package com.tobilko.processor.formatter;

import com.tobilko.callback.PaymentSystemCallback;
import com.tobilko.callback.implementation.LiqPayCallback;
import com.tobilko.processor.formatter.implementation.LiqPayCallbackFormatter;
import com.tobilko.processor.parser.PaymentSystemCallbackParser;
import com.tobilko.processor.printer.PaymentSystemCallbackPrinter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
@Setter(onParam=  @__(@Autowired))
public abstract class PaymentSystemCallbackFormatter<T extends PaymentSystemCallback>
        implements PaymentSystemCallbackParser<T>, PaymentSystemCallbackPrinter<T> {


    private @Setter PaymentSystemCallbackParser<T> parser;
    private @Setter PaymentSystemCallbackPrinter<T> printer;

    public @Override T parse(String response) {
        return null;
    }

    public @Override String print(T callback) {
        return null;
    }

}
