

CREATE TABLE employee (
    id UUID PRIMARY KEY NOT NULL,
    email_address VARCHAR(255) NOT NULL,
    password VARCHAR(500) NOT NULL,
    is_active BOOLEAN NOT NULL,
    authorities VARCHAR(255) NOT NULL
)