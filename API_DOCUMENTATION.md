# API Documentation

This project contains comprehensive API documentation for the Spring Boot application. The documentation is organized into multiple files for better readability.

## Table of Contents

- Authentication APIs
    - Staff Authentication
    - Customer Authentication
- Attribute APIs
- Card APIs
- Category APIs
- Country APIs
- Coupon APIs
- Customer APIs
- Gallery APIs
- Notification APIs
- Order APIs


- Order Item APIs
- Order Status APIs
- Product APIs
- Product Category APIs
- Product Attribute APIs
- Product Coupon APIs
- Product Shipping Info APIs
- Product Supplier APIs
- Product Tag APIs


- Role APIs
- Sells APIs
- Shipping Rate APIs
- Shipping Zone APIs
- SlideShow APIs
- Staff Account APIs
- Supplier APIs
- Tag APIs


- Variant Option APIs
- Variants APIs
- Variant Value APIs


- Card Item APIs
- Customer Address APIs
- Attribute Value APIs
- Product Attribute Value APIs

## Overview

This API documentation covers all RESTful endpoints provided by the application. Each endpoint is documented with:

- URL path
- HTTP method
- Request body format (if applicable)
- Response format
- Brief description of the endpoint's purpose

## Authentication

Most endpoints require authentication. Please refer to the Authentication APIs section for details on how to obtain and use authentication tokens.

## Data Formats

All APIs use JSON for request and response bodies. Dates are formatted as ISO 8601 strings (e.g., `2025-05-09T12:00:00Z`).

## Error Handling

The API uses standard HTTP status codes to indicate success or failure:
- 200 OK: The request was successful
- 201 Created: A new resource was successfully created
- 204 No Content: The request was successful but no content is returned
- 400 Bad Request: The request was malformed or invalid
- 401 Unauthorized: Authentication is required or failed
- 403 Forbidden: The authenticated user lacks permissions
- 404 Not Found: The requested resource was not found
- 500 Internal Server Error: An unexpected error occurred on the server

Error responses generally include a JSON body with details about the error.


## Authentication APIs

### 1. Login (Staff)
**Endpoint:** `/api/auth/login`  
**Method:** `POST`  
**Request Body:**
```json
{
  "email": "string",
  "password": "string"
}
```
**Response:**
```json
{
  "token": "string"
}
```
**Description:** This API allows staff to log in by providing their email and password. Upon successful authentication, a token is returned.

---

### 2. Get Current User (Staff)
**Endpoint:** `/api/auth/me`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "email": "string",
  "firstName": "string",
  "lastName": "string",
  "roles": ["string"]
}
```
**Description:** This API retrieves the information of the currently authenticated user.

---

## Staff Authentication APIs

### 1. Login (Customer)
**Endpoint:** `/api/auth/user/login`  
**Method:** `POST`  
**Request Body:**
```json
{
  "email": "string",
  "password": "string"
}
```
**Response:**
```json
{
  "token": "string"
}
```
**Description:** This API allows customers to log in by providing their email and password. Upon successful authentication, a token is returned.

---

### 2. Get Current User (Customer)
**Endpoint:** `/api/auth/user/me`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "email": "string",
  "firstName": "string",
  "lastName": "string",
  "roles": ["string"]
}
```
**Description:** This API retrieves the information of the currently authenticated customer.

---

## Attribute APIs

### 1. Get All Attributes
**Endpoint:** `/api/attributes`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "description": "string"
  }
]
```
**Description:** Retrieves a list of all attributes.

---

### 2. Get Attribute by ID
**Endpoint:** `/api/attributes/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Retrieves a specific attribute by its ID.

---

### 3. Add Attribute
**Endpoint:** `/api/attributes`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Adds a new attribute.

---

### 4. Update Attribute
**Endpoint:** `/api/attributes/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Updates an existing attribute by its ID.

---

### 5. Delete Attribute
**Endpoint:** `/api/attributes/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Attribute deleted successfully."
}
```
**Description:** Deletes an attribute by its ID.

---

## Card APIs

### 1. Get All Cards
**Endpoint:** `/api/cards`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "description": "string"
  }
]
```
**Description:** Retrieves a list of all cards.

---

### 2. Get Card by ID
**Endpoint:** `/api/cards/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Retrieves a specific card by its ID.

---

### 3. Add Card
**Endpoint:** `/api/cards`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Adds a new card.

---

### 4. Update Card
**Endpoint:** `/api/cards/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Updates an existing card by its ID.

---

### 5. Delete Card
**Endpoint:** `/api/cards/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Card deleted successfully."
}
```
**Description:** Deletes a card by its ID.

---

## Category APIs

### 1. Get All Categories
**Endpoint:** `/api/categories`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "description": "string"
  }
]
```
**Description:** Retrieves a list of all categories.

---

### 2. Get Category by ID
**Endpoint:** `/api/categories/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Retrieves a specific category by its ID.

---

### 3. Add Category
**Endpoint:** `/api/categories`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Adds a new category.

---

### 4. Update Category
**Endpoint:** `/api/categories/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Updates an existing category by its ID.

---

### 5. Delete Category
**Endpoint:** `/api/categories/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Category deleted successfully."
}
```
**Description:** Deletes a category by its ID.

---

## Country APIs

### 1. Get All Countries
**Endpoint:** `/api/countries`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "Long",
    "name": "string",
    "code": "string"
  }
]
```
**Description:** Retrieves a list of all countries.

