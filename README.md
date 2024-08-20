
# Dynamic Query with Pagination

## Overview

This project demonstrates the implementation of dynamic queries using `JpaSpecificationExecutor` in a Spring Boot application. The goal is to allow flexible search functionality by dynamically building queries based on user-provided parameters.

| Parameter   | Type     | Description               |
|:------------|:---------|:--------------------------|
| `firstName` | `string` | First Name of player      |
| `lastName`  | `string` | Last Name of player       |
| `position`  | `enum`   | Position of player        |
| `number`    | `int`    | Jersey number of player   |
| `page`      | `int`    | page number of pagination |
| `size`      | `int`    | page size per a page      |

**Query Parameters:**
- `firstName`: Filter by the player's first name (e.g., `?firstName=Harry`)
- `lastName`: Filter by the player's last name (e.g., `?lastName=Kane`)
- `position`: Filter by the player's position (e.g., `?position=ST`)
- `number`: Filter by the player's jersey number (e.g., `?number=10`)
- `page`: page number of pagination default value is `1`
- `size`: page size per a page default value `10`

**Example Request:**
```http
GET /api/players?page=1&size=15
```
```http
GET /api/players?firstName=Harry&position=ST
```
```http
GET /api/players?firstName=Harry&position=ST&number=10
```
**Sample Data**

You can insert SQL script below in H2 database for testing the endpoint:
```SQL
INSERT INTO players 
    (first_name, last_name, position, jersey_number)
VALUES 
('Harry', 'Kane', 'ST', 10),
('Kevin', 'De Bruyne', 'CAM', 17),
('Virgil', 'van Dijk', 'CB', 4),
('Mohamed', 'Salah', 'RW', 11),
('Bruno', 'Fernandes', 'CAM', 8),
('Raheem', 'Sterling', 'LW', 7),
('Alisson', 'Becker', 'GK', 1),
('Heung-min', 'Son', 'LW', 7),
('Trent', 'Alexander-Arnold', 'RB', 66),
('Jack', 'Grealish', 'LW', 10),
('Mason', 'Mount', 'CM', 19),
('Ruben', 'Dias', 'CB', 3),
('Phil', 'Foden', 'CAM', 47),
('Marcus', 'Rashford', 'LW', 10),
('Thiago', 'Alcantara', 'CM', 6),
('Kai', 'Havertz', 'SS', 29),
('Ederson', 'Moraes', 'GK', 31),
('Jamie', 'Vardy', 'ST', 9),
('Reece', 'James', 'RWB', 24),
('Bukayo', 'Saka', 'RW', 7);
```

