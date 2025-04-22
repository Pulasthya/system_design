# ☕ Coffee Vendor Java Application Overview

This document summarises all **Classes**, **Interfaces**, **Enumerations**, and **associations** used in the Java coffee vendor application.

---

## Requirements
1. The coffee vending machine should support different types of coffee, such as espresso, cappuccino, and latte.
2. Each type of coffee should have a specific price and recipe (ingredients and their quantities).
3. The machine should have a menu to display the available coffee options and their prices.
4. Users should be able to select a coffee type and make a payment.
5. The machine should dispense the selected coffee and provide change if necessary.
6. The machine should track the inventory of ingredients and notify when they are running low.
7. The machine should handle multiple user requests concurrently and ensure thread safety.

---

## ✅ Classes

### 1. `Main`
- **Purpose**: Entry point of the application.
- **Responsibilities**:
    - Initializes coffee types and inventory.
    - Takes user input for coffee selection and payment.
    - Triggers coffee making and payment.
- **Uses**:
    - `CoffeeVendor`

---

### 2. `CoffeeVendor`
- **Purpose**: Main interface for user operations.
- **Fields**:
    - `HashMap<String, Coffee> coffeeTypes`
    - `Payment payment` (Singleton)
    - `Inventory inventory`
- **Key Methods**:
    - `addCoffeeType(String, Integer, HashMap)`
    - `getCoffeeTypes()`
    - `updateInventory(String, Integer)`
    - `makeCoffeeAndPayment(String, Integer)`
    - `checkInventory()`
- **Associations**:
    - Has a **composition** relationship with `Coffee`
    - Has a **uses** relationship with `Payment` (Singleton)
    - Has a **composition** relationship with `Inventory`

---

### 3. `Inventory`
- **Purpose**: Manages ingredients stock.
- **Fields**:
    - `HashMap<String, Integer> currInventory`
    - `Integer threshold = 10`
- **Key Methods**:
    - `addIngredient(String, Integer)`
    - `useIngredient(String, Integer)`
    - `checkLowIngredients()`
- **Associations**:
    - Used by `CoffeeVendor` to manage ingredients

---

### 4. `Payment`
- **Purpose**: Handles transactions and change calculation.
- **Pattern**: Singleton
- **Fields**:
    - `static Payment instance`
    - `Integer amount`
    - `HashMap<LocalDateTime, HashMap<String, Integer>> transactions`
- **Key Methods**:
    - `getInstance()`
    - `getAmount()`
    - `depositAmount(Integer, Integer)`
    - `getTransactions()`
- **Associations**:
    - Used by `CoffeeVendor` for payment handling

---

### 5. `Coffee`
- **Purpose**: Represents a coffee item.
- **Fields**:
    - `String name`
    - `HashMap<String, Integer> ingredients`
    - `Integer price`
- **Key Methods**:
    - `getName()`
    - `getIngredients()`
    - `getPrice()`
- **Associations**:
    - Created and stored in `CoffeeVendor`

---

## ❌ Interfaces
- **None**

---

## ❌ Enumerations
- **None**

---

## 🔄 Class Associations Summary

```text
Main
 └── uses ──> CoffeeVendor
               ├── has ──> Coffee (composition)
               ├── has ──> Inventory (composition)
               └── uses ──> Payment (singleton)

CoffeeVendor → manages → Coffee(s)
             → manages → Inventory
             → handles → Payment

Coffee → defines → Ingredients, Price, Name
Inventory → maintains → Ingredients
Payment → logs → Transactions