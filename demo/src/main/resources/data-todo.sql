INSERT INTO priorite (nom) VALUES
("Important"),
("Moyen"),
("Faible");

INSERT INTO droit (nom) VALUES
("Administrateur"),
("redacteur"),
("employe");

-- mot de passe = root --
INSERT INTO utilisateur (pseudo, password,droit_id) VALUES
("selim",  "toto",1) ,
("test",  "titi",2),
("oppo",  "tata",3);

INSERT INTO tache (description,nom,valide,priorite_id) VALUES
("Manger avant de travailler","Manger",1,1),
("Travailler apres avoir manger","Travailler",0,2),
("Dormir apres avoit travailler","Dormir",0,3);

INSERT INTO affecter(utilisateur_id, tache_id) VALUES
(1,2),
(1,3),
(2,1),
(2,2),
(1,2),
(2,3),
(2,3);
