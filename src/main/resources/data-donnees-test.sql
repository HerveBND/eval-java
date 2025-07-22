INSERT INTO utilisateur (id, pseudo, password, admin)
VALUES
   (1, 'kick', '$2a$10$6462JZYGvmmPczZRv3Y1b.FdGs.U5XC1fJiIbbdEMMZQNT588iqyu' , 1),
   (2, 'rollon', '$2a$10$6462JZYGvmmPczZRv3Y1b.FdGs.U5XC1fJiIbbdEMMZQNT588iqyu' , 0),
   (3, 'hugh', '$2a$10$6462JZYGvmmPczZRv3Y1b.FdGs.U5XC1fJiIbbdEMMZQNT588iqyu' , 0);

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

INSERT INTO ticket (id, titre, description, resolu, priorite_id, resolveur_id, soumissionneur_id)
VALUES
    (1, 'CICD', 'Improve CICD Workflow', 0 , 1, NULL, 1),
    (2, 'BUG', 'Fix Bug ultra galère', 0,2, 2, 2),
    (3, 'IMPROVEMENT', 'Improve Performance', 1, 3, NULL, NULL);

INSERT INTO ticket_categories (ticket_id, categorie_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);

