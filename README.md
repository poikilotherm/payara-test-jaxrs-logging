#  Jakarta EE 8 - Expection Mapper Logging Stacktrace Reproducer

## What is it?

A little reproducer to check if stack traces for logged exceptions are also written to logs.

This is based on [Jakarta EE 8 starter](https://github.com/hantsy/jakartaee8-starter).

## Build

Make sure you have installed the latest JDK 11 and Apache Maven 3.6.

Execute the following command to build a clean package locally.

```bash
mvn clean package
```

More details of testing and further deployments on application severs, check the [docs](./docs/README.md).

To test with local Payara using Arquillian, use:

```bash
mvn -P arq-payara-managed clean verify
```

Watch out for the `should_fail` test return 200 (due to `ThrowableHandler` sending OK response).
Look in server.log at the location printed when Arquillian starts the server locally and look for stack traces
with "test1" and "test2". 