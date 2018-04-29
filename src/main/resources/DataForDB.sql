-- Peuplement de la base categorie
INSERT INTO category(id_category, category_name)
VALUES
(1, "Nature"),
(2, "Monument"),
(3, "Street Art"),
(4, "A voir le soir"),
(5, "Oeuvre d'art"),
(6, "Point de vue");

-- Peuplement de la base user
INSERT INTO user(id_user, biography, email, first_name, hash_password, last_name, path_to_profile_picture)
VALUES
(1, "Biography de Jean", "Jean@email.fr", "Jean", "Jeanpassword", "Val Jean", "pas d'image"),
(2, "Biography de Pierre", "Pierre@email.fr", "Jean", "Pierrepassword", "Papier Feuille", "pas d'image"),
(3, "Biography de Michel", "Michel@email.fr", "Michel", "Michelpassword", "Line", "pas d'image"),
(4, "Biography de Homer", "Homer@email.fr", "Homer", "Homerpassword", "Simpson", "pas d'image");

-- Peuplement de la base point d'intêret
INSERT INTO point_of_interest(id_point, create_date, description, latitude, longitude, picture, status, title, owner_id_user)
VALUES
(1, "2017-12-04", "Description 1", 45.755378, 4.847856, null, 2, "Titre poi 1", 1),
(2, "2017-05-13", "Description 2", 45.755335, 4.847865, null, 2, "Titre poi 2", 2),
(3, "2017-11-24", "Description 3", 45.755355, 4.847875, null, 2, "Titre poi 3", 4),
(4, "2018-04-28", "Description 4", 45.755355, 4.847875, null, 2, "Titre poi 4", 4);