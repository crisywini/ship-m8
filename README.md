[![Java CI with Maven](https://github.com/crisywini/ship-m8/actions/workflows/maven.yml/badge.svg?branch=develop&event=push)](https://github.com/crisywini/ship-m8/actions/workflows/maven.yml)

# Ship-M8 🚚

This order processing microservice will handle all aspects of order management. When a user places
an order, it will process the order, handle payment processing (you can use a simulated payment
system), and manage the order status. This microservice can include features like:

- Order creation and submission
- Order status tracking
- Payment processing (simulated for demonstration purposes)
- Order history for each user

## Usage

Installed Maven and Java 17 and Kafka.

## Api Documentation

Can be found at:

    http://localhost:8082/swagger-ui/index.html

## Event Driven Communication

### Use case 

_**When**_ a Shopper creates an Order 

_**Then**_ the message Order Processed will be created

_**And**_ the message Order Processed will be sent to Productopolis

**_And_** Ship-M8 will listen to the message Order Failed in
case of the order was not successfully created (i.e, the product did not have a correct id or its
amount to buy was less than 0 or it was higher than the stock)