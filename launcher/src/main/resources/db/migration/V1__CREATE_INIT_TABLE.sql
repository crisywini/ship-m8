-- Create tables

-- Shopper Table
CREATE TABLE IF NOT EXISTS shopper (
    shopper_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phone_number VARCHAR(20),
    date_of_birth DATE,
    gender VARCHAR(10),
    registration_date DATE,
    last_login_date DATE,
    role VARCHAR(255),
    active_status BOOLEAN,
    profile_picture VARCHAR(255)
);

-- Address Table
CREATE TABLE IF NOT EXISTS address (
    address_id BIGSERIAL PRIMARY KEY,
    shopper_id BIGINT,
    recipient_name VARCHAR(255),
    street_address VARCHAR(255),
    city VARCHAR(255),
    state_province_region VARCHAR(255),
    postal_code VARCHAR(255),
    country VARCHAR(255),
    phone_number VARCHAR(255),
    type VARCHAR(255),
    primary_address BOOLEAN,
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
    );

-- Discount Table
CREATE TABLE IF NOT EXISTS discount (
    discount_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    value DOUBLE PRECISION,
    type VARCHAR(255),
    start_date DATE,
    end_date DATE,
    applicability VARCHAR(255),
    minimum_order_amount INTEGER
);

-- Order Table
CREATE TABLE IF NOT EXISTS "order" (
    order_id BIGSERIAL PRIMARY KEY,
    order_date DATE,
    status VARCHAR(255),
    total_price DOUBLE PRECISION,
    shipping_address_id BIGINT,
    billing_address_id BIGINT,
    payment_method VARCHAR(255),
    payment_status VARCHAR(255),
    shipping_method VARCHAR(255),
    order_notes TEXT,
    cancellation_reason TEXT,
    order_completion_date DATE,
    shopper_id BIGINT,
    FOREIGN KEY (shipping_address_id) REFERENCES address(address_id),
    FOREIGN KEY (billing_address_id) REFERENCES address(address_id),
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
);

-- Product Table
CREATE TABLE IF NOT EXISTS product (
    product_id BIGSERIAL PRIMARY KEY,
    og_product_id BIGINT,
    quantity INTEGER,
    price_per_unit DOUBLE PRECISION,
    total_price DOUBLE PRECISION,
    tax DOUBLE PRECISION,
    order_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES "order"(order_id)
);

-- Create M2M relationship tables

-- Address-Order M2M Table
CREATE TABLE IF NOT EXISTS address_order (
    address_id BIGINT,
    order_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (order_id) REFERENCES "order"(order_id)
    );

-- Product-Discount M2M Table
CREATE TABLE IF NOT EXISTS product_discount (
    product_id BIGINT,
    discount_id BIGINT,
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (discount_id) REFERENCES discount(discount_id)
    );

-- Shopper-Order M2M Table
CREATE TABLE IF NOT EXISTS shopper_order (
    shopper_id BIGINT,
    order_id BIGINT,
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id),
    FOREIGN KEY (order_id) REFERENCES "order"(order_id)
);

-- Add unique constraints to M2M tables

ALTER TABLE address_order ADD CONSTRAINT uk_address_order UNIQUE (address_id, order_id);
ALTER TABLE product_discount ADD CONSTRAINT uk_product_discount UNIQUE (product_id, discount_id);
ALTER TABLE shopper_order ADD CONSTRAINT uk_shopper_order UNIQUE (shopper_id, order_id);
