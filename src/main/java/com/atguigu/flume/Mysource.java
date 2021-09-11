package com.atguigu.flume;

import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.source.AbstractSource;

/**
 * @ClassName: Mysource
 * @Author: fw
 * @Date: 2021/7/3 14:13
 * @Description: TODO
 */
public class Mysource extends AbstractSource implements Configurable, PollableSource {

    @Override
    public Status process() throws EventDeliveryException {

        return null;
    }

    @Override
    public long getBackOffSleepIncrement() {
        return 1000;
    }

    @Override
    public long getMaxBackOffSleepInterval() {
        return 10000;
    }

    @Override
    public void configure(Context context) {

    }
}
