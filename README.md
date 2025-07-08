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
## 📸Screenshot from Running App 
![Screenshot 2025-07-09 022422](https://github.com/user-attachments/assets/45eb593c-b1cd-4c3b-8271-fdaa75f87946)

## 📊 UML Diagram

![Uml](https://github.com/user-attachments/assets/31d9ffcc-3ee2-46ed-b9dc-ac32b5f3f1e5)

---
##  📁 Project Structure 
```
src/
├── Interfaces/
│ ├── Expirable.java
│ └── Shippable.java
├── Products/
│ ├── Products.java
│ ├── ExpirableShippableProducts.java
│ ├── NonShippableProducts.java
│ └── ShippableNonExpirableProducts.java
├── Customer.java
├── ShoppingCart.java
├── CheckOut.java
└── ECommerceSystem.java <-- Contains the main method
```

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

## 🧩 Error Handling

The system includes structured error handling:

- **Empty Cart**: Prevents checkout
- **Out of Stock**: Throws clear error
- **Expired Products**: Validates expiration at checkout
- **Insufficient Balance**: Checks balance before processing
- **Non-Shippable Products**: Skips shipping with warning


---



