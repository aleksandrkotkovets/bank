-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`t_admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_admin` (
  `F_ID` INT(5) NOT NULL DEFAULT '1',
  `F_SCALE` INT(5) NOT NULL,
  PRIMARY KEY (`F_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_client` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_NAME` VARCHAR(20) NOT NULL,
  `F_SURNAME` VARCHAR(20) NOT NULL,
  `F_PASSPORT` VARCHAR(11) NOT NULL,
  `F_ID_USER_FK` INT(5) NOT NULL,
  PRIMARY KEY (`F_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_credit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_credit` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_TERM` VARCHAR(40) NOT NULL,
  `F_PERCENT` VARCHAR(5) NOT NULL,
  `F_SUM` VARCHAR(10) NOT NULL,
  `F_CREDITTYPE_ID_FK` INT(5) NOT NULL,
  `F_ASSESSMENT` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`F_ID`),
  INDEX `F_CREDITTYPE_ID_FK_idx` (`F_CREDITTYPE_ID_FK` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_credittype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_credittype` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_TYPENAME` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`F_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_expert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_expert` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_NAME` VARCHAR(20) NOT NULL,
  `F_SURNAME` VARCHAR(20) NOT NULL,
  `F_ID_USER_FK` INT(5) NOT NULL,
  `F_ASSESSMENTS` VARCHAR(60) NOT NULL DEFAULT 'Нет',
  `F_SUMMASSESSMENTS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`F_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 61
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_user` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_USERNAME` VARCHAR(10) NOT NULL,
  `F_PASSWORD` VARCHAR(10) NOT NULL,
  `F_ROLE` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`F_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 123
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`t_worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`t_worker` (
  `F_ID` INT(5) NOT NULL AUTO_INCREMENT,
  `F_NAME` VARCHAR(20) NOT NULL,
  `F_SURNAME` VARCHAR(20) NOT NULL,
  `F_SALARY` INT(10) NOT NULL,
  `F_PATRONYMIC` VARCHAR(20) NOT NULL,
  `F_ID_USER_FK` INT(5) NOT NULL,
  PRIMARY KEY (`F_ID`),
  INDEX `F_ID_USER_FK_idx` (`F_ID_USER_FK` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
