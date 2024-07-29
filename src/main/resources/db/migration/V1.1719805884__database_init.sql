-- Create table for users
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL,
                       enabled BOOLEAN DEFAULT true,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create table for products
CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          model VARCHAR(255) NOT NULL,
                          description TEXT,
                          price BIGINT NOT NULL,
                          price_opt BIGINT NOT NULL,
                          price_advance BIGINT NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create table for attachments
CREATE TABLE attachments (
                             id BIGSERIAL PRIMARY KEY,
                             product_id BIGINT NOT NULL REFERENCES products(id),
                             name VARCHAR(255) NOT NULL,
                             content_type VARCHAR(255) NOT NULL,
                             content BYTEA NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create table for orders
CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        surname VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        phone_number VARCHAR(20) NOT NULL,
                        address TEXT NOT NULL,
                        product_id BIGINT NOT NULL REFERENCES products(id),
                        is_confirmed BOOLEAN DEFAULT false,
                        confirmed_at TIMESTAMP,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
