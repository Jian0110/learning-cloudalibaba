package com.cloud.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelAnnotationDemo {

    public static void main(String[] args) {
        SentinelAnnotationDemo demo = new SentinelAnnotationDemo();
        demo.hello(10000L);
    }

    // 原函数
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public String hello(long s) {
        return String.format("Hello at %d", s);
    }

    /**
     * 用于在抛出异常的时候提供 fallback 处理逻辑
     *  返回值类型必须与原函数返回值类型一致；
     *  方法参数列表需要和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常。
     *  fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，
     *  则可以指定 fallbackClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
     * @param s
     * @return
     */
    public String helloFallback(long s) {
        return "fallback at "+s;
    }

    /**
     * blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配；
     * 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。
     * blockHandler 函数默认需要和原方法在同一个类中。
     * 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
     * @param s
     * @param ex
     * @return
     */
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "handler blockException at " + s;
    }
}
