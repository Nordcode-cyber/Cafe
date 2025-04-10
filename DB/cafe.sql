create database cafe;
show databases;
use cafe;
CREATE TABLE cafe(
  id_cafe int,
  tipo  varchar(255),
  marca varchar(255),
  region varchar(255), -- ocupado, libre
  peso float,
  tostado varchar(255),
  presentacion varchar(255),
  secado varchar(255),
  cafeina float,
  notas varchar(255),
  PRIMARY KEY (id_cafe)
   );
   ALTER TABLE cafe MODIFY COLUMN id_cafe int auto_increment;
   SELECT * FROM cafe;
   INSERT INTO cafe(tipo,marca,region,peso,tostado,presentacion,secado,cafeina,notas) VALUES ('expreso','huila','peru','950.5','oscuro','bolsa','aire','1.75','malteado');
   