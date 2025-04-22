# Java Logging Framework - Class, Interface, and Enumeration Overview

This document summarises all Classes, Interfaces, Enumerations, and associations used in the Java coffee vendor application.

## Requirements
1. The logging framework should support different log levels, such as DEBUG, INFO, WARNING, ERROR, and FATAL.
2. It should allow logging messages with a timestamp, log level, and message content.
3. The framework should support multiple output destinations, such as console, file, and database.
4. It should provide a configuration mechanism to set the output destination.
5. The logging framework should be thread-safe to handle concurrent logging from multiple threads.
6. It should be extensible to accommodate new log levels and output destinations in the future.


## 🧱 Classes

| Class Name       | Package                          | Description |
|------------------|----------------------------------|-------------|
| **`LogMessage`** | `loggingFramework`               | Represents a single log entry with `LogLevel`, message, and timestamp. |
| **`Logger`**     | `loggingFramework`               | Singleton class providing logging methods like `info()`, `debug()`, etc. It uses `LogConfig` and delegates to the configured `LogAppender`. |
| **`LogConfig`**  | `loggingFramework`               | Holds the configuration for logging, specifically the `LogAppender`. |
| **`LoggerDemo`** | `loggingFramework`               | A demo class to showcase how the logger works. It changes configurations and logs messages. |
| **`ConsoleAppender`** | `loggingFramework.LogAppender` | Implementation of `LogAppender` that prints messages to the console. |
| **`FileAppender`**    | `loggingFramework.LogAppender` | Implementation of `LogAppender` that writes messages to a file. |

---

## 📦 Interfaces

| Interface Name | Package                        | Description |
|----------------|--------------------------------|-------------|
| **`LogAppender`** | `loggingFramework.LogAppender` | Defines the contract for appending a `LogMessage`. Implemented by `ConsoleAppender` and `FileAppender`. |

---

## 🧩 Enumerations

| Enum Name     | Package            | Description |
|---------------|--------------------|-------------|
| **`LogLevel`** | `loggingFramework` | Enum for various log levels: `DEBUG`, `INFO`, `WARNING`, `ERROR`, `FATAL`. |

---

## 🔗 Associations & Relationships Summary

```text
LoggerDemo
└── uses ──▶ Logger (singleton)
    ├── has ──▶ LogConfig (composition)
    │   └── has ──▶ LogAppender (interface)
    │       ├── implemented by ──▶ ConsoleAppender
    │       └── implemented by ──▶ FileAppender
    └── creates ──▶ LogMessage
        └── uses ──▶ LogLevel (enum)

Logger        → logs        → LogMessage(s)
              → delegates   → LogConfig → LogAppender → Console/File output

LogMessage    → encapsulates → LogLevel, timestamp, message

LogConfig     → manages     → LogAppender (output strategy)

ConsoleAppender → outputs → console

FileAppender    → writes  → file

LogLevel        → defines → DEBUG | INFO | WARNING | ERROR | FATAL