---

### 2. Get Country by ID
**Endpoint:** `/api/countries/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "Long",
  "name": "string",
  "code": "string"
}
```
**Description:** Retrieves a specific country by its ID.

---

### 3. Add Country
**Endpoint:** `/api/countries`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "code": "string"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "string",
  "code": "string"
}
```
**Description:** Adds a new country.

---

### 4. Update Country
**Endpoint:** `/api/countries/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "code": "string"
}
```
**Response:**
```json
{
  "id": "Long",
  "name": "string",
  "code": "string"
}
```
**Description:** Updates an existing country by its ID.

---

### 5. Delete Country
**Endpoint:** `/api/countries/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Country deleted successfully."
}
```
**Description:** Deletes a country by its ID.

---

## Coupon APIs

### 1. Get All Coupons
**Endpoint:** `/api/coupons`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "code": "string",
    "discount": "number"
  }
]
```
**Description:** Retrieves a list of all coupons.

---

### 2. Get Coupon by ID
**Endpoint:** `/api/coupons/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "code": "string",
  "discount": "number"
}
```
**Description:** Retrieves a specific coupon by its ID.

---

### 3. Get Coupon by Code
**Endpoint:** `/api/coupons/code/{code}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "code": "string",
  "discount": "number"
}
```
**Description:** Retrieves a specific coupon by its code.

---

### 4. Add Coupon
**Endpoint:** `/api/coupons`  
**Method:** `POST`  
**Request Body:**
```json
{
  "code": "string",
  "discount": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "code": "string",
  "discount": "number"
}
```
**Description:** Adds a new coupon.

---

### 5. Update Coupon
**Endpoint:** `/api/coupons/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "code": "string",
  "discount": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "code": "string",
  "discount": "number"
}
```
**Description:** Updates an existing coupon by its ID.

---

### 6. Delete Coupon
**Endpoint:** `/api/coupons/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Coupon deleted successfully."
}
```

**Description:** Deletes a coupon by its ID.

---

## Customer APIs

### 1. Get All Customers
**Endpoint:** `/api/customers`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "email": "string"
  }
]
```
**Description:** Retrieves a list of all customers.

---

### 2. Get Customer by ID
**Endpoint:** `/api/customers/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string"
}
```
**Description:** Retrieves a specific customer by their ID.

---

### 3. Get Customer by Email
**Endpoint:** `/api/customers/email/{email}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string"
}
```
**Description:** Retrieves a specific customer by their email.

---

### 4. Add Customer
**Endpoint:** `/api/customers`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "email": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string"
}
```
**Description:** Adds a new customer.

---

### 5. Update Customer
**Endpoint:** `/api/customers/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "email": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string"
}
```
**Description:** Updates an existing customer by their ID.

---

## Gallery APIs

### 1. Get All Galleries
**Endpoint:** `/api/galleries`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "productId": "UUID"
  }
]
```
**Description:** Retrieves a list of all galleries.

---

### 2. Get Gallery by ID
**Endpoint:** `/api/galleries/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "productId": "UUID"
}
```
**Description:** Retrieves a specific gallery by its ID.

---

### 3. Get Galleries by Product ID
**Endpoint:** `/api/galleries/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "productId": "UUID"
  }
]
```
**Description:** Retrieves galleries associated with a specific product ID.

---

### 4. Add Gallery
**Endpoint:** `/api/galleries`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "productId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "productId": "UUID"
}
```
**Description:** Adds a new gallery.

---

### 5. Update Gallery
**Endpoint:** `/api/galleries/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "productId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "productId": "UUID"
}
```
**Description:** Updates an existing gallery by its ID.

---

## Notification APIs

### 1. Get All Notifications
**Endpoint:** `/api/notifications`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "message": "string",
    "accountId": "UUID"
  }
]
```
**Description:** Retrieves a list of all notifications.

---

### 2. Get Notification by ID
**Endpoint:** `/api/notifications/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "message": "string",
  "accountId": "UUID"
}
```
**Description:** Retrieves a specific notification by its ID.

---

### 3. Get Notifications by Account ID
**Endpoint:** `/api/notifications/account/{accountId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "message": "string",
    "accountId": "UUID"
  }
]
```
**Description:** Retrieves notifications associated with a specific account ID.

---

### 4. Add Notification
**Endpoint:** `/api/notifications`  
**Method:** `POST`  
**Request Body:**
```json
{
  "message": "string",
  "accountId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "message": "string",
  "accountId": "UUID"
}
```
**Description:** Adds a new notification.

---

### 5. Update Notification
**Endpoint:** `/api/notifications/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "message": "string",
  "accountId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "message": "string",
  "accountId": "UUID"
}
```
**Description:** Updates an existing notification by its ID.

---

## Order APIs

### 1. Get All Orders
**Endpoint:** `/api/orders`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "customerId": "UUID",
    "total": "number"
  }
]
```
**Description:** Retrieves a list of all orders.

---

### 2. Get Order by ID
**Endpoint:** `/api/orders/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "total": "number"
}
```
**Description:** Retrieves a specific order by its ID.

