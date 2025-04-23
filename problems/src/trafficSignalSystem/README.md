# Traffic Signal System - Class, Interface, and Enumeration Overview

This document summarises all Classes, Interfaces, Enumerations, and associations used in the Java Traffic Signal System application.

## Requirements
1. The traffic signal system should control the flow of traffic at an intersection with multiple roads.
2. The system should support different types of signals, such as red, yellow, and green.
3. The duration of each signal should be configurable and adjustable based on traffic conditions.
4. The system should handle the transition between signals smoothly, ensuring safe and efficient traffic flow.
5. The system should be scalable and extensible to support additional features and functionality.

## 🧱 Classes

| Class Name | Package | Description |
|------------|---------|-------------|
| **`TrafficSignal`** | `trafficSignalSystem` | Represents a traffic signal with configurable durations for each signal type and maintains the current signal state. |
| **`Road`** | `trafficSignalSystem` | Represents a road with a unique ID, name, and associated traffic signal. |
| **`Intersection`** | `trafficSignalSystem` | Represents a junction containing multiple roads, each with its own traffic signal. |
| **`TrafficController`** | `trafficSignalSystem` | Singleton class managing multiple intersections and orchestrating signal transitions. |
| **`TrafficControllerDemo`** | `trafficSignalSystem` | Demo class showcasing the setup and operation of the traffic signal system. |

---

## 🧩 Enumerations

| Enum Name | Package | Description |
|-----------|---------|-------------|
| **`SignalType`** | `trafficSignalSystem` | Enum for various signal types: `RED`, `YELLOW`, `GREEN`. |

---

## 🔗 Associations & Relationships Summary

```text
TrafficControllerDemo
└── uses ──▶ TrafficController (singleton)
    └── manages ──▶ Intersection(s)
        └── contains ──▶ Road(s)
            └── has ──▶ TrafficSignal
                └── uses ──▶ SignalType (enum)

TrafficController  → manages      → Intersection(s)
                   → controls     → signal transitions through threads

Intersection       → contains     → Road(s)
                   → reports      → status of all roads' signals

Road               → contains     → TrafficSignal (composition)

TrafficSignal      → encapsulates → SignalType, durations for each state

SignalType         → defines      → RED | YELLOW | GREEN
```

## Design Patterns

- **Singleton Pattern**: Implemented in `TrafficController` to ensure a single point of control for the entire traffic system.
- **Composition**: Hierarchical structure from `TrafficController` > `Intersection` > `Road` > `TrafficSignal`.

## Concurrency Management

- Synchronized methods in `TrafficSignal` and `Intersection` for thread-safe operations
- Dedicated lock object (`consoleLock`) for console output synchronization
- Independent threads for each intersection to manage signal transitions