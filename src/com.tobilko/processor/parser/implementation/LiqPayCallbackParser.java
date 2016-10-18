package com.tobilko.processor.parser.implementation;

import com.tobilko.callback.implementation.LiqPayCallback;
import com.tobilko.processor.parser.PaymentSystemCallbackParser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import static java.lang.Double.NaN;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.*;
import static java.nio.charset.StandardCharsets.*;
import static java.util.stream.Collectors.toMap;

/**
 *
 * Created by Andrew Tobilko on 10/17/2016.
 *
 */
public final class LiqPayCallbackParser implements PaymentSystemCallbackParser<LiqPayCallback> {

    public @Override LiqPayCallback parse(String response) {
        return fillOutFromMap(collectIntoMap(validateBeforeProcessing(response)));
    }

    private String[] validateBeforeProcessing(String response) {
        if (response == null || response.isEmpty()) {
            throw new IllegalArgumentException("the response is empty");
        }
        String[] pairs = response.split("&");
        if (pairs.length == 0) {
            throw new IllegalArgumentException("the response came up with an illegal format");
        }
        return pairs;
    }

    private Map<String, String> collectIntoMap(String[] pairs) {
        return Arrays.stream(pairs)
                .map(pair -> pair.split("="))
                .filter(values -> values.length == 2)
                .collect(toMap(values -> decode(values[0]), values -> decode(values[1])));
    }

    private String decode(String value) {
        try {
            return URLDecoder.decode(value, UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("the needed charset isn't supported");
        }
    }

    private LiqPayCallback fillOutFromMap(Map<String, String> map) {
        LiqPayCallback data = new LiqPayCallback();

        // filling an instance out according to the https://www.liqpay.com/en/doc/pay naming convention
        data.setErrorCode(map.get("err_code"));
        data.setErrorDescription(map.get("err_description"));

        data.setVersion(map.containsKey("version") ? parseInt(map.get("version")) : MIN_VALUE);
        data.setStatus(map.get("status"));
        data.setToken(map.get("token"));
        data.setDescription(map.get("description"));

        data.setCustomer(map.get("customer"));
        data.setAmount(map.containsKey("amount") ? parseDouble(map.get("amount")) : NaN);
        data.setCurrency(map.get("currency"));

        return data;
    }

}