---

### 3. Add Order
**Endpoint:** `/api/orders`  
**Method:** `POST`  
**Request Body:**
```json
{
  "customerId": "UUID",
  "total": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "total": "number"
}
```
**Description:** Adds a new order.

---

### 4. Update Order
**Endpoint:** `/api/orders/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "customerId": "UUID",
  "total": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "total": "number"
}
```
**Description:** Updates an existing order by its ID.

---

### 5. Delete Order
**Endpoint:** `/api/orders/{id}`  
**Method:** `DELETE`  
**Response:**
```json
{
  "message": "Order deleted successfully."
}
```
**Description:** Deletes an order by its ID.

---
# API Documentation (Part 2)

## Order Item APIs

### 1. Get All Order Items
**Endpoint:** `/api/order-items`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "orderId": "UUID",
    "productId": "UUID",
    "quantity": "number"
  }
]
```
**Description:** Retrieves a list of all order items.

---

### 2. Get Order Item by ID
**Endpoint:** `/api/order-items/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "orderId": "UUID",
  "productId": "UUID",
  "quantity": "number"
}
```
**Description:** Retrieves a specific order item by its ID.

---

### 3. Get Order Items by Order ID
**Endpoint:** `/api/order-items/order/{orderId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "orderId": "UUID",
    "productId": "UUID",
    "quantity": "number"
  }
]
```
**Description:** Retrieves order items associated with a specific order ID.

---

### 4. Add Order Item
**Endpoint:** `/api/order-items`  
**Method:** `POST`  
**Request Body:**
```json
{
  "orderId": "UUID",
  "productId": "UUID",
  "quantity": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "orderId": "UUID",
  "productId": "UUID",
  "quantity": "number"
}
```
**Description:** Adds a new order item.

---

### 5. Update Order Item
**Endpoint:** `/api/order-items/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "orderId": "UUID",
  "productId": "UUID",
  "quantity": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "orderId": "UUID",
  "productId": "UUID",
  "quantity": "number"
}
```
**Description:** Updates an existing order item by its ID.

---

## Order Status APIs

### 1. Get All Order Statuses
**Endpoint:** `/api/order-statuses`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string"
  }
]
```
**Description:** Retrieves a list of all order statuses.

---

### 2. Get Order Status by ID
**Endpoint:** `/api/order-statuses/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string"
}
```
**Description:** Retrieves a specific order status by its ID.

---

### 3. Get Order Status by Name
**Endpoint:** `/api/order-statuses/name/{statusName}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string"
}
```
**Description:** Retrieves a specific order status by its name.

---

### 4. Add Order Status
**Endpoint:** `/api/order-statuses`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string"
}
```
**Description:** Adds a new order status.

---

### 5. Update Order Status
**Endpoint:** `/api/order-statuses/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string"
}
```
**Description:** Updates an existing order status by its ID.

---

## Product APIs

### 1. Get All Products
**Endpoint:** `/api/products`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "slug": "string"
  }
]
```
**Description:** Retrieves a list of all products.

---

### 2. Get Product by ID
**Endpoint:** `/api/products/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "slug": "string"
}
```
**Description:** Retrieves a specific product by its ID.

---

### 3. Get Product by Slug
**Endpoint:** `/api/products/slug/{slug}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "slug": "string"
}
```
**Description:** Retrieves a specific product by its slug.

---

### 4. Add Product
**Endpoint:** `/api/products`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "slug": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "slug": "string"
}
```
**Description:** Adds a new product.

---

### 5. Update Product
**Endpoint:** `/api/products/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "slug": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "slug": "string"
}
```
**Description:** Updates an existing product by its ID.

---

## Product Category APIs

### 1. Get All Product Categories
**Endpoint:** `/api/product-categories`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "categoryId": "UUID"
  }
]
```
**Description:** Retrieves a list of all product categories.

---

### 2. Get Product Category by ID
**Endpoint:** `/api/product-categories/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "categoryId": "UUID"
}
```
**Description:** Retrieves a specific product category by its ID.

---

### 3. Get Product Categories by Product ID
**Endpoint:** `/api/product-categories/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "categoryId": "UUID"
  }
]
```
**Description:** Retrieves product categories associated with a specific product ID.

---

### 4. Get Product Categories by Category ID
**Endpoint:** `/api/product-categories/category/{categoryId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "categoryId": "UUID"
  }
]
```
**Description:** Retrieves product categories associated with a specific category ID.

---

### 5. Add Product Category
**Endpoint:** `/api/product-categories`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "categoryId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "categoryId": "UUID"
}
```
**Description:** Adds a new product category.

---

## Product Attribute APIs

### 1. Get All Product Attributes
**Endpoint:** `/api/product-attributes`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "attributeId": "UUID"
  }
]
```
**Description:** Retrieves a list of all product attributes.

---

### 2. Get Product Attribute by ID
**Endpoint:** `/api/product-attributes/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "attributeId": "UUID"
}
```
**Description:** Retrieves a specific product attribute by its ID.

---

### 3. Get Product Attributes by Product ID
**Endpoint:** `/api/product-attributes/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "attributeId": "UUID"
  }
]
```
**Description:** Retrieves product attributes associated with a specific product ID.

