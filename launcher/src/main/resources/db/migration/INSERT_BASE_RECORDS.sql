INSERT INTO address (shopper_id, recipient_name, street_address, city, state_province_region, postal_code, country, phone_number, type, primary_address)
VALUES (1, 'John Doe', '123 Main St', 'Cityville', 'StateA', '12345', 'CountryX', '9876543210', 'Home', TRUE);


INSERT INTO shopper (first_name, last_name, email, password, phone_number, date_of_birth, gender, registration_date, last_login_date, role, active_status, profile_picture)
VALUES ('John', 'Doe', 'john@example.com', 'password123', '1234567890', '1990-01-01', 'Male', '2023-01-01', '2023-08-30', 'USER', TRUE, 'profile.jpg');


INSERT INTO discount (name, value, type, start_date, end_date, applicability, minimum_order_amount)
VALUES ('Summer Sale', 10.0, 'Percentage', '2023-06-01', '2023-06-30', 'All Products', 50);

INSERT INTO "order" (order_date, status, total_price, shipping_address_id, billing_address_id, payment_method, payment_status, shipping_method, order_notes, cancellation_reason, order_completion_date, shopper_id)
VALUES ('2023-08-30', 'Pending', 100.0, 1, 1, 'Credit Card', 'Pending', 'Standard Shipping', 'Order notes', NULL, NULL, 1);

INSERT INTO product (og_product_id, quantity, price_per_unit, total_price, tax, order_id)
VALUES (123456, 2, 50.0, 100.0, 10.0, 1);
