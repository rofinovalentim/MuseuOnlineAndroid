--
-- File generated with SQLiteStudio v3.2.1 on Wed Jul 24 17:25:50 2019
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: cadastroPedido
CREATE TABLE `cadastroPedido` (`idcadastroPedido`, `email`, `password`);
INSERT INTO cadastroPedido (idcadastroPedido, email, password) VALUES ('1', 'm@gmial.com', '$pbkdf2-sha512$25000$jrHWeo/RWotxLoXQGmNsbQ$LJAFmf.WzY9eNxqA2vhyj2qEXxcxfu7XmMXpdkPQHjkoKKyW9BQpKKRWlA8cP3/cjKJZD/IOgzcpPwYcod0/5Q');

-- Table: classe
CREATE TABLE `classe` (`idClasse`, `Classe`, `idFilo`);
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('11', 'Entognatha', '17');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('12', 'Insecta', '17');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('13', 'Agaricomycetes', '8');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('14', 'Actinopterygii', '19');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('15', 'Malacostraca', '17');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('16', 'Diplopoda', '17');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('17', 'Glomeromycetes', '9');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('19', 'Dothideomycetes', '7');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('20', 'Arachnida', '17');
INSERT INTO classe (idClasse, Classe, idFilo) VALUES ('21', 'Sordariomycetes', '7');