---

### 4. Get Product Attributes by Attribute ID
**Endpoint:** `/api/product-attributes/attribute/{attributeId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "attributeId": "UUID"
  }
]
```
**Description:** Retrieves product attributes associated with a specific attribute ID.

---

### 5. Add Product Attribute
**Endpoint:** `/api/product-attributes`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "attributeId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "attributeId": "UUID"
}
```
**Description:** Adds a new product attribute.

---

## Product Coupon APIs

### 1. Get All Product Coupons
**Endpoint:** `/api/product-coupons`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "couponId": "UUID"
  }
]
```
**Description:** Retrieves a list of all product coupons.

---

### 2. Get Product Coupon by ID
**Endpoint:** `/api/product-coupons/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "couponId": "UUID"
}
```
**Description:** Retrieves a specific product coupon by its ID.

---

### 3. Get Product Coupons by Product ID
**Endpoint:** `/api/product-coupons/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "couponId": "UUID"
  }
]
```
**Description:** Retrieves product coupons associated with a specific product ID.

---

### 4. Get Product Coupons by Coupon ID
**Endpoint:** `/api/product-coupons/coupon/{couponId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "couponId": "UUID"
  }
]
```
**Description:** Retrieves product coupons associated with a specific coupon ID.

---

### 5. Add Product Coupon
**Endpoint:** `/api/product-coupons`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "couponId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "couponId": "UUID"
}
```
**Description:** Adds a new product coupon.

---

## Product Shipping Info APIs

### 1. Get All Product Shipping Infos
**Endpoint:** `/api/product-shipping-infos`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "weight": "number",
    "dimensions": "string"
  }
]
```
**Description:** Retrieves a list of all product shipping information.

---

### 2. Get Product Shipping Info by ID
**Endpoint:** `/api/product-shipping-infos/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Description:** Retrieves specific product shipping information by its ID.

---

### 3. Get Product Shipping Info by Product ID
**Endpoint:** `/api/product-shipping-infos/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Description:** Retrieves shipping information for a specific product by product ID.

---

### 4. Add Product Shipping Info
**Endpoint:** `/api/product-shipping-infos`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Description:** Adds new shipping information for a product.

---

### 5. Update Product Shipping Info
**Endpoint:** `/api/product-shipping-infos/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "weight": "number",
  "dimensions": "string"
}
```
**Description:** Updates existing product shipping information by its ID.

---

## Product Supplier APIs

### 1. Get All Product Suppliers
**Endpoint:** `/api/product-suppliers`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "supplierId": "UUID",
    "isPrimary": "boolean"
  }
]
```
**Description:** Retrieves a list of all product suppliers.

---

### 2. Get Product Supplier by IDs
**Endpoint:** `/api/product-suppliers/{productId}/{supplierId}`  
**Method:** `GET`  
**Response:**
```json
{
  "productId": "UUID",
  "supplierId": "UUID",
  "isPrimary": "boolean"
}
```
**Description:** Retrieves a specific product supplier by product ID and supplier ID.

---

### 3. Get Product Suppliers by Product ID
**Endpoint:** `/api/product-suppliers/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "supplierId": "UUID",
    "isPrimary": "boolean"
  }
]
```
**Description:** Retrieves all suppliers for a specific product by product ID.

---

### 4. Get Product Suppliers by Supplier ID
**Endpoint:** `/api/product-suppliers/supplier/{supplierId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "supplierId": "UUID",
    "isPrimary": "boolean"
  }
]
```
**Description:** Retrieves all products associated with a specific supplier by supplier ID.

---

### 5. Get Primary Suppliers by Product ID
**Endpoint:** `/api/product-suppliers/product/{productId}/primary`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "supplierId": "UUID",
    "isPrimary": "boolean"
  }
]
```
**Description:** Retrieves all primary suppliers for a specific product by product ID.

---

## Product Tag APIs

### 1. Get All Product Tags
**Endpoint:** `/api/product-tags`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "tagId": "UUID"
  }
]
```
**Description:** Retrieves a list of all product tags.

---

### 2. Get Product Tag by IDs
**Endpoint:** `/api/product-tags/{productId}/{tagId}`  
**Method:** `GET`  
**Response:**
```json
{
  "productId": "UUID",
  "tagId": "UUID"
}
```
**Description:** Retrieves a specific product tag by product ID and tag ID.

---

### 3. Get Product Tags by Product ID
**Endpoint:** `/api/product-tags/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "tagId": "UUID"
  }
]
```
**Description:** Retrieves all tags associated with a specific product by product ID.

---

### 4. Get Product Tags by Tag ID
**Endpoint:** `/api/product-tags/tag/{tagId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "productId": "UUID",
    "tagId": "UUID"
  }
]
```
**Description:** Retrieves all products associated with a specific tag by tag ID.

---

### 5. Create Product Tag
**Endpoint:** `/api/product-tags`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "tagId": "UUID"
}
```
**Response:**
```json
{
  "productId": "UUID",
  "tagId": "UUID"
}
```
**Description:** Associates a tag with a product.

---
# API Documentation Part 3

This document contains API documentation for additional controllers in the Spring Boot application.

## Role APIs

