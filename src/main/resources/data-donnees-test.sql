INSERT INTO utilisateur (id, pseudo, password, admin)
VALUES
   (1, 'kick', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 1),
   (2, 'rollon', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 0),
   (3, 'hugh', '$2a$10$tod199z/WlRRqwJ5NqWiNuMTMW3GgO.rDWQgRfmu9ZkzaAxzgmdtW' , 0);

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

INSERT INTO ticket (id, titre, description, resolu, categorie_id, priorite_id)
VALUES
    (1, 'CICD', 'Improve CICD Workflow', 0 ,  1, 1),
    (2, 'BUG', 'Fix Bug ultra galère', 0, 2, 2),
    (3, 'IMPROVEMENT', 'Improve Performance', 1, 3, 3);
