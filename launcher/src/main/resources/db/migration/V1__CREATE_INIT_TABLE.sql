create table address (primary_address boolean, id bigserial not null, shopper_id bigint,
 city varchar(255), country varchar(255), phone_number varchar(255), postal_code varchar(255),
 recipient_name varchar(255), state_province_region varchar(255), street_address varchar(255),
  type varchar(255) check (type in ('PRIMARY','SHIPPING','BILLING')), primary key (id));

create table discount (end_date date, minimum_order_amount integer, start_date date, value float(53),
id bigserial not null, product_id bigint,
applicability varchar(255) check (applicability in ('ORDERS','PRODUCTS','BOTH')),
 name varchar(255), type varchar(255) check (type in ('PERCENTAGE_OFF','FIXED_AMOUNT_OFF','BUY_ONE_GET_ONE_FREE')),
  primary key (id));


create table order_table (order_completion_date date, order_date date, total_price float(53),
billing_address_id bigint, id bigserial not null, shipping_address_id bigint,
 shopper_id bigint, cancellation_reason varchar(255), order_notes varchar(255),
 payment_method varchar(255) check (payment_method in ('CREDIT_CARD','PAY_PAL')),
  payment_status varchar(255) check (payment_status in ('PENDING','SUCCESSFUL','FAILED')),
  shipping_method varchar(255) check (shipping_method in ('STANDARD','EXPRESS')),
  status varchar(255) check (status in ('PENDING','PROCESSING','SHIPPING','DELIVERED','CANCELED')), primary key (id));

create table product (price_per_unit float(53), quantity integer, tax float(53), total_price float(53),
 id bigserial not null, og_product_id bigint, order_id bigint, primary key (id));

create table shopper (active_status boolean, date_of_birth date, last_login_date date,
 registration_date date, shopper_id bigserial not null, email varchar(255),
  first_name varchar(255), gender varchar(255), last_name varchar(255), password varchar(255),
  phone_number varchar(255), profile_picture varchar(255),
   role varchar(255) check (role in ('CUSTOMER','ADMIN','SELLER')), primary key (shopper_id));

alter table if exists address add constraint FK80g6mrohbud77c0u34uqe8kve foreign key (shopper_id) references shopper;
alter table if exists discount add constraint FK9qcsopl406ufumbitfi9u7jop foreign key (product_id) references product;
alter table if exists order_table add constraint FKnj3xwbi7c4g4h97qe4jutun3x foreign key (billing_address_id) references address;
alter table if exists order_table add constraint FKfksdrldj2xk6eqtmi8bx9j485 foreign key (shipping_address_id) references address;
alter table if exists order_table add constraint FKq923m2nw5nc2n92owjw6mek2v foreign key (shopper_id) references shopper;
alter table if exists product add constraint FKhe4w1npbt3uwe9levt6rbm32o foreign key (order_id) references order_table;