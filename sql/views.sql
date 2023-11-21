create or replace view v_lancer_front as (
    select 
    *
    from points where points = 1
);
create or replace view v_2_points as (
    select 
    *
    from points where points = 2
);

create or replace view v_3_points as (select * from points where points = 3);
create or replace  view v_statistiques as (
    select 
    joueur.idjoueur,nomJoueur,equipe.idEquipe,equipe.nomEquipe,equipe.abreviation,coalesce(count(rebond.idMatchEffectif)/count(matchEffectif.idMatchEffectif),0) as rebond,coalesce(count(passedecisive.idMatchEffectif)/count(matchEffectif.idMatchEffectif),0) as pdpm,coalesce(count(v_lancer_front.idMatchEffectif)/count(matchEffectif.idMatchEffectif),0) as lf, coalesce(count(v_2_points.idMatchEffectif)/count(matchEffectif.idMatchEffectif),0) as deuxp, coalesce(count(v_3_points.idMatchEffectif)/count(matchEffectif.idMatchEffectif),0) as troisp, coalesce(sum(points.points)/count(matchEffectif.idMatchEffectif),0) as ppm, coalesce(sum(possession.fin-possession.debut)/count(matchEffectif.idMatchEffectif),'00:00'::interval) as mpm
    from joueur
    join equipe
        on joueur.idEquipeActuelle = equipe.idEquipe
    join match
        on match.equipe1 = equipe.idEquipe
        or match.equipe2 = equipe.idEquipe
    join matchEffectif
        on match.idMatch = matchEffectif.idMatch
    left join rebond 
        on rebond.idMatchEffectif = matchEffectif.idMatchEffectif
    left join passedecisive 
        on passedecisive.idMatchEffectif = matchEffectif.idMatchEffectif
    left join points
        on points.idMatchEffectif = matchEffectif.idMatchEffectif
    left join v_lancer_front
        on v_lancer_front.idMatchEffectif = matchEffectif.idMatchEffectif
    left join v_2_points
        on v_2_points.idMatchEffectif = matchEffectif.idMatchEffectif
    left join v_3_points
     on v_3_points.idMatchEffectif = matchEffectif.idMatchEffectif
     left join possession
     on possession.idMatchEffectif = matchEffectif.idMatchEffectif
    group by joueur.idjoueur,joueur.nomJoueur,equipe.idEquipe,equipe.nomEquipe,equipe.abreviation
);
