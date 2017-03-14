-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `pay` DEFAULT CHARACTER SET utf8 ;
USE `pay` ;

-- -----------------------------------------------------
-- Table `pay`.`pay_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pay`.`pay_order` (
  `pay_order_id` VARCHAR(45) NOT NULL COMMENT '支付订单号',
  `app_id` VARCHAR(45) NOT NULL COMMENT '应用ID',
  `order_id` VARCHAR(100) NOT NULL COMMENT '业务订单号',
  `amount` INT NOT NULL COMMENT '订单金额，单位分',
  `order_name` VARCHAR(45) NOT NULL COMMENT '订单名称',
  `order_content` VARCHAR(300) NOT NULL COMMENT '订单详情',
  `order_create_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '业务订单创建时间',
  `order_submit_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '业务订单送单时间',
  `return_url` VARCHAR(300) NULL COMMENT '支付返回url',
  `user_id` VARCHAR(45) NOT NULL COMMENT '订单用户ID',
  `mer_code` VARCHAR(45) NULL COMMENT '商户主体编号，用于支付时直接进账到分校区财务帐号',
  `attach` VARCHAR(255) NULL COMMENT '附加数据，在查询接口和状态通知中原样返回',
  `pay_status` INT NOT NULL DEFAULT 0 COMMENT '支付状态，0：待支付，1：支付成功',
  `pay_suc_count` INT NOT NULL DEFAULT 0 COMMENT '成功支付的次数',
  `first_suc_trx_id` VARCHAR(45) NULL COMMENT '最先成功支付的交易流水号',
  `first_suc_channel_id` VARCHAR(45) NULL COMMENT '最先成功支付的支付渠道ID',
  `first_suc_notify_time` TIMESTAMP(3) NULL COMMENT '最先成功支付的支付渠道通知时间',
  `app_notify_status` INT NOT NULL DEFAULT 0 COMMENT '应用端支付状态通知的结果，0：未通知，1：已通知',
  `app_notify_time` TIMESTAMP(3) NULL COMMENT '应用端支付状态成功通知的时间戳',
  `create_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '支付订单创建时间',
  `update_time` TIMESTAMP(3) NULL ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '支付订单更新时间',
  PRIMARY KEY (`pay_order_id`),
  UNIQUE INDEX `udx_appid_orderid` (`app_id` ASC, `order_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '支付订单表';

-- -----------------------------------------------------
-- Table `pay`.`notify_replay`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pay`.`notify_replay` (
  `pay_order_id` VARCHAR(45) NOT NULL,
  `app_id` VARCHAR(45) NOT NULL COMMENT '应用ID',
  `notify_count` INT NULL COMMENT '通知次数',
  `last_try_time` TIMESTAMP(3) NULL COMMENT '最后一次尝试通知的时间',
  `create_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `update_time` TIMESTAMP(3) NULL ON UPDATE CURRENT_TIMESTAMP(3),
  `full_notify_url` VARCHAR(1024) NOT NULL COMMENT '用于通知回放的全参数Url',
  PRIMARY KEY (`pay_order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '同步状态通知失败需再次尝试的订单';
