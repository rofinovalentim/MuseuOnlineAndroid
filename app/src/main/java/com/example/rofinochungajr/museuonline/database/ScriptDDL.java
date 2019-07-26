package com.example.rofinochungajr.museuonline.database;

public class ScriptDDL {

    public static String getCreateDataBase(){
        StringBuilder sql=new StringBuilder();



       sql.append("DROP TABLE IF EXISTS cadastroPedido;" +
               "CREATE TABLE cadastroPedido (" +
               " idcadastroPedido int(11) NOT NULL AUTO_INCREMENT," +
               " email varchar(255) DEFAULT NULL, " +
               " password varchar(255) DEFAULT NULL, " +
               " PRIMARY KEY (`idcadastroPedido`)" +
               ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;"
       );

        sql.append("DROP TABLE IF EXISTS `classe`;" +
                "CREATE TABLE `classe` (" +
                "  `idClasse` int(10) unsigned NOT NULL AUTO_INCREMENT," +
                "  `Classe` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idFilo` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idClasse`),\n" +
                "  KEY `FK_Classe_1` (`idFilo`),\n" +
                "  CONSTRAINT `FK_Classe_1` FOREIGN KEY (`idFilo`) REFERENCES `filo` (`idFilo`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;"
        );

        sql.append("DROP TABLE IF EXISTS `distrito`;\n" +
                "CREATE TABLE `distrito` (\n" +
                "  `idDistrito` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Distrito` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idProvincia` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idDistrito`),\n" +
                "  KEY `FK_distrito_1` (`idProvincia`),\n" +
                "  CONSTRAINT `FK_distrito_1` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `especie`;\n" +
                "CREATE TABLE `especie` (\n" +
                "  `idEspecie` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Especie` varchar(45) DEFAULT NULL,\n" +
                "  `idGenero` int(10) unsigned DEFAULT NULL,\n" +
                "  `Habitat` varchar(1000) DEFAULT NULL,\n" +
                "  `Coordenadas` varchar(600) DEFAULT NULL,\n" +
                "  `Notas` varchar(1000) DEFAULT NULL,\n" +
                "  `detalhes` varchar(1000) DEFAULT NULL,\n" +
                "  `NomeComum` varchar(45) DEFAULT NULL,\n" +
                "  `Codigo` varchar(10000) DEFAULT NULL,\n" +
                "  `Validacao` varchar(45) NOT NULL DEFAULT 'Nao Validado',\n" +
                "  `DataCriacao` date NOT NULL DEFAULT '0000-00-00',\n" +
                "  PRIMARY KEY (`idEspecie`),\n" +
                "  KEY `FK_Especie_1` (`idGenero`),\n" +
                "  CONSTRAINT `FK_Especie_1` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `especieImagem`;\n" +
                "CREATE TABLE `especieImagem` (\n" +
                "  `idImagem` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `imagem` varchar(1000) DEFAULT NULL,\n" +
                "  `idEspecie` int(10) unsigned NOT NULL,\n" +
                "  PRIMARY KEY (`idImagem`),\n" +
                "  KEY `FK_Figura_Especie` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_Figura_Especie` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `especieincompleta`;\n" +
                "CREATE TABLE `especieincompleta` (\n" +
                "  `idEspecie` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  `idFamilia` int(10) unsigned DEFAULT NULL,\n" +
                "  `idOrdem` int(10) unsigned DEFAULT NULL,\n" +
                "  `idClasse` int(10) unsigned DEFAULT NULL,\n" +
                "  `idFilo` int(10) unsigned DEFAULT NULL,\n" +
                "  `idReino` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idEspecie`),\n" +
                "  KEY `FK_especieIncompleta_2` (`idFamilia`),\n" +
                "  KEY `FK_especieIncompleta_3` (`idOrdem`),\n" +
                "  KEY `FK_especieIncompleta_4` (`idClasse`),\n" +
                "  KEY `FK_especieIncompleta_5` (`idFilo`),\n" +
                "  KEY `FK_especieIncompleta_6` (`idReino`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_1` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_2` FOREIGN KEY (`idFamilia`) REFERENCES `familia` (`idFamilia`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_3` FOREIGN KEY (`idOrdem`) REFERENCES `ordem` (`idOrdem`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_4` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`idClasse`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_5` FOREIGN KEY (`idFilo`) REFERENCES `filo` (`idFilo`),\n" +
                "  CONSTRAINT `FK_especieIncompleta_6` FOREIGN KEY (`idReino`) REFERENCES `reino` (`idReino`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
        );

        sql.append("DROP TABLE IF EXISTS `especieSom`;\n" +
                "CREATE TABLE `especieSom` (\n" +
                "  `idSom` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `som` varchar(1000) DEFAULT NULL,\n" +
                "  `idEspecie` int(10) unsigned NOT NULL,\n" +
                "  PRIMARY KEY (`idSom`),\n" +
                "  KEY `FK_especieSom` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_especieSom` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `especieVideo`;\n" +
                "CREATE TABLE `especieVideo` (\n" +
                "  `idVideo` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `video` varchar(1000) DEFAULT NULL,\n" +
                "  `idEspecie` int(10) unsigned NOT NULL,\n" +
                "  PRIMARY KEY (`idVideo`),\n" +
                "  KEY `FK_especieVideo` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_especieVideo` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `familia`;\n" +
                "CREATE TABLE `familia` (\n" +
                "  `idFamilia` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Familia` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idOrdem` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idFamilia`),\n" +
                "  KEY `FK_Familia_1` (`idOrdem`),\n" +
                "  CONSTRAINT `FK_Familia_1` FOREIGN KEY (`idOrdem`) REFERENCES `ordem` (`idOrdem`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `filo`;\n" +
                "CREATE TABLE `filo` (\n" +
                "  `idFilo` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Filo` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idReino` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idFilo`),\n" +
                "  KEY `FK_Filo_1` (`idReino`),\n" +
                "  CONSTRAINT `FK_Filo_1` FOREIGN KEY (`idReino`) REFERENCES `reino` (`idReino`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `genero`;\n" +
                "CREATE TABLE `genero` (\n" +
                "  `idGenero` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Genero` varchar(45) NOT NULL DEFAULT 'N/A',\n" +
                "  `idFamilia` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idGenero`),\n" +
                "  KEY `FK_Genero_1` (`idFamilia`),\n" +
                "  CONSTRAINT `FK_Genero_1` FOREIGN KEY (`idFamilia`) REFERENCES `familia` (`idFamilia`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `localizacaoespecie`;\n" +
                "CREATE TABLE `localizacaoespecie` (\n" +
                "  `idLocalizacao` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `idDistrito` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  `idEspecie` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idLocalizacao`,`idDistrito`,`idEspecie`),\n" +
                "  KEY `FK_LocalizacaoEspecie_2` (`idDistrito`),\n" +
                "  KEY `FK_LocalizacaoEspecie_1` (`idEspecie`),\n" +
                "  CONSTRAINT `fk_localizacaoespecie_1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_localizacaoespecie_2` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `localizacaoincompleta`;\n" +
                "CREATE TABLE `localizacaoincompleta` (\n" +
                "  `idEspecie` int(10) unsigned DEFAULT NULL,\n" +
                "  `idProvincia` int(10) unsigned DEFAULT NULL,\n" +
                "  `idRegiao` int(10) unsigned DEFAULT NULL,\n" +
                "  `idLocalizacao` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idLocalizacao`),\n" +
                "  KEY `FK_localizacaoincompleta_1` (`idEspecie`),\n" +
                "  KEY `FK_localizacaoincompleta_3` (`idProvincia`),\n" +
                "  KEY `FK_localizacaoincompleta_4` (`idRegiao`),\n" +
                "  CONSTRAINT `FK_localizacaoincompleta_1` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_localizacaoincompleta_3` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`),\n" +
                "  CONSTRAINT `FK_localizacaoincompleta_4` FOREIGN KEY (`idRegiao`) REFERENCES `regiao` (`idRegiao`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `metododepreservacao`;\n" +
                "CREATE TABLE `metododepreservacao` (\n" +
                "  `idMetodoDePreservacao` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Metodo` varchar(100) NOT NULL DEFAULT '',\n" +
                "  PRIMARY KEY (`idMetodoDePreservacao`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;"
        );
        sql.append("DROP TABLE IF EXISTS `ordem`;\n" +
                "CREATE TABLE `ordem` (\n" +
                "  `idOrdem` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Ordem` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idClasse` int(10) unsigned DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idOrdem`),\n" +
                "  KEY `FK_Ordem_1` (`idClasse`),\n" +
                "  CONSTRAINT `FK_Ordem_1` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`idClasse`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `pessoa`;\n" +
                "CREATE TABLE `pessoa` (\n" +
                "  `idPessoa` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Nome` varchar(45) NOT NULL DEFAULT '',\n" +
                "  PRIMARY KEY (`idPessoa`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `preservacaoespecie`;\n" +
                "CREATE TABLE `preservacaoespecie` (\n" +
                "  `idPreservacaoEspecie` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `idMetodoDePreservacao` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  `idEspecie` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idPreservacaoEspecie`),\n" +
                "  KEY `FK_PreservacaoEspecie_1` (`idMetodoDePreservacao`),\n" +
                "  KEY `FK_preservacaoespecie_2` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_PreservacaoEspecie_1` FOREIGN KEY (`idMetodoDePreservacao`) REFERENCES `metododepreservacao` (`idMetodoDePreservacao`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `FK_preservacaoespecie_2` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `provincia`;\n" +
                "CREATE TABLE `provincia` (\n" +
                "  `idProvincia` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Provincia` varchar(45) NOT NULL DEFAULT '',\n" +
                "  `idRegiao` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idProvincia`),\n" +
                "  KEY `FK_Provincia_1` (`idRegiao`),\n" +
                "  CONSTRAINT `FK_Provincia_1` FOREIGN KEY (`idRegiao`) REFERENCES `regiao` (`idRegiao`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;\n"
        );

        sql.append("DROP TABLE IF EXISTS `quemencontrou`;\n" +
                "CREATE TABLE `quemencontrou` (\n" +
                "  `idPessoa` int(11) unsigned NOT NULL,\n" +
                "  `idEspecie` int(11) unsigned NOT NULL,\n" +
                "  PRIMARY KEY (`idPessoa`,`idEspecie`),\n" +
                "  KEY `fk_quemencontrou_2_idx` (`idEspecie`),\n" +
                "  CONSTRAINT `fk_quemencontrou_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_quemencontrou_2` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
        );
        sql.append("DROP TABLE IF EXISTS `quemidentificou`;\n" +
                "CREATE TABLE `quemidentificou` (\n" +
                "  `idPessoa` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  `idEspecie` int(10) unsigned NOT NULL DEFAULT '0',\n" +
                "  PRIMARY KEY (`idPessoa`,`idEspecie`),\n" +
                "  KEY `FK_QuemIdentificou_2` (`idEspecie`),\n" +
                "  CONSTRAINT `FK_QuemIdentificou_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `FK_QuemIdentificou_2` FOREIGN KEY (`idEspecie`) REFERENCES `especie` (`idEspecie`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
        );
        sql.append("DROP TABLE IF EXISTS `regiao`;\n" +
                "CREATE TABLE `regiao` (\n" +
                "  `idRegiao` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Regiao` varchar(45) NOT NULL DEFAULT '',\n" +
                "  PRIMARY KEY (`idRegiao`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `reino`;\n" +
                "CREATE TABLE `reino` (\n" +
                "  `idReino` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "  `Reino` varchar(45) NOT NULL DEFAULT '',\n" +
                "  PRIMARY KEY (`idReino`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS tipoutilizador;\n" +
                "CREATE TABLE tipoutilizador (\n" +
                "  idtipoutilizador int(11) NOT NULL,\n" +
                "  tipoutilizador varchar(1000) DEFAULT NULL,\n" +
                "  PRIMARY KEY (idtipoutilizador)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
        );
        sql.append("DROP TABLE IF EXISTS `utilizador`;\n" +
                "CREATE TABLE `utilizador` (\n" +
                "  `idUtilizador` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `email` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `Senha` varchar(255) NOT NULL DEFAULT '',\n" +
                "  `idtipoutilizador` int(11) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idUtilizador`),\n" +
                "  KEY `fk_utilizador_1_idx` (`idtipoutilizador`),\n" +
                "  CONSTRAINT `fk_utilizador_1` FOREIGN KEY (`idtipoutilizador`) REFERENCES `tipoutilizador` (`idtipoutilizador`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;"
        );
        sql.append("INSERT INTO tipoutilizador VALUES ('7', '$pbkdf2-sha512$25000$/n9P6f1f690bgzCm1PofIw$wzTxvm5GWVHWRcgk7f4iZnJGt9Pkd7yAJ4HSIsZnqwOand98.gdf.xRqzqnOcZN8h0n.k1Enx2tcXO8r7qO3sg');\n" +
                "INSERT INTO tipoutilizador VALUES ('19', '$pbkdf2-sha512$25000$K.W8t9Y6xzgnZOx9zxkDwA$v.palSK9MP5/Uq6gu3LfIk9Pj984VQ4TRiSw6Yq4YJMCqDGvSI4RIRaDf10nJho/Jl2GqMhKJJ4.8pPgVC/CmQ');\n" +
                "INSERT INTO tipoutilizador VALUES ('2016', '$pbkdf2-sha512$25000$oLQWYqyVMgZAKCUkxJhTSg$JdDWQ7hgQtBk4QAB0z0RHgTd/eD6g.SAsj18RCjC2ghy4cvc9973e1pp0me6Elvv/G67iqgaf/xwjVxEDSt4kw');\n"
        );


        return sql.toString();
    }
}
