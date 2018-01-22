package com.anythy.importer.service.thread;

import org.springframework.stereotype.Service;

/**
 * Created by Leach on 0017 2018/1/17.
 */
@Service("threadTest")
public class ThreadTest {
    public long print() {
        return System.currentTimeMillis();
    }
}
