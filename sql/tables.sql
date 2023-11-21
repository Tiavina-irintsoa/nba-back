create table equipe(
    idEquipe serial primary key, 
    nomEquipe VARCHAR,
    abreviation VARCHAR
);

create table joueur (
    idJoueur serial primary key,
    nomJoueur VARCHAR,
    idEquipeActuelle integer not null references equipe(idEquipe)
); 


create table joueur_equipe(
    idEquipe integer not null references equipe(idEquipe),
    idJoueur integer not null references joueur(idJoueur),
    dateContrat date
);
create table match(
    idMatch serial primary key, 
    lieu VARCHAR,
    dateDebut date,
    heureDebut time,
    equipe1 integer not null references equipe(idEquipe),
    equipe2 integer not null references equipe(idEquipe)
);
create table matchEffectif(
    idMatchEffectif serial primary key,
    idMatch integer references match(idMatch),
    idJoueur integer references joueur(idJoueur)
);
create table rebond(
    idMatchEffectif integer references matchEffectif(idMatchEffectif),
    minute integer, 
    second integer
);
create table passedecisive(
    idMatchEffectif integer references matchEffectif(idMatchEffectif),
    minute integer, 
    second integer
);

create table points(
    idMatchEffectif integer references matchEffectif(idMatchEffectif),
    minute integer, 
    second integer,
    points integer default 2
);
create table possession(
    idMatchEffectif integer references matchEffectif(idMatchEffectif),
    debut time,
    fin time
);


alter table possession 
add column idpossession serial  primary key;

alter table joueur_equipe
add column idjoueur_equipe serial primary key;



alter table rebond 
add column idrebond serial  primary key;


alter table passedecisive 
add column idpassedecisive serial  primary key;

alter table points 
add column idpoints serial  primary key;

