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

create or replace view v_statistiques_effectif as(
    select 
    matchEffectif.idMatchEffectif, joueur.idjoueur, coalesce(count(rebond.idMatchEffectif),0) as rebond,coalesce(count(passedecisive.idMatchEffectif),0) as pdpm,coalesce(count(v_lancer_front.idMatchEffectif),0) as lf, coalesce(count(v_2_points.idMatchEffectif),0) as deuxp, coalesce(count(v_3_points.idMatchEffectif),0) as troisp, coalesce(sum(points.points),0) as ppm, coalesce(sum(possession.fin-possession.debut),'00:00'::interval) as mpm
    from matchEffectif
    join joueur
        on joueur.idjoueur = matchEffectif.idjoueur
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
    group by matchEffectif.idMatchEffectif,joueur.idjoueur
);
create or replace view v_3_points as (select * from points where points = 3);
create or replace  view v_statistiques as (
    select 
    joueur.idjoueur,nomJoueur,equipe.idEquipe,equipe.nomEquipe,equipe.abreviation,sum(rebond)/count(matchEffectif.idMatchEffectif) as rebond, sum(pdpm)/count(matchEffectif.idMatchEffectif) as pdpm, sum(lf)/count(matchEffectif.idMatchEffectif) as lf, sum(deuxp)/count(matchEffectif.idMatchEffectif) as deuxp,sum(troisp)/count(matchEffectif.idMatchEffectif) as troisp,sum(ppm)/count(matchEffectif.idMatchEffectif) as ppm,sum(mpm)/count(matchEffectif.idMatchEffectif) as mpm
    from joueur
    join equipe
        on joueur.idEquipeActuelle = equipe.idEquipe
    join match
        on match.equipe1 = equipe.idEquipe
        or match.equipe2 = equipe.idEquipe
    join matchEffectif
        on matchEffectif.idMatch = match.idMatch
        and matchEffectif.idjoueur = joueur.idjoueur
    join v_statistiques_effectif
        on v_statistiques_effectif.idMatchEffectif = matchEffectif.idMatchEffectif
    group by joueur.idjoueur,nomJoueur,equipe.idEquipe,equipe.nomEquipe,equipe.abreviation
);
