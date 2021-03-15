package com.example.vertx_4_0_3_jaeger;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.spi.VertxTracerFactory;
import io.vertx.core.tracing.TracingOptions;

class Application {
    public static void main(String[] args) {
        System.out.print("Creating Vertx with VertxTracerFactory.NOOP... ");
        createVertxWithNoOpTracerFactory();
        System.out.println("Success!");

        System.out.print("Creating Vertx with default options... ");
        try {
            createVertxWithDefaultOptions();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Creating Vertx with null TracingOptions()... ");
        try {
            createVertxWithNullTracingOptions();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createVertxWithNoOpTracerFactory() {
        var tracingOptions = new TracingOptions();
        tracingOptions.setFactory(VertxTracerFactory.NOOP);
        var vertxOptions = new VertxOptions();
        vertxOptions.setTracingOptions(tracingOptions);
        Vertx.vertx(vertxOptions);
    }

    private static void createVertxWithDefaultOptions() {
        Vertx.vertx();
    }

    private static void createVertxWithNullTracingOptions() {
        var vertxOptions = new VertxOptions();
        vertxOptions.setTracingOptions(null);
        Vertx.vertx(vertxOptions);
    }
}
