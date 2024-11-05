INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-17', 'Andrés', TRUE, 20050);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-16', 'Andrea', FALSE, 820);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-17', 'Kevin', FALSE, 910);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-15', 'Adrián', FALSE, 660);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-14', 'María', FALSE, 870);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-17', 'Estefany', FALSE, 500);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-16', 'Mercy', FALSE, 430);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-13', 'Arancha', FALSE, 220);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-15', 'Anaís', FALSE, 390);
INSERT INTO games (game_date, player_name, game_cleared, final_score) VALUES ('2024-10-14', 'Esmeralda', TRUE, 22250);
INSERT INTO monsters (id_monster, type_monster, monster_damage, monster_health, monster_name, bonus, life_stealing_active, invisible_active, num_skeletons)
VALUES (1, 'Esqueleto', 5, 50, 'Esqueleto', 10, NULL, NULL, 5),
       (2, 'Vampiro', 7, 60, 'Vampiro', 15, TRUE, NULL, NULL),
       (3, 'Fantasma', 10, 70, 'Fantasma', 20, NULL, TRUE, NULL);

INSERT INTO items (item_name, item_description) VALUES 
('Lanza', 'Una lanza afilada, útil para el combate.'), 
('Poción', 'Una poción curativa que restaura salud.'), 
('Ajo', 'Un diente de ajo, eficaz contra los vampiros.'), 
('Gafas', 'Unas gafas que permiten ver a los fantasmas.'), 
('Silbato', 'Un silbato que puede atraer a un lobo amigo.');
INSERT INTO Aiden(id, aiden_Name, aiden_Description, aiden_Ability, aiden_Health, aiden_Damage)
VALUES (1, 'AIDEN', 'Es un heroe que posee habilidades cuya finalidad es derrotar al mago Mortis', 'Golpe potente y escudo protector', 100,15);