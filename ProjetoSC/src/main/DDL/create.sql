CREATE SCHEMA `projetoSC`;

CREATE TABLE `projetoSC`.`Categoria` (
  `nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`));


CREATE TABLE `projetoSC`.`Estande` (
  `idEstande` INT NOT NULL,
  `estandeArea` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstande`),
  CONSTRAINT `estandeArea`
    FOREIGN KEY (`estandeArea`)
    REFERENCES `projetoSC`.`Categoria` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `projetoSC`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`));


CREATE TABLE `projetoSC`.`Expositor` (
  `idExpositor` INT NOT NULL,
  `idEstande_Expositor` INT NOT NULL,
  PRIMARY KEY (`idExpositor`),
  CONSTRAINT `idExpositor_Usuario`
    FOREIGN KEY (`idExpositor`)
    REFERENCES `projetoSC`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idEstande_Expositor`
    FOREIGN KEY (`idExpositor`)
    REFERENCES `projetoSC`.`Estande` (`idEstande`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	

CREATE TABLE `projetoSC`.`Visitante` (
  `idVisitante` INT NOT NULL,
  PRIMARY KEY (`idVisitante`),
  CONSTRAINT `idVisitante_Usuario`
    FOREIGN KEY (`idVisitante`)
    REFERENCES `projetoSC`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `projetoSC`.`Palestras` (
  `idPalestras_Usuario` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idPalestras_Usuario`),
  CONSTRAINT `idPalestras_Usuario`
    FOREIGN KEY (`idPalestras_Usuario`)
    REFERENCES `projetoSC`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `projetoSC`.`Apresentador` (
  `idAprensentador_Usuario` INT NOT NULL,
  PRIMARY KEY (`idAprensentador_Usuario`),
  CONSTRAINT `idApresentador_Usuario`
    FOREIGN KEY (`idAprensentador_Usuario`)
    REFERENCES `projetoSC`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