### 1. Get All Roles
**Endpoint:** `/api/roles`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "description": "string"
  }
]
```
**Description:** Retrieves a list of all roles.

---

### 2. Get Role by ID
**Endpoint:** `/api/roles/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Retrieves a specific role by its ID.

---

### 3. Create Role
**Endpoint:** `/api/roles`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Creates a new role.

---

### 4. Update Role
**Endpoint:** `/api/roles/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Updates an existing role by its ID.

---

### 5. Delete Role
**Endpoint:** `/api/roles/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a role by its ID.

---

## Sells APIs

### 1. Get All Sells
**Endpoint:** `/api/sells`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "quantity": "integer",
    "date": "date-time",
    "amount": "number"
  }
]
```
**Description:** Retrieves a list of all sales records.

---

### 2. Get Sell by ID
**Endpoint:** `/api/sells/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "date": "date-time",
  "amount": "number"
}
```
**Description:** Retrieves a specific sale record by its ID.

---

### 3. Get Sells by Product ID
**Endpoint:** `/api/sells/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "quantity": "integer",
    "date": "date-time",
    "amount": "number"
  }
]
```
**Description:** Retrieves all sales records for a specific product by product ID.

---

### 4. Add Sell
**Endpoint:** `/api/sells`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "quantity": "integer",
  "date": "date-time",
  "amount": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "date": "date-time",
  "amount": "number"
}
```
**Description:** Records a new sale.

---

### 5. Update Sell
**Endpoint:** `/api/sells/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "productId": "UUID",
  "quantity": "integer",
  "date": "date-time",
  "amount": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "date": "date-time",
  "amount": "number"
}
```
**Description:** Updates an existing sale record by its ID.

---

### 6. Delete Sell
**Endpoint:** `/api/sells/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a sale record by its ID.

---

## Shipping Rate APIs

### 1. Get All Shipping Rates
**Endpoint:** `/api/shipping-rates`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "shippingZoneId": "UUID",
    "name": "string",
    "rate": "number",
    "deliveryTime": "string"
  }
]
```
**Description:** Retrieves a list of all shipping rates.

---

### 2. Get Shipping Rate by ID
**Endpoint:** `/api/shipping-rates/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "shippingZoneId": "UUID",
  "name": "string",
  "rate": "number",
  "deliveryTime": "string"
}
```
**Description:** Retrieves a specific shipping rate by its ID.

---

### 3. Get Shipping Rates by Shipping Zone ID
**Endpoint:** `/api/shipping-rates/shipping-zone/{shippingZoneId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "shippingZoneId": "UUID",
    "name": "string",
    "rate": "number",
    "deliveryTime": "string"
  }
]
```
**Description:** Retrieves all shipping rates for a specific shipping zone by zone ID.

---

### 4. Add Shipping Rate
**Endpoint:** `/api/shipping-rates`  
**Method:** `POST`  
**Request Body:**
```json
{
  "shippingZoneId": "UUID",
  "name": "string",
  "rate": "number",
  "deliveryTime": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "shippingZoneId": "UUID",
  "name": "string",
  "rate": "number",
  "deliveryTime": "string"
}
```
**Description:** Creates a new shipping rate.

---

### 5. Update Shipping Rate
**Endpoint:** `/api/shipping-rates/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "shippingZoneId": "UUID",
  "name": "string",
  "rate": "number",
  "deliveryTime": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "shippingZoneId": "UUID",
  "name": "string",
  "rate": "number",
  "deliveryTime": "string"
}
```
**Description:** Updates an existing shipping rate by its ID.

---

### 6. Delete Shipping Rate
**Endpoint:** `/api/shipping-rates/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a shipping rate by its ID.

---

## Shipping Zone APIs

### 1. Get All Shipping Zones
**Endpoint:** `/api/shipping-zones`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "regions": "string"
  }
]
```
**Description:** Retrieves a list of all shipping zones.

---

### 2. Get Shipping Zone by ID
**Endpoint:** `/api/shipping-zones/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "regions": "string"
}
```
**Description:** Retrieves a specific shipping zone by its ID.

---

### 3. Add Shipping Zone
**Endpoint:** `/api/shipping-zones`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "regions": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "regions": "string"
}
```
**Description:** Creates a new shipping zone.

---

### 4. Update Shipping Zone
**Endpoint:** `/api/shipping-zones/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "regions": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "regions": "string"
}
```
**Description:** Updates an existing shipping zone by its ID.

---

### 5. Delete Shipping Zone
**Endpoint:** `/api/shipping-zones/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a shipping zone by its ID.

---

## SlideShow APIs

