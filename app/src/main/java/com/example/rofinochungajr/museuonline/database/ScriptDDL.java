package com.example.rofinochungajr.museuonline.database;

public class ScriptDDL {

    public  static String getCreateTableUtilizador(){
        StringBuilder sql=new StringBuilder();

      sql.append("CREATE TABLE utilizador (" +
              "    idUtilizador     INTEGER PRIMARY KEY AUTOINCREMENT," +
              "    nomeCompleto VARCHAR ,"+
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
        return sql.toString();
    }


    public static String getCreateTableGenero() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE genero (" +
                "    idGenero  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Genero    VARCHAR," +
                "    idFamilia INTEGER REFERENCES familia (idFamilia) " +
                ");"
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
        return sql.toString();
    }


    public  static String getCreateTableProvincia(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE provincia (" +
                "    idProvincia INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Provincia   VARCHAR," +
                "    idRegiao    INTEGER  REFERENCES regiao (idRegiao)  "+
                ");"
        );
        return sql.toString();
    }
    public static String getCreateTableRegiao(){
        StringBuilder sql=new StringBuilder();
        sql.append("CREATE TABLE regiao (" +
                "    idRegiao INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Regiao   VARCHAR" +
                ");"
        );
        return sql.toString();
    }
    public static String getCreateTableDistrito(){

        StringBuilder sql=new StringBuilder();
        sql.append("CREATE TABLE distrito (" +
                "    idDistrito  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Distrito    VARCHAR," +
                "    idProvincia INTEGER REFERENCES provincia (idProvincia) " +
                ");");

        return sql.toString();
    }

    public static String getCreateTablePreservacaoEspecie(){

        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE preservacaoespecie (" +
                "    idPreservacaoEspecie  INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    idMetodoDePreservacao INTEGER REFERENCES metododepreservacao (idMetodoDePreservacao)," +
                "    idEspecie             INTEGER REFERENCES especie (idEspecie) " +
                ");");
        return sql.toString();
    }

    public static String getCreateTableMetodoPreservacao(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE metododepreservacao (" +
                "    idMetodoDePreservacao INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Metodo                VARCHAR" +
                ");"
        );

        return sql.toString();
    }

    public static String getCreateTablePessoa() {
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE pessoa (" +
                "    idPessoa INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    Nome     VARCHAR" +
                ");"
        );

        return sql.toString();
    }

    public static String getCreateTableLocalizacaoEspecie(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE localizacaoespecie (" +
                "    idLocalizacao INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    idDistrito    INTEGER REFERENCES distrito (idDistrito)," +
                "    idEspecie     INTEGER REFERENCES especie (idEspecie)," +
                "    idProvincia   INTEGER REFERENCES provincia (idProvincia)," +
                "    idRegiao      INTEGER REFERENCES regiao (idRegiao) " +
                ");"
        );
        return sql.toString();
    }

    public static String getCreateTableQuemEncontrou(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE quemencontrou (" +
                "    idPessoa  INTEGER REFERENCES pessoa (idPessoa)," +
                "    idEspecie INTEGER REFERENCES especie (idEspecie)," +
                "    PRIMARY KEY (" +
                "        idPessoa," +
                "        idEspecie" +
                "    )" +
                ");"
        );

        return sql.toString();
    }

    public  static  String getCreateTableAmeacas(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE ameacas (" +
                "    idAmeaca INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    ameaca   VARCHAR" +
                ");");
        return sql.toString();
    }

    public static String getCreateTableAmeacasEspecie(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE ameacaEspecie (" +
                "    idAmeaca  INTEGER REFERENCES ameacas (idAmeaca)," +
                "    idEspecie INTEGER REFERENCES especie (idEspecie)," +
                "    PRIMARY KEY (" +
                "        idAmeaca," +
                "        idEspecie" +
                "    )" +
                ");"
        );

        return  sql.toString();
    }

    public static String getCreateTableQuemIdentificou(){
        StringBuilder sql=new StringBuilder();

        sql.append("CREATE TABLE quemidentificou (" +
                "    idPessoa  INTEGER REFERENCES pessoa (idPessoa)," +
                "    idEspecie INTEGER REFERENCES especie (idEspecie)," +
                "    PRIMARY KEY (" +
                "        idPessoa," +
                "        idEspecie" +
                "    )" +
                ");"
        );
        return sql.toString();
    }
}
