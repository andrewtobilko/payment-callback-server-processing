package com.tobilko.processor.printer.implementation;

import com.tobilko.callback.implementation.LiqPayCallback;
import com.tobilko.processor.printer.PaymentSystemCallbackPrinter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.*;
import static java.util.stream.Collectors.*;

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
        return map.entrySet()
                  .stream()
                  .map(e -> encode(e.getKey()) + "=" + encode(e.getValue()))
                  .collect(joining("&"));
    }

    private String encode(String value) {
        try {
            return URLEncoder.encode(value, UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("the needed charset isn't supported");
        }
    }

}