### 1. Get All SlideShows
**Endpoint:** `/api/slideshows`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "title": "string",
    "imageUrl": "string",
    "link": "string",
    "order": "integer"
  }
]
```
**Description:** Retrieves a list of all slideshows.

---

### 2. Get SlideShow by ID
**Endpoint:** `/api/slideshows/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "title": "string",
  "imageUrl": "string",
  "link": "string",
  "order": "integer"
}
```
**Description:** Retrieves a specific slideshow by its ID.

---

### 3. Add SlideShow
**Endpoint:** `/api/slideshows`  
**Method:** `POST`  
**Request Body:**
```json
{
  "title": "string",
  "imageUrl": "string",
  "link": "string",
  "order": "integer"
}
```
**Response:**
```json
{
  "id": "UUID",
  "title": "string",
  "imageUrl": "string",
  "link": "string",
  "order": "integer"
}
```
**Description:** Creates a new slideshow.

---

### 4. Update SlideShow
**Endpoint:** `/api/slideshows/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "title": "string",
  "imageUrl": "string",
  "link": "string",
  "order": "integer"
}
```
**Response:**
```json
{
  "id": "UUID",
  "title": "string",
  "imageUrl": "string",
  "link": "string",
  "order": "integer"
}
```
**Description:** Updates an existing slideshow by its ID.

---

### 5. Delete SlideShow
**Endpoint:** `/api/slideshows/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a slideshow by its ID.

---

## Staff Account APIs

### 1. Get All Staff Accounts
**Endpoint:** `/api/staff-accounts`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "email": "string",
    "roleId": "UUID",
    "active": "boolean"
  }
]
```
**Description:** Retrieves a list of all staff accounts.

---

### 2. Get Staff Account by ID
**Endpoint:** `/api/staff-accounts/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string",
  "roleId": "UUID",
  "active": "boolean"
}
```
**Description:** Retrieves a specific staff account by its ID.

---

### 3. Get Staff Account by Email
**Endpoint:** `/api/staff-accounts/email/{email}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string",
  "roleId": "UUID",
  "active": "boolean"
}
```
**Description:** Retrieves a staff account by its email address.

---

### 4. Create Staff Account
**Endpoint:** `/api/staff-accounts`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "email": "string",
  "password": "string", 
  "roleId": "UUID",
  "active": "boolean"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string",
  "roleId": "UUID",
  "active": "boolean"
}
```
**Description:** Creates a new staff account.

---

### 5. Update Staff Account
**Endpoint:** `/api/staff-accounts/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "email": "string",
  "password": "string", 
  "roleId": "UUID",
  "active": "boolean"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string",
  "roleId": "UUID",
  "active": "boolean"
}
```
**Description:** Updates an existing staff account by its ID.

---

### 6. Delete Staff Account
**Endpoint:** `/api/staff-accounts/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a staff account by its ID.

---

## Supplier APIs

### 1. Get All Suppliers
**Endpoint:** `/api/suppliers`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "contactName": "string",
    "email": "string",
    "phone": "string",
    "address": "string"
  }
]
```
**Description:** Retrieves a list of all suppliers.

---

### 2. Get Supplier by ID
**Endpoint:** `/api/suppliers/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "contactName": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```
**Description:** Retrieves a specific supplier by its ID.

---

### 3. Add Supplier
**Endpoint:** `/api/suppliers`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "contactName": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "contactName": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```
**Description:** Creates a new supplier.

---

### 4. Update Supplier
**Endpoint:** `/api/suppliers/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "contactName": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "contactName": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```
**Description:** Updates an existing supplier by its ID.

---

### 5. Delete Supplier
**Endpoint:** `/api/suppliers/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a supplier by its ID.

---

## Tag APIs

### 1. Get All Tags
**Endpoint:** `/api/tags`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "name": "string",
    "description": "string"
  }
]
```
**Description:** Retrieves a list of all tags.

---

### 2. Get Tag by ID
**Endpoint:** `/api/tags/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Retrieves a specific tag by its ID.

---

### 3. Add Tag
**Endpoint:** `/api/tags`  
**Method:** `POST`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Creates a new tag.

---

### 4. Update Tag
**Endpoint:** `/api/tags/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "name": "string",
  "description": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string"
}
```
**Description:** Updates an existing tag by its ID.

---

### 5. Delete Tag
**Endpoint:** `/api/tags/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a tag by its ID.

---
# API Documentation Part 4

This document contains API documentation for the variant-related controllers in the Spring Boot application.

## Variant Option APIs

### 1. Get All Variant Options
**Endpoint:** `/api/variant-options`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "name": "string"
  }
]
```
**Description:** Retrieves a list of all variant options.

---

### 2. Get Variant Option by ID
**Endpoint:** `/api/variant-options/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "name": "string"
}
```
**Description:** Retrieves a specific variant option by its ID.

---

### 3. Get Variant Options by Product ID
**Endpoint:** `/api/variant-options/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "name": "string"
  }
]
```
**Description:** Retrieves all variant options for a specific product by product ID.

---

### 4. Add Variant Option
**Endpoint:** `/api/variant-options`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "name": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "name": "string"
}
```
**Description:** Creates a new variant option.

---

### 5. Update Variant Option
**Endpoint:** `/api/variant-options/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "productId": "UUID",
  "name": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "name": "string"
}
```
**Description:** Updates an existing variant option by its ID.

---

### 6. Delete Variant Option
**Endpoint:** `/api/variant-options/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a variant option by its ID.

---

## Variants APIs

