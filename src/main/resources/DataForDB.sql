INSERT INTO category(id_category, category_name)
VALUES
(1, "Nature"),
(2, "Monument"),
(3, "Street Art"),
(4, "A voir le soir"),
(5, "Oeuvre d'art"),
(6, "Point de vue");


--INSERT INTO user(id_user, biography, email, first_name, hash_password, last_name, profile_picture)
--VALUES
--(1, "Biography de Jean", "Jean@email.fr", "Jean", "Jeanpassword", "Val Jean", "pas d'image"),
--(2, "Biography de Pierre", "Pierre@email.fr", "Jean", "Pierrepassword", "Papier Feuille", "pas d'image"),
--(3, "Biography de Michel", "Michel@email.fr", "Michel", "Michelpassword", "Line", "pas d'image"),
--(4, "Biography de Homer", "Homer@email.fr", "Homer", "Homerpassword", "Simpson", "pas d'image");


INSERT INTO point_of_interest(id_point, create_date, description, latitude, longitude, picture, status, title, owner_id_user)
VALUES
(1, "2017-12-04", "Description 1", 45.755378, 4.847856, null, 1, "Titre poi 1", 1),
(2, "2017-05-13", "Description 2", 45.755335, 4.847865, null, 1, "Titre poi 2", 2),
(3, "2017-11-24", "Description 3", 45.755355, 4.847875, null, 1, "Titre poi 3", 4),
(4, "2018-04-28", "Description 4", 45.755355, 4.847875, null, 1, "Titre poi 4", 4),
(5, "2018-04-28", "Description 5", 45.755355, 4.847875, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAOVBMVEXk5ueutLepsLPo6uursbXJzc/p6+yvtbji5OWorrK2u77Z3N24vcDO0dPg4uPAxcfMz9HDx8rU19hwHDZQAAAFQklEQVR4nO2d25qrIAyFhUA9oVbf/2G31rYzbe0egaQEm/9q5q7rCyQxwrIoBEEQBEEQBEEQBEEQBEEQBEEQBEEQBEEQBEEQBEE4IABQ9O3ULUzt5d8DMauZrFO61ubC/Idy41QdRSX050Yb9YLWje3zFwnQbcpbMbrpiqw1AljzVt5N5JixRrDvw/dLY52rRpjUDn1rHLsMJULh9D59F41Nn5tGmHbG767xnJdEGD0CuKJdVhIbzwheoqiq1D97N5W/vFVjm0kY+4AArug8JIYLzERiFSFwkZj69/9NjL5FIvd0A02kQqV4r1MYotbogmFdF2HyLvSvaMtYYoUgUKmab7YBhyFQqZJrEKFDCeG8Fdmu0+gsc4NpyYARTaHimU+rGk0gz9YGBjyBSjUMg9gjhpBlEDF34QLDnYgrUNV9akFPQIes0IzMgojwTPEMM4U9Ujvzg55Sa3oALPIinRlYBZFgkSpzSq3qAfRFyu0hyneGvwdjU6v6BYz4AnkV/VNJodAwUgioPekNzaitwa+GC4ZRRaRINLyGGZZCIKeaT5NKOSVTrCniM3ymihQ9Gy+FNOVwJrWwO1QKTWphd4BGoCj8IMdfpcfPNFTVgs8w6gsqfvzb+034dG3H77y/4OkJ973TXSGjJ+DjTzG+YBKF+v73BqNUSpRqOE2EkQ5DPcJrqk/yZobTIv2Ct2vHf0NKsEx5LdJZ4fnoJxXQT5twamhWsIs+q3K/gptrGJ76+oKTe6iPUBxDiDvLYLgLL6DtRHbH9q6gnd5jWAuvoDU2XAViVQyeaWYF5cYFpxHbKxj5lGUp/AGiZ1J8Xji9I1Igv477hZhrwNyGM29oY246T7w34Qq0wQk1D4FF+EKtc7irfiXENUJl5Bqx1MUA54/UP9oP7y6c9f3mTaBqfBx4yuwceIpLGPfGMb8ArgCMe5ywlB4ydcIqFrOo8U83MzPkuEB/gKJr6v840pU23/jdAOjtpu3eLG9s83cVvABQTWNTL8aQ68LUdV0O3QFME38Dp1PRTt3Z2nM3tRWcDqXuK4ANUv8mFOBqPXu2w+CaplxpGueG0c6rtZ9Xa7ZK59/eT9Y1SuvFenajEM4ZR5vSjV1b5bYr57C03VDW7wvhg9TFftfZbEx3L57Bjd7Vrj2gdQ4FBKC1TodPhecmYJj4NjmzvLH0j91rLF1XMRQJp3bY/bD0F6ZmZ6AMlVW4R4ZM7SY2exJgcvGL8xWtLIvVOj8elSS3gNWSeIbk88Udj7hxaJdUIxS7DLsjNTZtKoMM2GdIjqIxSRw9RmnxGt3nZznQkuWXbY3jZ2sHFP5T+0iM+uR7qROGTak32n2qz/FzzEfV+JkPDKD4zIZKHD4h0N8xHxGjqAsHVGHvPvHQtN9QgJhTCFgSKe9hQEdyC88TU9IJTLoFf0PU4QS8m6eC5jMR4NLvwTsUElkJpDh6A6mrxDPYEplFcAH3Yx9UpglRGMRzmhT3JzHAEzhxKPQboJ2XpvEMRMAgNXDxR7fJwHlgZJllbmCcCk/5wLsDjK3IOIIK4/oJlUESGtHrtGVaKH6IXKeM8+iNOGcC9O8BUBBlTQCs8+iVmO97cu1Hn4gIImQhMCKIWezChWBvvgwS6UpwOg2/ofVpAq/v0xh4kRDa2GSyC1Vwd0pjhkhDUOuW0SIN/Ngelf0xCaYLUMh2OrNJyMQml3K/EvBhoay2YZDfC5mDNQ0Bbq40pqt0+Btl5pVoQlIN7yHiK/41P69UqgJ8iWyts6L2Fbh924wz/goFQRAEQRAEQRAEQRCET/IP1+RU5rUCFhYAAAAASUVORK5CYII=", 0, "Titre poi 5", 4),
(6, "2018-04-28", "Description 6", 45.755355, 4.847875, null, 0, "Titre poi 6", 4);

INSERT INTO point_of_interest_categories(point_of_interest_id_point, categories_id_category)
VALUES
(1, 1),
(1, 2),
(2,3),
(2,4),
(4,6),
(5,3),
(6,3);