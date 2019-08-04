package com.example.rofinochungajr.museuonline.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public DataBaseOpenHelper(@Nullable Context context) {
        super(context, "database", null, 1);
        //this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableTipoUtilizador());
        sqLiteDatabase.execSQL("INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (7, '$pbkdf2-sha512$25000$/n9P6f1f690bgzCm1PofIw$wzTxvm5GWVHWRcgk7f4iZnJGt9Pkd7yAJ4HSIsZnqwOand98.gdf.xRqzqnOcZN8h0n.k1Enx2tcXO8r7qO3sg');");
        sqLiteDatabase.execSQL("INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (19, '$pbkdf2-sha512$25000$K.W8t9Y6xzgnZOx9zxkDwA$v.palSK9MP5/Uq6gu3LfIk9Pj984VQ4TRiSw6Yq4YJMCqDGvSI4RIRaDf10nJho/Jl2GqMhKJJ4.8pPgVC/CmQ');");
        sqLiteDatabase.execSQL("INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES (2016, '$pbkdf2-sha512$25000$oLQWYqyVMgZAKCUkxJhTSg$JdDWQ7hgQtBk4QAB0z0RHgTd/eD6g.SAsj18RCjC2ghy4cvc9973e1pp0me6Elvv/G67iqgaf/xwjVxEDSt4kw');");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableUtilizador());
        sqLiteDatabase.execSQL("INSERT INTO utilizador(idUtilizador, nomeCompleto, email, Senha , idtipoutilizador) VALUES (1,'Rofino Valentim','admin@gmail.com','admin',7);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableReino());
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (3, 'Fungi');");
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (4, 'Protista');");
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (5, 'Plantae');");
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (6, 'Monera');");
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (7, 'Animalia');");
        sqLiteDatabase.execSQL("INSERT INTO reino (idReino, Reino) VALUES (8, 'Fungire');");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableFilo());
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (4, 'Ciliophora', 4);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (6, 'Rhizopoda', 4);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (7, 'Ascomycota', 3);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (8, 'Basidiomycota', 3);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (9, 'Glomeromycota', 3);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (10, 'Micospora', 3);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (11, 'Zygomycota', 3);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (12, 'Anthocerotophyta', 5);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (13, 'Bryophyta', 5);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (14, 'Charophyta', 5);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (15, 'Equisetophyta', 5);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (16, 'Annelida', 7);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (17, 'Arthropoda', 7);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (18, 'Brachiopoda', 7);");
        sqLiteDatabase.execSQL("INSERT INTO filo (idFilo, Filo, idReino) VALUES (19, 'Chordata', 7);" );

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableClasse());
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (11, 'Entognatha', 17);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (12, 'Insecta', 17);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (13, 'Agaricomycetes', 8);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (14, 'Actinopterygii', 19);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (15, 'Malacostraca', 17);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (16, 'Diplopoda', 17);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (17, 'Glomeromycetes', 9);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (19, 'Dothideomycetes', 7);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (20, 'Arachnida', 17);");
        sqLiteDatabase.execSQL("INSERT INTO classe (idClasse, Classe, idFilo) VALUES (21, 'Sordariomycetes', 7);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableOrdem());
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (2, 'Orthoptera', 12);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (3, 'Lepidoptera', 12);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (4, 'Coleoptera', 12);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (5, 'Decapoda', 15);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (6, 'Diptera', 12);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (7, 'Capnodiales', 19);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (8, 'Pleosporales', 19);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (9, 'Botryosphaeriales', 19);");
        sqLiteDatabase.execSQL("INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES (10, 'Hemiptera', 12);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableFamilia());
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (2, 'Diplodia', 9);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (3, 'Acrididae', 2);" );
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (4, 'Phoridae', 6);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (5, 'Dasytidae', 4);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (6, 'Aphididae', 10);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (7, 'Davidiellaceeae', 7);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (8, 'Carabidae', 4);");
        sqLiteDatabase.execSQL("INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES (9, 'Tenebrionidae', 4);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableGenero());
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (3, 'Oxynotus', 5);" );
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (4, 'Acroconidiella', 7);");
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (5, 'Amara', 8);");
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (6, 'Acyrthosiphon', 6);");
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (7, 'Aplocnemus', 5);");
        sqLiteDatabase.execSQL("INSERT INTO genero (idGenero, Genero, idFamilia) VALUES (8, 'Alphasida', 9);" );
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableEspecie());

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableRegiao());

        sqLiteDatabase.execSQL("INSERT INTO regiao (idRegiao, Regiao) VALUES (1, 'Norte');");
        sqLiteDatabase.execSQL("INSERT INTO regiao (idRegiao, Regiao) VALUES (2, 'Centro');");
        sqLiteDatabase.execSQL("INSERT INTO regiao (idRegiao, Regiao) VALUES (3, 'Sul');");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableProvincia());
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (1, 'Cabo Delgado', 1.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (2, 'Niassa', 1.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (3, 'Nampula', 1.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (4, 'ZambÃ©zia', 2.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (5, 'Tete', 2.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (6, 'Manica', 2.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (7, 'Sofala', 2.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (8, 'Gaza', 3.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (9, 'Inhambane', 3.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (10, 'Maputo Cidade', 3.0);");
        sqLiteDatabase.execSQL("INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES (11, 'Maputo Provincia', 3.0);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableDistrito());
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (4, 'Cidade de Pemba', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (5, 'Ancuabe', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (6, 'Balama', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (7, 'ChiÃºre', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (8, 'Ibo', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (9, 'Macomia', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (10, 'MecÃºfi', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (11, 'Meluco', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (12, 'Mocimboa da Praia', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (13, 'Montepuez', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (14, 'Mueda', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (15, 'Muidumbe', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (16, 'Namuno', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (17, 'Nangade', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (18, 'Palma', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (19, 'Pemba-Metuge', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (20, 'Quissanga', 1);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (21, 'Distrito Urbano Nr 1', 10);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (22, 'Distrito Urbano Nr 2', 10);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (23, 'Distrito Urbano Nr 3', 10);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (24, 'Distrito Urbano Nr 4', 10);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (25, 'Distrito Urbano Nr 5', 10);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (26, 'Cidade de Xai-Xai', 8);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (27, 'Bilene Macia', 8);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (28, 'Chibuto', 8);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (29, 'Chicualacuala', 8);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (30, 'Chigubo', 8);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (31, 'Cidade de Inhanbane', 9);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (32, 'Funhalouro', 9);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (33, 'HomoÃ\u00ADne', 9);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (34, 'Inharrime', 9);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (35, 'Cidade de Chimoio', 6);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (36, 'Gondola', 6);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (37, 'Guro', 6);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (38, 'Manica', 6);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (39, 'Tambara', 6);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (40, 'Cidade de Matola', 11);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (41, 'Boane', 11);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (42, 'Magude', 11);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (43, 'Cidade de Nampula', 3);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (44, 'Angoche', 3);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (45, 'Ilha de MoÃ§ambique', 3);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (46, 'Cidade de Lichinga', 2);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (47, 'Cuamba', 2);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (48, 'Lago', 2);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (49, 'Lichinga', 2);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (50, 'Sanga', 2);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (51, 'Cidade da Beira', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (52, 'Caia', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (53, 'Chemba', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (54, 'Dondo', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (55, 'Gorongosa', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (56, 'Muchanga', 7);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (57, 'Desconhecida', 4);");
        sqLiteDatabase.execSQL("INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES (58, 'desconhecido', 4);");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableAmeacas());
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (1, 'ATROPELAMENTOS');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (2, 'ENVENENAMENTO');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (3, 'DOENÇAS');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (4, 'TRÁFICO');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (5, 'CAÇA');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (6, 'FOGO');");
        sqLiteDatabase.execSQL("INSERT INTO ameacas (idAmeaca, ameaca) VALUES (7, 'DESTRUIÇÃO DOS AMBIENTES NATURAIS');");

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableLocalizacaoEspecie());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTablePessoa());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableQuemEncontrou());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableQuemIdentificou());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableMetodoPreservacao());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTablePreservacaoEspecie());
        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableAmeacasEspecie());



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
