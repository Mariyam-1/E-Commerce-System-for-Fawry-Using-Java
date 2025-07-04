# 🛒 E-commerce System – Fawry Internship Challenge

This is a simple Java-based object-oriented **E-commerce System** designed as part of the **Fawry Full Stack Development Internship** challenge. It demonstrates OOP principles like **inheritance**, **polymorphism**, **encapsulation**, and **interface segregation** while modeling real-world shopping and shipping behavior.

---

## 📦 Features

- ✅ Add products to cart
- ✅ Handle product expiration
- ✅ Support for shippable and non-shippable products
- ✅ Calculate subtotal and shipping fees
- ✅ Prevent checkout of expired or out-of-stock products
- ✅ Handle insufficient balance gracefully
- ✅ Generate detailed checkout receipts

---

## 🧱 Class Structure


### Product Types
- `Products`: Abstract base class with shared attributes like name, price, quantity
- `ExpirableShippableProducts`: Products that can expire and require shipping (e.g., Cheese)
- `NonShippableProducts`: Non-expirable and not shippable (e.g., Mobile Scratch Cards)
- `ShippableNonExpirableProducts`: Durable goods requiring shipping (e.g., TV)

### Interfaces
- `Shippable`: Requires `getWeight()` method
- `Expirable`: Requires `isExpired()` method

### System Classes
- `Customer`: Holds name and balance
- `ShoppingCart`: Manages products and quantities
- `CheckOut`: Processes the order, handles logic for expiration, stock, shipping, and billing

---

## 📂 Project Structure