### 1. Get All Variants
**Endpoint:** `/api/variants`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "price": "number",
    "quantity": "integer",
    "sku": "string",
    "imageUrl": "string"
  }
]
```
**Description:** Retrieves a list of all variants.

---

### 2. Get Variant by ID
**Endpoint:** `/api/variants/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "price": "number",
  "quantity": "integer",
  "sku": "string",
  "imageUrl": "string"
}
```
**Description:** Retrieves a specific variant by its ID.

---

### 3. Get Variants by Product ID
**Endpoint:** `/api/variants/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productId": "UUID",
    "price": "number",
    "quantity": "integer",
    "sku": "string",
    "imageUrl": "string"
  }
]
```
**Description:** Retrieves all variants for a specific product by product ID.

---

### 4. Add Variant
**Endpoint:** `/api/variants`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productId": "UUID",
  "price": "number",
  "quantity": "integer",
  "sku": "string",
  "imageUrl": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "price": "number",
  "quantity": "integer",
  "sku": "string",
  "imageUrl": "string"
}
```
**Description:** Creates a new variant.

---

### 5. Update Variant
**Endpoint:** `/api/variants/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "productId": "UUID",
  "price": "number",
  "quantity": "integer",
  "sku": "string",
  "imageUrl": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productId": "UUID",
  "price": "number",
  "quantity": "integer",
  "sku": "string",
  "imageUrl": "string"
}
```
**Description:** Updates an existing variant by its ID.

---

### 6. Delete Variant
**Endpoint:** `/api/variants/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a variant by its ID.

---

## Variant Value APIs

### 1. Get All Variant Values
**Endpoint:** `/api/variant-values`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves a list of all variant values.

---

### 2. Get Variant Value by ID
**Endpoint:** `/api/variant-values/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "variantId": "UUID",
  "productId": "UUID",
  "productAttributeValueId": "UUID",
  "attributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Retrieves a specific variant value by its ID.

---

### 3. Get Variant Values by Variant ID
**Endpoint:** `/api/variant-values/variant/{variantId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all variant values for a specific variant by variant ID.

---

### 4. Get Variant Values by Product ID
**Endpoint:** `/api/variant-values/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all variant values for a specific product by product ID.

---

### 5. Get Variant Values by Product Attribute Value ID
**Endpoint:** `/api/variant-values/product-attribute-value/{productAttributeValueId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all variant values for a specific product attribute value by its ID.

---

### 6. Get Variant Values by Attribute ID
**Endpoint:** `/api/variant-values/attribute/{attributeId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all variant values for a specific attribute by attribute ID.

---

### 7. Get Variant Values by Attribute Value ID
**Endpoint:** `/api/variant-values/attribute-value/{attributeValueId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "variantId": "UUID",
    "productId": "UUID",
    "productAttributeValueId": "UUID",
    "attributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all variant values for a specific attribute value by its ID.

---

### 8. Add Variant Value
**Endpoint:** `/api/variant-values`  
**Method:** `POST`  
**Request Body:**
```json
{
  "variantId": "UUID",
  "productId": "UUID",
  "productAttributeValueId": "UUID",
  "attributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "variantId": "UUID",
  "productId": "UUID",
  "productAttributeValueId": "UUID",
  "attributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Creates a new variant value.

---

### 9. Update Variant Value
**Endpoint:** `/api/variant-values/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "variantId": "UUID",
  "productId": "UUID",
  "productAttributeValueId": "UUID",
  "attributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "variantId": "UUID",
  "productId": "UUID",
  "productAttributeValueId": "UUID",
  "attributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Updates an existing variant value by its ID.

---
# API Documentation Part 5

This document contains API documentation for the remaining controllers in the Spring Boot application.

## Card Item APIs

### 1. Get All Card Items
**Endpoint:** `/api/card-items`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "cardId": "UUID",
    "productId": "UUID",
    "quantity": "integer",
    "price": "number"
  }
]
```
**Description:** Retrieves a list of all card items.

---

### 2. Get Card Item by ID
**Endpoint:** `/api/card-items/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "cardId": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "price": "number"
}
```
**Description:** Retrieves a specific card item by its ID.

---

### 3. Get Card Items by Card ID
**Endpoint:** `/api/card-items/card/{cardId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "cardId": "UUID",
    "productId": "UUID",
    "quantity": "integer",
    "price": "number"
  }
]
```
**Description:** Retrieves all card items for a specific card by card ID.

---

### 4. Add Card Item
**Endpoint:** `/api/card-items`  
**Method:** `POST`  
**Request Body:**
```json
{
  "cardId": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "price": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "cardId": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "price": "number"
}
```
**Description:** Adds a new card item.

---

### 5. Update Card Item
**Endpoint:** `/api/card-items/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "cardId": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "price": "number"
}
```
**Response:**
```json
{
  "id": "UUID",
  "cardId": "UUID",
  "productId": "UUID",
  "quantity": "integer",
  "price": "number"
}
```
**Description:** Updates an existing card item by its ID.

---

### 6. Delete Card Item
**Endpoint:** `/api/card-items/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a card item by its ID.

---

## Customer Address APIs

### 1. Get All Customer Addresses
**Endpoint:** `/api/customer-addresses`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "customerId": "UUID",
    "addressLine1": "string",
    "addressLine2": "string",
    "city": "string",
    "state": "string",
    "postalCode": "string",
    "country": "string",
    "isDefault": "boolean"
  }
]
```
**Description:** Retrieves a list of all customer addresses.

---

### 2. Get Customer Address by ID
**Endpoint:** `/api/customer-addresses/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "state": "string",
  "postalCode": "string",
  "country": "string",
  "isDefault": "boolean"
}
```
**Description:** Retrieves a specific customer address by its ID.

---

### 3. Get Customer Addresses by Customer ID
**Endpoint:** `/api/customer-addresses/customer/{customerId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "customerId": "UUID",
    "addressLine1": "string",
    "addressLine2": "string",
    "city": "string",
    "state": "string",
    "postalCode": "string",
    "country": "string",
    "isDefault": "boolean"
  }
]
```
**Description:** Retrieves all addresses for a specific customer by customer ID.

---

### 4. Add Customer Address
**Endpoint:** `/api/customer-addresses`  
**Method:** `POST`  
**Request Body:**
```json
{
  "customerId": "UUID",
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "state": "string",
  "postalCode": "string",
  "country": "string",
  "isDefault": "boolean"
}
```
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "state": "string",
  "postalCode": "string",
  "country": "string",
  "isDefault": "boolean"
}
```
**Description:** Adds a new address for a customer.

---

### 5. Update Customer Address
**Endpoint:** `/api/customer-addresses/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "customerId": "UUID",
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "state": "string",
  "postalCode": "string",
  "country": "string",
  "isDefault": "boolean"
}
```
**Response:**
```json
{
  "id": "UUID",
  "customerId": "UUID",
  "addressLine1": "string",
  "addressLine2": "string",
  "city": "string",
  "state": "string",
  "postalCode": "string",
  "country": "string",
  "isDefault": "boolean"
}
```
**Description:** Updates an existing customer address by its ID.

---

### 6. Delete Customer Address
**Endpoint:** `/api/customer-addresses/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a customer address by its ID.

