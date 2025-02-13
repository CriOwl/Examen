-- database: ../../CCDatabase/CCEcuAnt.sqlite
DROP TABLE IF EXISTS CCHormiga;
DROP TABLE IF EXISTS CCSexo;
DROP TABLE IF EXISTS CCIngestaNativa;
DROP TABLE IF EXISTS CCGenoma;
DROP TABLE IF EXISTS CCAlimento;
DROP TABLE IF EXISTS CCTipoAlimento;
DROP TABLE IF EXISTS CCTipoHormiga;
DROP TABLE IF EXISTS CCEntomologo;
DROP TABLE IF EXISTS CCHormigaEntrenada;


CREATE TABLE IF NOT EXISTS
    CCHormiga(
        IdHormiga       INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,IdTipoHormiga  INTEGER NOT NULL REFERENCES CCTipoHormiga(IdTipoHormiga) 
        ,IdSexo         INTEGER NOT NULL REFERENCES CCSexo(IdSexo)
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('VIVA') 
        ,IdIngestaNativa INTEGER REFERENCES CCIngestaNativa (IdIngestaNativa)
        ,IdGenoma        INTEGER REFERENCES CCGenoma(IdGenoma)
        ,Entrenada      VARCHAR(2) NOT NULL DEFAULT ('NO') CONSTRAINT Entrenada CHECK(Entrenada IN ('SI','NO'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME
    );
    --aaaaaaaaaaa
CREATE TABLE IF NOT EXISTS
    CCIngestaNativa(
        IdIngestaNativa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,Name           VARCHAR(25) NOT NULL UNIQUE
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME
    );
CREATE TABLE IF NOT EXISTS
    CCGenoma(
        IdGenoma        INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,Name           VARCHAR(5) NOT NULL UNIQUE
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME
    );

CREATE TABLE IF NOT EXISTS
    CCTipoHormiga(
        IdTipoHormiga   INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,Name           VARCHAR(5) NOT NULL UNIQUE
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME
    );
CREATE TABLE IF NOT EXISTS
    CCEntomologo(
        IdEntomologo    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,Name           VARCHAR(25) NOT NULL
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME
    );

CREATE TABLE IF NOT EXISTS
    CCHormigaEntrenada(
        IdHormigaEntrenada    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,IdHormiga            INTEGER NOT NULL REFERENCES CCHormiga(IdHormiga)
        ,IdEntomologo         INTEGER NOT NULL REFERENCES CCEntomologo(IdEntomologo)
        ,Estado               VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion        DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua           DATETIME
    );
CREATE TABLE IF NOT EXISTS
    CCSexo(
       IdSexo    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
        ,Name           VARCHAR(25) NOT NULL
        ,Estado         VARCHAR(10) NOT NULL DEFAULT ('A') CONSTRAINT Estado CHECK(Estado IN ('A','D'))
        ,FechaCreacion  DATETIME DEFAULT (datetime('now', 'localtime'))
        ,FechaActua     DATETIME 
    );

 DROP VIEW IF EXISTS CCVwHormiga;
 CREATE VIEW IF NOT EXISTS CCVwHormiga AS
    SELECT
        h.IdHormiga AS ID
        ,t.Name AS TipoHormiga
        ,s.Name AS SEXO
        ,CONCAT(COALESCE(n.Name, ' '),' ', COALESCE(g.Name, '') ) AS Alimento
        ,h.Estado AS Estado
        ,h.Entrenada AS Entrenado
FROM CCHormiga h
    JOIN CCTipoHormiga t ON h.IdTipoHormiga=t.IdTipoHormiga
    JOIN CCSexo s ON h.IdSexo=s.IdSexo
    LEFT JOIN CCIngestaNativa n ON h.IdIngestaNativa=n.IdIngestaNativa
    LEFT JOIN  CCGenoma g ON h.IdGenoma=g.IdGenoma;

INSERT INTO CCTipoHormiga  (Name) VALUES 
('HLarva'), ('HSoldado'), ('HZangano'), ('HRastreadora'), ('HReina'), ('HObrera');


INSERT INTO CCIngestaNativa (Name) VALUES 
('Nectarivoro'), ('Carnivoro'), ('Omnivoro'), ('Herbivoro'), ('Insectivoro');

INSERT INTO CCGenoma (Name) VALUES 
('X'), ('XX'), ('XY');
INSERT INTO  CCSexo (Name) VALUES 
('ASEXUAL'), ('MACHO'), ('HEMBRA');

INSERT INTO CCHormiga (IdTipoHormiga, IdSexo) VALUES
(1,1),
(1,1),
(1,1);
