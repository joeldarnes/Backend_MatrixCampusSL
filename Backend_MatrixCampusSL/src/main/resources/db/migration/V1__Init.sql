CREATE TABLE prices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    brand_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    priority INT,
    currency VARCHAR(3) NOT NULL,
    price_list INT
);

INSERT INTO prices (product_id, brand_id, start_date, end_date, price, priority, currency, price_list) VALUES
(1, 1, '2024-05-01 00:00:00', '2024-05-31 23:59:59', 100.00, 10, 'EUR', 1);