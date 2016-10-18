package com.tobilko.processor.printer.implementation;

import com.tobilko.callback.implementation.LiqPayCallback;
import com.tobilko.processor.printer.PaymentSystemCallbackPrinter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public final class LiqPayCallbackPrinter implements PaymentSystemCallbackPrinter<LiqPayCallback> {

    public @Override String print(LiqPayCallback callback) {
        return makeStringFromMap(turnIntoMap(callback));
    }

    private Map<String, String> turnIntoMap(LiqPayCallback callback) {
        Map<String, String> data = new HashMap<>();

        data.put("err_code", callback.getErrorCode());
        data.put("err_description", callback.getErrorDescription());

        data.put("version", callback.getVersion() == null ? null : callback.getVersion().toString());
        data.put("status", callback.getStatus());
        data.put("token", callback.getToken());
        data.put("description", callback.getDescription());

        data.put("consumer", callback.getCustomer());
        data.put("amount", callback.getAmount() == null ? null : callback.getAmount().toString());
        data.put("currency", callback.getCurrency());

        return data;
    }

    private String makeStringFromMap(Map<String, String> map) {
        return null;
    }

}
