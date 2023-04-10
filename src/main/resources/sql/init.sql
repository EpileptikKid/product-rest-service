CREATE TABLE groups (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        group_description TEXT
);

CREATE TABLE subgroups (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           subgroup_description TEXT,
                           group_id INTEGER REFERENCES groups(id)
);

CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          price_per_kg NUMERIC(10, 2) NOT NULL,
                          subgroup_id INTEGER REFERENCES subgroups(id),
                          supplier_country VARCHAR(255) NOT NULL
);

INSERT INTO groups (name, group_description)
VALUES ('Vegetables', 'This group contains a variety of vegetables that are known for their ' ||
                      'taste and nutritional value. Vegetables are an important source of ' ||
                      'vitamins and minerals that help promote good health and well-being.'),
       ('Fruits', 'This group includes a diverse range of fruits that are not only delicious, ' ||
                  'but also packed with essential nutrients. Fruits can help support our immune ' ||
                  'system and keep us healthy all year round.'),
       ('Berries', 'This group contains a variety of berries that are considered to be nutritional ' ||
                   'powerhouses. Berries are rich in antioxidants and other nutrients that can ' ||
                   'help protect against disease and promote good health.'),
       ('Nuts', 'This group consists of various types of nuts, which are a great source of protein ' ||
                'and other essential nutrients. Nuts are also high in healthy fats that can help ' ||
                'promote good health and keep us energized.');

INSERT INTO subgroups (name, subgroup_description, group_id)
VALUES ('potatoes', 'This subgroup contains various types of potatoes that are widely consumed ' ||
                    'around the world. Potatoes are a good source of carbohydrates, fiber, and ' ||
                    'several essential vitamins and minerals, making them a healthy and ' ||
                    'nutritious choice.', 1),
       ('tomatoes', 'This subgroup includes a variety of tomatoes that are known for their bright ' ||
                    'color, juiciness, and versatility in the kitchen. Tomatoes are packed with ' ||
                    'vitamin C, antioxidants, and other nutrients that can help support good health.', 1),
       ('oranges', 'This subgroup consists of different types of oranges that are a popular source ' ||
                   'of vitamin C, folate, and other nutrients. Oranges are known for their tangy, ' ||
                   'sweet flavor and can be eaten as a snack or used in various recipes.', 2),
       ('bananas', 'This subgroup includes various types of bananas that are a rich source of potassium, ' ||
                   'dietary fiber, and other nutrients. Bananas are a popular and convenient fruit that ' ||
                   'can be eaten on their own or used in smoothies, desserts, and other dishes.', 2),
       ('currant', 'This subgroup contains different types of currants that are known for their tart, ' ||
                   'refreshing flavor and their high content of vitamin C, fiber, and other nutrients. ' ||
                   'Currants can be eaten fresh or used in jams, jellies, and other recipes.', 3),
       ('strawberry', 'This subgroup includes different varieties of strawberries that are known for ' ||
                      'their sweet, juicy flavor and their high content of vitamin C, antioxidants, ' ||
                      'and other nutrients. Strawberries are a popular fruit that can be enjoyed on their ' ||
                      'own or used in various dishes, such as salads, smoothies, and desserts.', 3),
       ('hazelnut', 'This subgroup consists of various types of hazelnuts that are known for their ' ||
                    'nutty flavor and their high content of healthy fats, fiber, and other nutrients. ' ||
                    'Hazelnuts can be eaten on their own or used in various recipes, such as desserts, ' ||
                    'baked goods, and spreads.', 4),
       ('walnut', 'This subgroup includes different types of walnuts that are known for their rich, ' ||
                  'buttery flavor and their high content of protein, healthy fats, and other nutrients. ' ||
                  'Walnuts can be eaten on their own or used in various dishes, such as salads, ' ||
                  'stir-fries, and baked goods.', 4);

INSERT INTO products (name, price_per_kg, subgroup_id, supplier_country)
VALUES
    ('Young potatoes', 1.50, 1, 'USA'),
    ('Pink tomatoes', 2.00, 2, 'Mexico'),
    ('Field tomatoes', 1.75, 2, 'USA'),
    ('Pitted oranges', 3.00, 3, 'Spain'),
    ('Green bananas', 1.25, 4, 'India'),
    ('Blackberry', 1.50, 5, 'USA'),
    ('Strawberry 1 variety', 2.00, 6, 'Brazil'),
    ('Peeled hazelnuts', 4.00, 7, 'USA'),
    ('Peeled walnuts', 5.50, 8, 'Mexico');