---

## Attribute Value APIs

### 1. Get All Attribute Values
**Endpoint:** `/api/attribute-values`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "attributeId": "UUID",
    "value": "string"
  }
]
```
**Description:** Retrieves a list of all attribute values.

---

### 2. Get Attribute Value by ID
**Endpoint:** `/api/attribute-values/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "attributeId": "UUID",
  "value": "string"
}
```
**Description:** Retrieves a specific attribute value by its ID.

---

### 3. Get Attribute Values by Attribute ID
**Endpoint:** `/api/attribute-values/attribute/{attributeId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "attributeId": "UUID",
    "value": "string"
  }
]
```
**Description:** Retrieves all values for a specific attribute by attribute ID.

---

### 4. Add Attribute Value
**Endpoint:** `/api/attribute-values`  
**Method:** `POST`  
**Request Body:**
```json
{
  "attributeId": "UUID",
  "value": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "attributeId": "UUID",
  "value": "string"
}
```
**Description:** Adds a new attribute value.

---

### 5. Update Attribute Value
**Endpoint:** `/api/attribute-values/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "attributeId": "UUID",
  "value": "string"
}
```
**Response:**
```json
{
  "id": "UUID",
  "attributeId": "UUID",
  "value": "string"
}
```
**Description:** Updates an existing attribute value by its ID.

---

### 6. Delete Attribute Value
**Endpoint:** `/api/attribute-values/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes an attribute value by its ID.

---

## Product Attribute Value APIs

### 1. Get All Product Attribute Values
**Endpoint:** `/api/product-attribute-values`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productAttributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves a list of all product attribute values.

---

### 2. Get Product Attribute Value by ID
**Endpoint:** `/api/product-attribute-values/{id}`  
**Method:** `GET`  
**Response:**
```json
{
  "id": "UUID",
  "productAttributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Retrieves a specific product attribute value by its ID.

---

### 3. Get Product Attribute Values by Product Attribute ID
**Endpoint:** `/api/product-attribute-values/product-attribute/{productAttributeId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productAttributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all attribute values for a specific product attribute by product attribute ID.

---

### 4. Get Product Attribute Values by Attribute Value ID
**Endpoint:** `/api/product-attribute-values/attribute-value/{attributeValueId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productAttributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all product attribute values for a specific attribute value by attribute value ID.

---

### 5. Get Product Attribute Values by Product ID
**Endpoint:** `/api/product-attribute-values/product/{productId}`  
**Method:** `GET`  
**Response:**
```json
[
  {
    "id": "UUID",
    "productAttributeId": "UUID",
    "attributeValueId": "UUID"
  }
]
```
**Description:** Retrieves all attribute values for a specific product by product ID.

---

### 6. Add Product Attribute Value
**Endpoint:** `/api/product-attribute-values`  
**Method:** `POST`  
**Request Body:**
```json
{
  "productAttributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productAttributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Associates an attribute value with a product attribute.

---

### 7. Update Product Attribute Value
**Endpoint:** `/api/product-attribute-values/{id}`  
**Method:** `PUT`  
**Request Body:**
```json
{
  "productAttributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Response:**
```json
{
  "id": "UUID",
  "productAttributeId": "UUID",
  "attributeValueId": "UUID"
}
```
**Description:** Updates an existing product attribute value by its ID.

---

### 8. Delete Product Attribute Value
**Endpoint:** `/api/product-attribute-values/{id}`  
**Method:** `DELETE`  
**Response:** No content (204)  
**Description:** Deletes a product attribute value by its ID.

---
