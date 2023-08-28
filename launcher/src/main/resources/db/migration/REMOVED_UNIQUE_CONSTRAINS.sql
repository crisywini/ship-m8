-- Drop the unique constraints from the order_table
ALTER TABLE order_table
DROP CONSTRAINT IF EXISTS order_table_billing_address_id_key,
DROP CONSTRAINT IF EXISTS order_table_shipping_address_id_key;
