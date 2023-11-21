-- Insertion des équipes
INSERT INTO equipe (nomEquipe, abreviation) VALUES
    ('Los Angeles Lakers', 'LAL'),
    ('Golden State Warriors', 'GSW'),
    ('Houston Rockets', 'HOU');

-- Insertion des joueurs
INSERT INTO joueur (nomJoueur, idEquipeActuelle) VALUES
    ('LeBron James', 1),
    ('Stephen Curry', 2),
    ('James Harden', 3),
    ('Anthony Davis', 1),
    ('Klay Thompson', 2),
    ('Chris Paul', 3);

-- Insertion des contrats joueur_equipe
INSERT INTO joueur_equipe (idEquipe, idJoueur, dateContrat) VALUES
    (1, 1, '2022-01-01'),
    (2, 2, '2022-01-01'),
    (3, 3, '2022-01-01'),
    (1, 4, '2022-01-01'),
    (2, 5, '2022-01-01'),
    (3, 6, '2022-01-01');

-- Insertion des matchs
INSERT INTO match (lieu, dateDebut, heureDebut, equipe1, equipe2) VALUES
    ('Staples Center', '2023-01-15', '20:00', 1, 2),
    ('Chase Center', '2023-02-01', '19:30', 3, 1),
    ('Toyota Center', '2023-02-15', '18:30', 2, 3);

-- Insertion des effectifs de match
INSERT INTO matchEffectif (idMatch, idJoueur) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 5),
    (2, 6),
    (3, 1),
    (3, 3);

