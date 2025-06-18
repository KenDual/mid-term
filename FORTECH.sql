CREATE DATABASE fortech;
USE fortech;

CREATE TABLE Category (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    note VARCHAR(255)
);

CREATE TABLE Employee (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE,
    branch_id INT, -- sẽ thêm FK sau
    email VARCHAR(255),
    phone_number VARCHAR(20)
);

CREATE TABLE Branch (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(50),
    manager_id INT
);

ALTER TABLE Employee
ADD CONSTRAINT FK_Employee_Branch FOREIGN KEY (branch_id) REFERENCES Branch(id);

ALTER TABLE Branch
ADD CONSTRAINT FK_Branch_Manager FOREIGN KEY (manager_id) REFERENCES Employee(id);

-- Tiếp tục tạo bảng còn lại bình thường
CREATE TABLE Car (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255),
    year INT,
    category_id INT NOT NULL,
    branch_id INT NOT NULL
    FOREIGN KEY (category_id) REFERENCES Category(id),
    FOREIGN KEY (branch_id) REFERENCES Branch(id)
);

CREATE TABLE Customer (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE Orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_date DATE,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    employee_id INT NOT NULL,
    discount DECIMAL(5, 2),
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (car_id) REFERENCES Car(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

-- 1. Category
INSERT INTO Category (name, note) VALUES 
('Sedan', 'Xe nhỏ gọn'),
('SUV', 'Xe gầm cao'),
('Truck', 'Xe tải'),
('Coupe', 'Xe thể thao 2 cửa'),
('Convertible', 'Xe mui trần');

-- 2. Branch
INSERT INTO Branch (name, address, phone_number, manager_id) VALUES 
('Chi nhánh Hà Nội', 'Hà Nội', '123456789', NULL),
('Chi nhánh TP.HCM', 'TP.HCM', '234567891', NULL),
('Chi nhánh Đà Nẵng', 'Đà Nẵng', '345678912', NULL),
('Chi nhánh Cần Thơ', 'Cần Thơ', '456789123', NULL),
('Chi nhánh Hải Phòng', 'Hải Phòng', '567891234', NULL);

-- 3. Employee (sử dụng đúng branch_id từ trên)
INSERT INTO Employee (name, birth_date, branch_id, email, phone_number) VALUES 
('Nguyễn Văn A', '1990-01-01', 1, 'a@company.com', '0900000001'),
('Trần Thị B', '1992-02-02', 2, 'b@company.com', '0900000002'),
('Lê Văn C', '1993-03-03', 3, 'c@company.com', '0900000003'),
('Phạm Thị D', '1994-04-04', 4, 'd@company.com', '0900000004'),
('Hoàng Văn E', '1995-05-05', 5, 'e@company.com', '0900000005');

-- 4. Update manager_id sau khi có employee
UPDATE Branch SET manager_id = 1 WHERE id = 1;
UPDATE Branch SET manager_id = 2 WHERE id = 2;
UPDATE Branch SET manager_id = 3 WHERE id = 3;
UPDATE Branch SET manager_id = 4 WHERE id = 4;
UPDATE Branch SET manager_id = 5 WHERE id = 5;

-- 5. Car
INSERT INTO Car (category_id, branch_id, name, brand, year, price) VALUES 
(1, 1, 'Toyota Camry', 'Toyota', 2023, 1000000.00),
(2, 2, 'Ford Everest', 'Ford', 2022, 850000.00),
(3, 3, 'Isuzu D-Max', 'Isuzu', 2021, 780000.00),
(4, 4, 'Mazda MX-5', 'Mazda', 2023, 950000.00),
(5, 5, 'BMW Z4', 'BMW', 2024, 1200000.00);

-- 6. Customer
INSERT INTO Customer (name, phone_number, address, email) VALUES 
('Nguyễn Văn D', '0901234567', 'Hà Nội', 'vand@example.com'),
('Trần Thị E', '0912345678', 'TP.HCM', 'trane@example.com'),
('Lê Văn F', '0923456789', 'Đà Nẵng', 'lef@example.com'),
('Phạm Thị G', '0934567890', 'Cần Thơ', 'phamg@example.com'),
('Hoàng Văn H', '0945678901', 'Hải Phòng', 'hoangh@example.com');

-- 7. Orders
INSERT INTO Orders (order_date, customer_id, car_id, employee_id, discount) VALUES 
('2025-06-17', 1, 1, 1, 5.00),
('2025-06-18', 2, 2, 2, 10.00),
('2025-06-19', 3, 3, 3, 0.00),
('2025-06-20', 4, 4, 4, 15.00),
('2025-06-21', 5, 5, 5, 7.50);

-- Kiểm tra dữ liệu
SELECT * FROM Category;
SELECT * FROM Branch;
SELECT * FROM Employee;
SELECT * FROM Car;
SELECT * FROM Customer;
SELECT * FROM Orders;

-- XÓA DỮ LIỆU NẾU CÓ
DELETE FROM Orders;
DELETE FROM Car;
DELETE FROM Employee;
DELETE FROM Branch;
DELETE FROM Customer;
DELETE FROM Category;