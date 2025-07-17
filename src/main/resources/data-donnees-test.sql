INSERT INTO utilisateur (id, pseudo, password, admin)
VALUES
   (1, 'a@a', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 1),
   (2, 'b@b', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 0),
   (3, 'c@c', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 0);

INSERT INTO priorite (id, nom)
VALUES
    (1, 'IMMEDIAT'),
    (2, 'URGENT'),
    (3, 'ROUTINE');

INSERT INTO categorie (id, nom)
VALUES
    (1, 'BUG'),
    (2, 'FEATURE'),
    (3, 'IMPROVEMENT');

INSERT INTO ticket (id, titre, description, resolu)
VALUES
    (1, 'CICD', 'Improve CICD Workflow', 0),
    (2, 'BUG', 'Fix Bug ultra galère', 0),
    (3, 'IMPROVEMENT', 'Improve Performance', 1);
