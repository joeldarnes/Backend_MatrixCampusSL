
CREATE TABLE IF NOT EXISTS prices (
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

MERGE INTO prices (product_id, brand_id, start_date, end_date, price, priority, currency, price_list) KEY (product_id, brand_id, start_date, end_date)
    VALUES
    (35455, 1, '2020-06-14 00:00:00', '2020-06-14 14:59:59', 35.50, 0, 'EUR', 1),
    (35455, 1, '2020-06-14 10:00:00', '2020-06-14 15:59:59', 25.45, 1, 'EUR', 2),
    (35455, 1, '2020-06-14 16:00:00', '2020-06-14 18:30:00', 30.50, 2, 'EUR', 3),
    (35455, 1, '2020-06-14 19:00:00', '2020-12-31 23:59:59', 38.95, 1, 'EUR', 4),
    (35455, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 40.00, 2, 'EUR', 5),
    (35455, 1, '2020-06-15 10:00:00', '2020-06-15 12:00:00', 45.00, 3, 'EUR', 6),
    (35455, 1, '2020-06-16 00:00:00', '2020-12-31 23:59:59', 50.00, 0, 'EUR', 7);
