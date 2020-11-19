insert into
    Evenement
    (id, nom, debut, duree)
values
    (1, 'DevFest Nantes', '2021-10-21', 2),
    (2, 'Devoxx France', '2021-05-07', 3),
    (3, 'BattleDev', '2020-11-26', 1);
alter sequence hibernate_sequence restart with 5;
