CREATE TABLE clientes (
                          id SERIAL PRIMARY KEY,
                          cedula VARCHAR(255) NOT NULL UNIQUE,
                          email VARCHAR(255) NOT NULL
);

CREATE TABLE prestamos (
                           id SERIAL PRIMARY KEY,
                           monto_total NUMERIC NOT NULL,
                           tasa_interes NUMERIC NOT NULL,
                           cliente_id INT NOT NULL REFERENCES clientes(id)
);

CREATE TABLE pagos (
                       id SERIAL PRIMARY KEY,
                       fecha_pago DATE NOT NULL,
                       monto_pago NUMERIC NOT NULL,
                       prestamo_id INT NOT NULL REFERENCES prestamos(id)
);

-- Datos de prueba adaptados a los nuevos campos
INSERT INTO clientes (id, cedula, email) VALUES (1, '1111111111', 'juan@test.com');
INSERT INTO clientes (id, cedula, email) VALUES (2, '2222222222', 'maria@test.com');

INSERT INTO prestamos (cliente_id, monto_total, tasa_interes) VALUES (1, 1500.00, 10.5);
INSERT INTO prestamos (cliente_id, monto_total, tasa_interes) VALUES (1, 500.00, 5.0);
INSERT INTO prestamos (cliente_id, monto_total, tasa_interes) VALUES (2, 2000.00, 12.0);

INSERT INTO pagos (prestamo_id, fecha_pago, monto_pago) VALUES (1, '2025-06-01', 150.00);
