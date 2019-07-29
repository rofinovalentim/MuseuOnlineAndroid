package com.example.rofinochungajr.museuonline.database;

public class ScriptDDL {

    public  static String getCreateTableUtilizador(){
        StringBuilder sql=new StringBuilder();

      sql.append("CREATE TABLE utilizador (" +
              "    idUtilizador     INTEGER PRIMARY KEY AUTOINCREMENT," +
              "    email            VARCHAR," +
              "    Senha            VARCHAR," +
              "    idtipoutilizador INTEGER REFERENCES tipoutilizador (idtipoutilizador) " +
              ");"
      );
        return sql.toString();
    }
    public static String getCreateTableTipoUtilizador() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE tipoutilizador (" +
                "    idtipoutilizador INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    tipoutilizador   VARCHAR " +
                ");"
        );
       sql.append("INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (7, '$pbkdf2-sha512$25000$/n9P6f1f690bgzCm1PofIw$wzTxvm5GWVHWRcgk7f4iZnJGt9Pkd7yAJ4HSIsZnqwOand98.gdf.xRqzqnOcZN8h0n.k1Enx2tcXO8r7qO3sg');\n" +
                "INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (19, '$pbkdf2-sha512$25000$K.W8t9Y6xzgnZOx9zxkDwA$v.palSK9MP5/Uq6gu3LfIk9Pj984VQ4TRiSw6Yq4YJMCqDGvSI4RIRaDf10nJho/Jl2GqMhKJJ4.8pPgVC/CmQ');\n" +
                "INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (2016, '$pbkdf2-sha512$25000$oLQWYqyVMgZAKCUkxJhTSg$JdDWQ7hgQtBk4QAB0z0RHgTd/eD6g.SAsj18RCjC2ghy4cvc9973e1pp0me6Elvv/G67iqgaf/xwjVxEDSt4kw');\n"
        );
        return sql.toString();
    }

    public static String getCreateTableReino() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE reino (" +
                "    idReino INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Reino   VARCHAR" +
                ");"
        );
        sql.append("INSERT INTO reino (idReino, Reino) VALUES (3, 'Fungi');\n" +
                "INSERT INTO reino (idReino, Reino) VALUES (4, 'Protista');\n" +
                "INSERT INTO reino (idReino, Reino) VALUES (5, 'Plantae');\n" +
                "INSERT INTO reino (idReino, Reino) VALUES (6, 'Monera');\n" +
                "INSERT INTO reino (idReino, Reino) VALUES (7, 'Animalia');\n" +
                "INSERT INTO reino (idReino, Reino) VALUES (8, 'Fungire');\n"
        );
        return sql.toString();
    }


    public static String getCreateTableFilo() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE filo (" +
                "    idFilo  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Filo    VARCHAR," +
                "    idReino INTEGER REFERENCES reino (idReino) " +
                ");"
        );

        sql.append("INSERT INTO filo (idFilo, Filo, idReino) VALUES (4, 'Ciliophora', 4);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (6, 'Rhizopoda', 4);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (7, 'Ascomycota', 3);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (8, 'Basidiomycota', 3);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (9, 'Glomeromycota', 3);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (10, 'Micospora', 3);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (11, 'Zygomycota', 3);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (12, 'Anthocerotophyta', 5);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (13, 'Bryophyta', 5);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (14, 'Charophyta', 5);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (15, 'Equisetophyta', 5);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (16, 'Annelida', 7);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (17, 'Arthropoda', 7);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (18, 'Brachiopoda', 7);\n" +
                "INSERT INTO filo (idFilo, Filo, idReino) VALUES (19, 'Chordata', 7);\n" +
                "\n"
        );
        return sql.toString();
    }

    public static String getCreateTableClasse() {
        StringBuilder sql = new StringBuilder();

       sql.append("CREATE TABLE classe (" +
                "    idClasse INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Classe   VARCHAR," +
                "    idFilo   INTEGER REFERENCES filo (idFilo) " +
                ");"
        );

        sql.append("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (11, 'Entognatha', 17);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (12, 'Insecta', 17);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (13, 'Agaricomycetes', 8);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (14, 'Actinopterygii', 19);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (15, 'Malacostraca', 17);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (16, 'Diplopoda', 17);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (17, 'Glomeromycetes', 9);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (19, 'Dothideomycetes', 7);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (20, 'Arachnida', 17);\n" +
                "INSERT INTO classe (idClasse, Classe, idFilo) VALUES (21, 'Sordariomycetes', 7);"
        );
        return sql.toString();
    }

    public static String getCreateTableOrdem() {
        StringBuilder sql = new StringBuilder();

       sql.append("CREATE TABLE ordem (" +
                "    idOrdem  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Ordem    VARCHAR," +
                "    idClasse INTEGER REFERENCES classe (idClasse) " +
                ");"
        );
        sql.append("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (2, 'Orthoptera', 12);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (3, 'Lepidoptera', 12);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (4, 'Coleoptera', 12);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (5, 'Decapoda', 15);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (6, 'Diptera', 12);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (7, 'Capnodiales', 19);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (8, 'Pleosporales', 19);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (9, 'Botryosphaeriales', 19);\n" +
                "INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (10, 'Hemiptera', 12);\n"
        );
        return sql.toString();
    }

    public static String getCreateTableFamilia() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE familia (" +
                "    idFamilia INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Familia   VARCHAR," +
                "    idOrdem   INTEGER REFERENCES ordem (idOrdem) " +
                ");"
        );
        sql.append("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (2, 'Diplodia', 9);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (3, 'Acrididae', 2);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (4, 'Phoridae', 6);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (5, 'Dasytidae', 4);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (6, 'Aphididae', 10);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (7, 'Davidiellaceeae', 7);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (8, 'Carabidae', 4);\n" +
                "INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (9, 'Tenebrionidae', 4);\n"
        );
        return sql.toString();
    }


    public static String getCreateTableGenero() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE genero (" +
                "    idGenero  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Genero    VARCHAR DEFAULT ('')," +
                "    idFamilia INTEGER REFERENCES familia (idFamilia) " +
                ");"
        );
        sql.append("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (1, 'Graellsinus', 5);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (2, 'Mauroania', 5);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (3, 'Oxynotus', 5);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (4, 'Acroconidiella', 7);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (5, 'Amara', 8);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (6, 'Acyrthosiphon', 6);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (7, 'Aplocnemus', 5);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (8, 'Alphasida', 9);\n" +
                "INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (15, 'mmmmmm', 3);\n"
        );
        return sql.toString();
    }


    public static String getCreateTableEspecie() {
        StringBuilder sql = new StringBuilder();

       sql.append("CREATE TABLE especie (" +
                "    idEspecie   INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Especie     VARCHAR," +
                "    idGenero    INTEGER REFERENCES genero (idGenero)," +
                "    Habitat     VARCHAR," +
                "    Coordenadas VARCHAR," +
                "    Notas       VARCHAR," +
                "    detalhes    VARCHAR," +
                "    NomeComum   VARCHAR," +
                "    Codigo      VARCHAR," +
                "    Validacao   VARCHAR," +
                "    DataCriacao DATE" +
                ");"
        );
       sql.append("INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (12, 'peixe', 1, 'nampula', '32-565', '17', 'electrecista', 'peixe', '4365', '23', '2018-11-04');\n" +
                "INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (13, 'tartaruga', 1, 'lichinga', '243-55', '17', 'estudante', 'tartaruga', '2354', '3', '2018-11-04');\n" +
                "INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (14, 'neldo', 1, 'nampula', '243-55', '17', 'estudante', 'guerzeneldo', '4365', '23', '2018-11-04');\n" +
                "INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (15, 'mario', 5, 'lichinga', '243-55', '17', 'estudante', 'rafath', '4365', '3', '2018-11-04');\n" +
                "INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (16, 'lagarto', 1, 'pemba', '32-565', '17', 'marinho', 'lagarto', '4365', '3', '2018-11-04');\n" +
                "INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES (17, 'helena', 1, 'nampula', '243-55', '17', 'estudante', 'rafath', '2354', '', '2018-11-04');\n"
        );
        return sql.toString();
    }
}
