CREATE TABLE IF NOT EXISTS discount (
    discount_id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255),
    type TEXT,
    value DECIMAL,
    start_date DATE,
    end_date DATE,
    applicability TEXT,
    minimum_order_amount INTEGER,
    PRIMARY KEY (discount_id)
);