-- Table: distrito
CREATE TABLE `distrito` (`idDistrito`, `Distrito`, `idProvincia`);
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('4', 'Cidade de Pemba', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('5', 'Ancuabe', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('6', 'Balama', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('7', 'ChiÃºre', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('8', 'Ibo', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('9', 'Macomia', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('10', 'MecÃºfi', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('11', 'Meluco', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('12', 'Mocimboa da Praia', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('13', 'Montepuez', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('14', 'Mueda', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('15', 'Muidumbe', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('16', 'Namuno', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('17', 'Nangade', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('18', 'Palma', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('19', 'Pemba-Metuge', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('20', 'Quissanga', '1');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('21', 'Distrito Urbano Nr 1', '10');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('22', 'Distrito Urbano Nr 2', '10');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('23', 'Distrito Urbano Nr 3', '10');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('24', 'Distrito Urbano Nr 4', '10');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('25', 'Distrito Urbano Nr 5', '10');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('26', 'Cidade de Xai-Xai', '8');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('27', 'Bilene Macia', '8');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('28', 'Chibuto', '8');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('29', 'Chicualacuala', '8');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('30', 'Chigubo', '8');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('31', 'Cidade de Inhanbane', '9');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('32', 'Funhalouro', '9');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('33', 'HomoÃ­ne', '9');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('34', 'Inharrime', '9');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('35', 'Cidade de Chimoio', '6');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('36', 'Gondola', '6');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('37', 'Guro', '6');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('38', 'Manica', '6');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('39', 'Tambara', '6');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('40', 'Cidade de Matola', '11');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('41', 'Boane', '11');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('42', 'Magude', '11');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('43', 'Cidade de Nampula', '3');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('44', 'Angoche', '3');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('45', 'Ilha de MoÃ§ambique', '3');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('46', 'Cidade de Lichinga', '2');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('47', 'Cuamba', '2');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('48', 'Lago', '2');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('49', 'Lichinga', '2');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('50', 'Sanga', '2');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('51', 'Cidade da Beira', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('52', 'Caia', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('53', 'Chemba', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('54', 'Dondo', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('55', 'Gorongosa', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('56', 'Muchanga', '7');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('57', 'Desconhecida', '4');
INSERT INTO distrito (idDistrito, Distrito, idProvincia) VALUES ('58', 'desconhecido', '4');

-- Table: especie
CREATE TABLE `especie` (`idEspecie`, `Especie`, `idGenero`, `Habitat`, `Coordenadas`, `Notas`, `detalhes`, `NomeComum`, `Codigo`, `Validacao`, `DataCriacao`);
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('12', 'peixe', '1', 'nampula', '32-565', '17', 'electrecista', 'peixe', '4365', '23', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('13', 'tartaruga', '1', 'lichinga', '243-55', '17', 'estudante', 'tartaruga', '2354', '3', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('14', 'neldo', '1', 'nampula', '243-55', '17', 'estudante', 'guerzeneldo', '4365', '23', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('15', 'mario', '5', 'lichinga', '243-55', '17', 'estudante', 'rafath', '4365', '3', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('16', 'lagarto', '1', 'pemba', '32-565', '17', 'marinho', 'lagarto', '4365', '3', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('17', 'helena', '1', 'nampula', '243-55', '17', 'estudante', 'rafath', '2354', '', '2018-11-04');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('18', 'aracnideos', '5', 'pemba', '32-65', '54', '
true', 'aracnideos', '5689', 'true', '2018-12-08');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('19', 'binha', '1', 'pemba', '243-55', '17', 'amiga', 'amiga', '2354', '23', '2018-12-08');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('22', 'sapo', '1', 'pemba', '243-55', '54', 'pedagogico', 'sapo', '4365', 'true', '2018-12-09');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('23', 'peixe', '1', 'pemba', '32-65', '17', 'real', 'peixe', '5689', 'true', '2018-12-09');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('24', 'tartaruga', '1', 'pemba', 'dsds', 'ds', 'ds
        ', 'tartaruga', 'dsd', 'dsd', '2018-12-09');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('27', 'aidojk', '1', 'nampula', '243-55', '54', 'ggh
        ', 'rafath', 'dsd', 'true', '2018-12-10');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('33', 'awa', '3', 'pemba', 'dsds', '54', 'yyy
        ', 'lawita', 'bc7d2ce007604057a38b3b8f4edc3b45', 'true', '2018-12-12');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('34', 'lagarto', '1', 'pemba', '32-65', '54', 'qwq
        ', 'lagarto', '08205154444543c981a17bbd3f43a203', 'true', '2018-12-12');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('35', 'rato', '1', 'pemba', 'dsds', 'ds', 'fgf
        ', 'rato', '80da5f73f78d4cc3b87b9f3234d3444a', 'true', '2018-12-13');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('36', 'aracnideos', '1', 'murrupula', '121', '32', 'vive muito longe
        ', 'aracnideos', '3086dd1f513a41358ea73045c0fb9044', '12/32', '2018-12-24');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('37', 'aranha', '1', 'murrupula', '121', '32', 'vive muito longe
        ', 'aranha', '728398960165400e822cb256c0f4a7db', '12/32', '2018-12-24');
INSERT INTO especie (idEspecie, Especie, idGenero, Habitat, Coordenadas, Notas, detalhes, NomeComum, Codigo, Validacao, DataCriacao) VALUES ('38', '', '1', '', '', '', '
        ', '', 'f2cea01081da40af8275e027345aedc2', '', '2019-04-18');

-- Table: especieImagem
CREATE TABLE `especieImagem` (`idImagem`, `imagem`, `idEspecie`);

-- Table: especieincompleta
CREATE TABLE `especieincompleta` (`idEspecie`, `idFamilia`, `idOrdem`, `idClasse`, `idFilo`, `idReino`);

-- Table: especieSom
CREATE TABLE `especieSom` (`idSom`, `som`, `idEspecie`);

-- Table: especieVideo
CREATE TABLE `especieVideo` (`idVideo`, `video`, `idEspecie`);

-- Table: familia
CREATE TABLE `familia` (`idFamilia`, `Familia`, `idOrdem`);
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('2', 'Diplodia', '9');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('3', 'Acrididae', '2');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('4', 'Phoridae', '6');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('5', 'Dasytidae', '4');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('6', 'Aphididae', '10');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('7', 'Davidiellaceeae', '7');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('8', 'Carabidae', '4');
INSERT INTO familia (idFamilia, Familia, idOrdem) VALUES ('9', 'Tenebrionidae', '4');

-- Table: filo
CREATE TABLE `filo` (`idFilo`, `Filo`, `idReino`);
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('4', 'Ciliophora', '4');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('6', 'Rhizopoda', '4');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('7', 'Ascomycota', '3');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('8', 'Basidiomycota', '3');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('9', 'Glomeromycota', '3');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('10', 'Micospora', '3');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('11', 'Zygomycota', '3');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('12', 'Anthocerotophyta', '5');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('13', 'Bryophyta', '5');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('14', 'Charophyta', '5');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('15', 'Equisetophyta', '5');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('16', 'Annelida', '7');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('17', 'Arthropoda', '7');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('18', 'Brachiopoda', '7');
INSERT INTO filo (idFilo, Filo, idReino) VALUES ('19', 'Chordata', '7');

-- Table: genero
CREATE TABLE `genero` (`idGenero`, `Genero`, `idFamilia`);
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('1', 'Graellsinus', '5');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('2', 'Mauroania', '5');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('3', 'Oxynotus', '5');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('4', 'Acroconidiella', '7');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('5', 'Amara', '8');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('6', 'Acyrthosiphon', '6');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('7', 'Aplocnemus', '5');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('8', 'Alphasida', '9');
INSERT INTO genero (idGenero, Genero, idFamilia) VALUES ('15', 'mmmmmm', '3');

-- Table: localizacaoespecie
CREATE TABLE `localizacaoespecie` (`idLocalizacao`, `idDistrito`, `idEspecie`);
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('14', '57', '12');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('15', '57', '13');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('16', '57', '14');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('17', '57', '15');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('18', '57', '16');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('19', '57', '17');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('20', '57', '19');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('22', '57', '22');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('23', '57', '23');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('24', '57', '24');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('25', '57', '24');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('26', '57', '27');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('27', '57', '34');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('28', '57', '35');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('29', '57', '36');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('30', '57', '37');
INSERT INTO localizacaoespecie (idLocalizacao, idDistrito, idEspecie) VALUES ('31', '57', '38');

-- Table: localizacaoincompleta
CREATE TABLE `localizacaoincompleta` (`idEspecie`, `idProvincia`, `idRegiao`, `idLocalizacao`);

-- Table: metododepreservacao
CREATE TABLE `metododepreservacao` (`idMetodoDePreservacao`, `Metodo`);
INSERT INTO metododepreservacao (idMetodoDePreservacao, Metodo) VALUES ('1', 'secagem');
INSERT INTO metododepreservacao (idMetodoDePreservacao, Metodo) VALUES ('2', 'neldo');
INSERT INTO metododepreservacao (idMetodoDePreservacao, Metodo) VALUES ('3', 'Anonimo');
INSERT INTO metododepreservacao (idMetodoDePreservacao, Metodo) VALUES ('4', 'Desconhecido');

-- Table: ordem
CREATE TABLE `ordem` (`idOrdem`, `Ordem`, `idClasse`);
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('2', 'Orthoptera', '12');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('3', 'Lepidoptera', '12');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('4', 'Coleoptera', '12');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('5', 'Decapoda', '15');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('6', 'Diptera', '12');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('7', 'Capnodiales', '19');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('8', 'Pleosporales', '19');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('9', 'Botryosphaeriales', '19');
INSERT INTO ordem (idOrdem, Ordem, idClasse) VALUES ('10', 'Hemiptera', '12');

-- Table: pessoa
CREATE TABLE `pessoa` (`idPessoa`, `Nome`);
INSERT INTO pessoa (idPessoa, Nome) VALUES ('32', 'Anonimo');

-- Table: preservacaoespecie
CREATE TABLE `preservacaoespecie` (`idPreservacaoEspecie`, `idMetodoDePreservacao`, `idEspecie`);
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('14', '4', '12');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('15', '4', '13');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('16', '4', '14');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('17', '4', '15');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('18', '4', '16');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('19', '4', '17');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('20', '4', '19');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('22', '4', '22');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('23', '4', '23');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('24', '4', '24');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('25', '4', '24');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('26', '4', '27');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('27', '4', '34');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('28', '4', '35');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('29', '4', '36');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('30', '4', '37');
INSERT INTO preservacaoespecie (idPreservacaoEspecie, idMetodoDePreservacao, idEspecie) VALUES ('31', '4', '38');

-- Table: provincia
CREATE TABLE `provincia` (`idProvincia`, `Provincia`, `idRegiao`);
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('1', 'Cabo Delgado', '1');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('2', 'Niassa', '1');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('3', 'Nampula', '1');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('4', 'ZambÃ©zia', '2');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('5', 'Tete', '2');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('6', 'Manica', '2');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('7', 'Sofala', '2');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('8', 'Gaza', '3');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('9', 'Inhambane', '3');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('10', 'Maputo Cidade', '3');
INSERT INTO provincia (idProvincia, Provincia, idRegiao) VALUES ('11', 'Maputo Provincia', '3');

-- Table: quemencontrou
CREATE TABLE `quemencontrou` (`idPessoa`, `idEspecie`);

-- Table: quemidentificou
CREATE TABLE `quemidentificou` (`idPessoa`, `idEspecie`);
INSERT INTO quemidentificou (idPessoa, idEspecie) VALUES ('32', '23');
INSERT INTO quemidentificou (idPessoa, idEspecie) VALUES ('32', '24');

-- Table: regiao
CREATE TABLE `regiao` (`idRegiao`, `Regiao`);
INSERT INTO regiao (idRegiao, Regiao) VALUES ('1', 'Norte');
INSERT INTO regiao (idRegiao, Regiao) VALUES ('2', 'Centro');
INSERT INTO regiao (idRegiao, Regiao) VALUES ('3', 'Sul');

-- Table: reino
CREATE TABLE `reino` (`idReino`, `Reino`);
INSERT INTO reino (idReino, Reino) VALUES ('3', 'Fungi');
INSERT INTO reino (idReino, Reino) VALUES ('4', 'Protista');
INSERT INTO reino (idReino, Reino) VALUES ('5', 'Plantae');
INSERT INTO reino (idReino, Reino) VALUES ('6', 'Monera');
INSERT INTO reino (idReino, Reino) VALUES ('7', 'Animalia');
INSERT INTO reino (idReino, Reino) VALUES ('8', 'Fungire');

-- Table: tipoutilizador
CREATE TABLE `tipoutilizador` (`idtipoutilizador`, `tipoutilizador`);
INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES ('7', '$pbkdf2-sha512$25000$/n9P6f1f690bgzCm1PofIw$wzTxvm5GWVHWRcgk7f4iZnJGt9Pkd7yAJ4HSIsZnqwOand98.gdf.xRqzqnOcZN8h0n.k1Enx2tcXO8r7qO3sg');
INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES ('19', '$pbkdf2-sha512$25000$K.W8t9Y6xzgnZOx9zxkDwA$v.palSK9MP5/Uq6gu3LfIk9Pj984VQ4TRiSw6Yq4YJMCqDGvSI4RIRaDf10nJho/Jl2GqMhKJJ4.8pPgVC/CmQ');
INSERT INTO tipoutilizador (idtipoutilizador, tipoutilizador) VALUES ('2016', '$pbkdf2-sha512$25000$oLQWYqyVMgZAKCUkxJhTSg$JdDWQ7hgQtBk4QAB0z0RHgTd/eD6g.SAsj18RCjC2ghy4cvc9973e1pp0me6Elvv/G67iqgaf/xwjVxEDSt4kw');

-- Table: utilizador
CREATE TABLE `utilizador` (`idUtilizador`, `email`, `Senha`, `idtipoutilizador`);
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('6', 'malandro@gmail.com', '$pbkdf2-sha512$25000$VyoFYGxNCYGQshYCAABAKA$f212szqIpSN6F5cCnfIvhe1qbWq2oQr2GH0PymzwhU7yYEqO1ui9zLF5Y5OLc1nmeUHPlBFomvcp0HXnaNB2Yw', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('9', 'neldo@digio.com', '$pbkdf2-sha512$25000$rdU6h5ASotT6/z/nvNe61w$Vg1LOTqMr1.QqTa8SwDURTyWNBdqFBVT72KZkk4Oqq21BNvwo9H7s4XgjiiBgD1w1OunKT0ZQvm0Cl7nmDb7cg', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('10', 'm@gmail.com', '$pbkdf2-sha512$25000$cg6BMIZQqhUCAGBsDUEoJQ$Ga3504BQzS/mOhCqvnV1iq7KhoMM9xHhk5irVQC9cxwHeDMh2RuRAVSLlzDSdbQdaHRQy13jt5oUq9COUprqRw', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('11', 'o@digio.com', '$pbkdf2-sha512$25000$ttY6p5RyDgEAwDhn7N37nw$quhQma2zjO6WVmIgoB6ylBYI0E.EqpVqTR484R4mfX8iq3l5rCIvJNzWklArLu34Rvr9QBoA8VfTR8d6GwwKZA', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('12', 'p@digio.com', '$pbkdf2-sha512$25000$956ztjaG8F4LwdgbQwihlA$2mjELqDQX6lQH.pRq6xErZ.Y36qs7lBaOMbDRqBrSONqZdQbA.HbFrkGvTdv0NCDbNVUzwUToRc4u9BC7NjQ9Q', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('13', 'u@gmail.com', '$pbkdf2-sha512$25000$onRube0957w3hjDmXKsVAg$47BIw2KpqvB7wy5d1E7Js.0XhzPQm8nV.2Q3GZpw4/CLFZY6ym6V1k/ij5vvg8/.LSjsXQKYYckdoDmzrfcmbw', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('14', 'ty@gmail.com', '$pbkdf2-sha512$25000$I2SMEYKw1rq3llJqzbn3vg$lEuoTk//m4A8LoTzDkCHqPjIPm3vAqgOHhTj.8n9c57SFGyUUklkK.v8bZGbqApC20rc4jrTwtlmWXYJMvrvLQ', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('15', 'neret@digio.com', '$pbkdf2-sha512$25000$PoewlrJWqnVu7T2n9B4jhA$tqndnCbP8gz5Sck7Y3REtnhcRlYMkgJ0xseRBg9xeT.4Xuu/F8Ht.C3fjh36xVCqBrVsZmoNSkvxlg6vrgXQ0Q', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('16', 'rtttyt2@htomail.com', '$pbkdf2-sha512$25000$ce4dA6CU0lorpZRyDmFMCQ$.Y6Jx7A7nURoiQ71MMuYUVszz1U7iRzWHv/Xl0IyXS6NxRwgToKV/Uil5R.1CBXptS14Pqnmu/Qt/WILkaD0hg', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('17', 'dfdfdf@digio.com', '$pbkdf2-sha512$25000$tDaGEELIuTfmfO99T8nZWw$SWdlWSz3gFNui7DEQ5StA4dXAOLdkX7MO0TuwHgEUrih8f0ewlL9HG5yS/qNIpMSzpNWoWg5p6AsQRHbYkVXjQ', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('18', 'gtgt@digio.com', '$pbkdf2-sha512$25000$07rXuvceYyzF.B/jPOd8rw$GkBV4KiAPE0D9FCNuCO5amm9cghQA8vzGTD5LNMCyuB.rVK35caP8.Rq4xj.uGnCvqtaQHl3XGw.7rbe8mnXaw', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('19', 'fgf@digio.com', '$pbkdf2-sha512$25000$BsBYq/X.35tTijHm3FurdQ$2I0JJljmaOn5hq1JHai7cutYKBDs54NAWa2sNRgX.72Fod0ZpC03iEgCPmymQlOt9PWpTGbY2NlL.YjZYGqwXw', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('20', 'neldohjj2@digio.com', '$pbkdf2-sha512$25000$W0up1dpba.19b.3de.8dgw$ArIk2DOArT9vQ15.oYF0YgVlqS2NaQBTnnDzA3i3Zk.3/77JbVGRQqoG32WZUKzqqsQwwAWciPG9n81sASaa1g', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('21', 'sadio@gmail.com', '$pbkdf2-sha512$25000$PYcQYswZI4RQCkEIoXTuHQ$8pROvzIVBxSyL8hN8k6rUBPjnzCOEOuf7aeAc.MEgsjDCIHBTL8Fpd7OXGVUzVyM9VH/Ew1qr4qW53llHOUa1w', '7');
INSERT INTO utilizador (idUtilizador, email, Senha, idtipoutilizador) VALUES ('22', 'albert@gmail.com', '$pbkdf2-sha512$25000$idE6Z.w959ybE4KQ8v4/Rw$0wP/R0vNAUEbSQ0wn4PGyAHaZDiMJIwITtv219rXevSJ1gVA.BD5yqLsdswYHDgiz6uwYI3jHf9GDGIt1T4HMQ', '7');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
