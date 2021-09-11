package com.atguigu.flume;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Myinterceptor
 * @Author: fw
 * @Date: 2021/7/3 08:51
 * @Description: TODO
 */
public class Myinterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        byte[] body = event.getBody();
        Map<String, String> headers = event.getHeaders();
        String line = new String(body, StandardCharsets.UTF_8);

        char c = line.charAt(0);
        if (c >= '0' && c <= '9') {
            headers.put("type", "number");
        } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            headers.put("type", "alphmater");
        } else {
            return null;
        }
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        Iterator<Event> events = list.iterator();
        while (events.hasNext()) {
            Event next = events.next();
            Event event = intercept(next);
            if (event == null) {
                events.remove();
            }
        }

        return list;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder {

        @Override
        public Interceptor build() {
            return new Myinterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }

}
