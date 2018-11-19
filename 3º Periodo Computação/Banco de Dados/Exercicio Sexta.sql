-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'Inscricao'
-- 
-- ---

DROP TABLE IF EXISTS `Inscricao`;
		
CREATE TABLE `Inscricao` (
  `CodAluno` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `Nome` VARCHAR NULL DEFAULT NULL,
  `telefone` ENUM NULL DEFAULT NULL,
  `AnoAdmissao` INTEGER NULL DEFAULT NULL,
  `CodDisc` INTEGER NULL DEFAULT NULL,
  `DataMat` INTEGER NULL DEFAULT NULL,
  `Nomecurso` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`CodAluno`)
);

-- ---
-- Table 'Telefone'
-- 
-- ---

DROP TABLE IF EXISTS `Telefone`;
		
CREATE TABLE `Telefone` (
  `CodAluno` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `Telefone` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`CodAluno`)
);

-- ---
-- Table 'Disciplina'
-- 
-- ---

DROP TABLE IF EXISTS `Disciplina`;
		
CREATE TABLE `Disciplina` (
  `CodDisc` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `NomeDisc` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`CodDisc`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `Inscricao` ADD FOREIGN KEY (CodAluno) REFERENCES `Telefone` (`CodAluno`);
ALTER TABLE `Inscricao` ADD FOREIGN KEY (CodDisc) REFERENCES `Disciplina` (`CodDisc`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `Inscricao` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Telefone` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Disciplina` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `Inscricao` (`CodAluno`,`Nome`,`telefone`,`AnoAdmissao`,`CodDisc`,`DataMat`,`Nomecurso`) VALUES
-- ('','','','','','','');
-- INSERT INTO `Telefone` (`CodAluno`,`Telefone`) VALUES
-- ('','');
-- INSERT INTO `Disciplina` (`CodDisc`,`NomeDisc`) VALUES
-- ('','');