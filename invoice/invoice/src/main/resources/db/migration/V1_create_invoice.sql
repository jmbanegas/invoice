CREATE TABLE IF NOT EXISTS user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(50) DEFAULT 'Agent',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS status (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT
    );

CREATE TABLE IF NOT EXISTS lead (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(50),
    status_id INT,
    created_at DATE DEFAULT CURRENT_DATE,
    updated_at DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (status_id) REFERENCES status(id)
    );

CREATE TABLE IF NOT EXISTS activity (
    id SERIAL PRIMARY KEY,
    description TEXT,
    scheduled_at DATE,
    created_at DATE DEFAULT CURRENT_DATE,
    updated_at DATE DEFAULT CURRENT_DATE,
    lead_id INT NOT NULL,
    user_id INT,
    FOREIGN KEY (lead_id) REFERENCES lead(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(id)
    );
