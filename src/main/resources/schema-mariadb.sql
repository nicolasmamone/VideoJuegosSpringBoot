DROP TABLE if exists videojuego;
DROP TABLE if exists distribuidor;

CREATE TABLE videojuego (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    descripcion varchar(3000),
    imagen_url varchar(500)
);

INSERT INTO videojuego
(id,   nombre                  ,    descripcion              , imagen_url) VALUES
(1,   'Borderlands 3'          ,    '¡Vuelve el padre de los shooter-looter, con tropecientas mil armas y una aventura caótica!', 'https://cdn1.epicgames.com/catnip/offer/BL3Wide_2560x1440-2560x1440-462318f36bee20de4412e111ef72dc62.jpg' ),
(2,   'Control Ultimate'       ,    'Tras la invasión de una agencia secreta de Nueva York por parte de una amenaza de otro mundo, te conviertes en la nueva directora que deberá luchar para recuperar Control.', 'https://505games.com/wp-content/uploads/2021/02/control-r.jpg'),
(3,   'Subnautica'             ,    'Un juego de aventuras submarinas ambientado en un mundo oceánico alienígena. ¡Te espera un mundo abierto enorme lleno de maravillas y peligros!', 'https://store.playstation.com/store/api/chihiro/00_09_000/container/ES/es/999/EP5426-CUSA13893_00-2222444466669999/1568624921000/image?w=240&h=240&bg_color=000000&opacity=100&_version=00_09_000'),
(4,   'Firewatch'              ,    'Firewatch es un juego de misterio en primera persona para un jugador que se desarrolla en la selva de Wyoming', 'https://www.mobygames.com/images/covers/l/323028-firewatch-playstation-4-front-cover.jpg'),
(5,   'Bioshock Infinite'      ,    'La ultima gran entrega de la saga Bioshock, ahora en una imperdible ciudad de ensueño entre las nubes','https://store-images.s-microsoft.com/image/apps.10859.67464002826651900.5ac05a93-3cb3-46b8-ae2a-db17dc2eb01e.c3564147-01d7-4dfb-a9c8-e8e06dbbb25d?q=90&w=480&h=270'),
(6,   'Insurgency: Sandstorm'  ,    'Un FPS táctico por equipos basado en combates letales en espacios reducidos y multijugador centrado en objetivos','https://cdn1.epicgames.com/salesEvent/salesEvent/EGS_InsurgencySandstormbasegame_NewWorldInteractive_Editions_S1_2560x1440-ad297a516ee88bc43fd232fb3b224c98'),
(7,   'The Witness'            ,    'Te despiertas, a solas, en una extraña isla llena de puzzles que te retarán y sorprenderán','https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/01/559102-witness-es-juego-mas-descargado-piratas.png?tf=1200x'),
(8,   'Braid'                  ,    'Un juego de rompecabezas con toques plataformeros, donde puedes manipular el flujo del tiempo de unas maneras inusuales y extrañas','https://hb.imgix.net/2329171c2fae9fa5855842c2578b5bd1e6e5ebd9.jpeg?auto=compress,format&fit=crop&h=353&w=616&s=ac080ebd661a9a2f0994571c1023bd79'),
(9,   'Halo Infinite'          ,    'Ponte la armadura del mayor héroe de la humanidad para disfrutar de una aventura épica y explorar la escala masiva del anillo Halo.','https://store-images.s-microsoft.com/image/apps.21536.13727851868390641.c9cc5f66-aff8-406c-af6b-440838730be0.68796bde-cbf5-4eaa-a299-011417041da6'),
(10,  'Forza Horizon 5'        ,    'Explora los dinámicos paisajes de mundo abierto y en constante evolución de México con cientos de los mejores autos del mundo.','https://store-images.s-microsoft.com/image/apps.49800.13718773309227929.bebdcc0e-1ed5-4778-8732-f4ef65a2f445.9ac09d39-064d-466c-81ca-2f1b6f0b95c5'),
(11,  'Space Marine 2'         ,    'La galaxia está en peligro. Mundos enteros se están cayendo. El Imperio te necesita. Encarna la habilidad sobrehumana y la brutalidad de un Marine Espacial','https://cdn-prod.scalefast.com/public/assets/user/13772687/image/12782cb1e8e8c543c307578f8193a078.jpg' ),
(12,  'Age of Empires IV'      ,    'Uno de los juegos de estrategia en tiempo real más queridos vuelve a la gloria con Age of Empires IV, donde tú estarás en el centro de las épicas batallas históricas','https://store-images.s-microsoft.com/image/apps.63959.14414177346088864.108aa077-3bb5-4152-b348-a5ab82c914f6.8a8ef1b9-6193-4717-827c-c538d376f926' );

CREATE TABLE distribuidor(
    id int primary key auto_increment,
    nombre varchar(200) not null,
    sitio_web varchar(500)
);

INSERT INTO distribuidor
(id,        nombre                          ,  sitio_web                        ) VALUES
(1 ,        '2k'                            ,  'http://2k.com'                  ),
(2 ,        'Focus Home Interactive'        ,  'https://www.focus-entmt.com/'   ),
(3 ,        'Thecka'                        ,  null                             ),
(4 ,        'Number One'                    ,  null                             ),
(5 ,        '505 Games'                     ,  'https://505games.com'           ),
(6 ,        'Unknown Worlds Enterteinment'  ,  'https://unknownworlds.com'      ),
(7 ,        'Campo Santo'                   ,  'https://camposanto.com'         ),
(8 ,        'Xbox Game Studios'             ,  'https://www.xbox.com/'          );

# ALTER: Nos permite modificar estructuras en la BD (como tablas) sin afectar a los datos ya almacenados
# FOREIGN KEY: permite asociar una columna a un ID de otra tabla Se usa para asociar dos conceptos en dos tablas distintas
ALTER TABLE videojuego
ADD COLUMN distribuidor_id int,
ADD FOREIGN KEY (distribuidor_id) REFERENCES distribuidor(id);

# IN: permite igualar una columna a un conjunto de valores, separados por coma
UPDATE videojuego SET distribuidor_id = 1 WHERE id IN (1);
UPDATE videojuego SET distribuidor_id = 2 WHERE id IN (5,11);
UPDATE videojuego SET distribuidor_id = 3 WHERE id IN (7);
UPDATE videojuego SET distribuidor_id = 5 WHERE id IN (2,6);
UPDATE videojuego SET distribuidor_id = 6 WHERE id IN (3);
UPDATE videojuego SET distribuidor_id = 7 WHERE id IN (4);
UPDATE videojuego SET distribuidor_id = 8 WHERE id IN (8,9,10,12);

# Despues de rellenar los distribuidor_id modificamos la tabla diciendole que sea NOT NULL
ALTER TABLE videojuego
MODIFY distribuidor_id int not null;