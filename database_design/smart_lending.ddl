
-- -----------------------------------------------------
-- Schema smart_lending
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `smart_lending` ;

-- -----------------------------------------------------
-- Schema smart_lending
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smart_lending` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `smart_lending`.`currency_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`currency_table` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`currency_table` (
                                                                `currency_code` CHAR(3) NOT NULL,
                                                                `decimal_point` TINYINT(1) NOT NULL,
                                                                `exchange_rate` DECIMAL(11) NULL,
                                                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                PRIMARY KEY (`currency_code`))
    ENGINE = InnoDB
    COMMENT = 'Currency Table';

CREATE UNIQUE INDEX `udx_currency_table` ON `smart_lending`.`currency_table` (`currency_code` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `smart_lending`.`customer_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`customer_info` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`customer_info` (
                                                               `customer_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                                               `customer_name` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
                                                               `gender` TINYINT(1) NULL DEFAULT NULL,
                                                               `date_of_birth` DATE NULL DEFAULT NULL,
                                                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                               PRIMARY KEY (`customer_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8
    COMMENT = 'Customer master';

CREATE UNIQUE INDEX `udx_customer_info` ON `smart_lending`.`customer_info` (`customer_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `smart_lending`.`customer_limit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`customer_limit` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`customer_limit` (
                                                                `limit_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                `customer_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                `limit_type` CHAR(3) NOT NULL,
                                                                `limit_category` CHAR(1) NULL DEFAULT 'A',
                                                                `original_limit` BIGINT(18) UNSIGNED NOT NULL,
                                                                `current_limit` BIGINT(18) UNSIGNED NOT NULL,
                                                                `control_limit_id` BIGINT(20) NOT NULL,
                                                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                PRIMARY KEY (`limit_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8
    COMMENT = 'Customer Limit';

CREATE UNIQUE INDEX `udx_customer_limit` ON `smart_lending`.`customer_limit` (`limit_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `smart_lending`.`customer_maping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`customer_mapping` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`customer_mapping` (
                                                                  `customer_id` BIGINT(20) UNSIGNED NOT NULL COMMENT 'Customer ID ',
                                                                  `system_code` VARCHAR(3) NOT NULL COMMENT 'Banking System Code',
                                                                  `ext_customer_num` CHAR(25) NOT NULL,
                                                                  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                  PRIMARY KEY (`customer_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_customer_mapping` ON `smart_lending`.`customer_mapping` (`customer_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `smart_lending`.`holiday_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`holiday_table` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`holiday_table` (
                                                               `country_code` CHAR(2) NOT NULL,
                                                               `holiday_area` CHAR(3) NOT NULL,
                                                               `year_month` INT(6) NOT NULL,
                                                               `holiday_detail` CHAR(31) NOT NULL COMMENT 'WWWWWWWWWWWWWWWWWWWWWWWWWWHWWWW\\nW- mean working date\\nH- mean holiday',
                                                               `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
                                                               `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                               PRIMARY KEY (`country_code`, `holiday_area`, `year_month`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COMMENT = 'holiday table';

CREATE UNIQUE INDEX `udx_holiday_table` ON `smart_lending`.`holiday_table` (`country_code` ASC, `holiday_area` ASC, `year_month` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `smart_lending`.`loan_account_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_account_info` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_account_info` (
                                                                   `loan_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                   `customer_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                   `limit_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                   `product_id` CHAR(3) NOT NULL,
                                                                   `currency` CHAR(3) NOT NULL,
                                                                   `status` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '1 - active\\n4 - closing\\n5 - closed',
                                                                   `open_date` DATE NOT NULL,
                                                                   `due_date` DATE NOT NULL,
                                                                   `balance` BIGINT(18) NOT NULL,
                                                                   `loan_term` INT(3) NOT NULL,
                                                                   `loan_term_unit` CHAR(1) NOT NULL COMMENT 'M - month\\nY - years',
                                                                   `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                   `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                   PRIMARY KEY (`loan_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_loan_account_info` ON `smart_lending`.`loan_account_info` (`loan_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `smart_lending`.`loan_interest_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_interest_info` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_interest_info` (
                                                                    `loan_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                    `last_interest_calculation_date` DATE NOT NULL,
                                                                    `debit_interest-rate` DECIMAL(11,8) NOT NULL,
                                                                    `calculation_end_date` DATE NOT NULL,
                                                                    `balance_for_interest_calculation` BIGINT(18) NOT NULL,
                                                                    `interest_accruals` BIGINT(18) NOT NULL,
                                                                    `interest_collected` BIGINT(18) UNSIGNED NOT NULL,
                                                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                    PRIMARY KEY (`loan_id`,`calculation_end_date`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_loan_interest_info` ON `smart_lending`.`loan_interest_info` (`loan_id` ASC, `calculation_end_date` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `smart_lending`.`loan_penalty_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_penalty_info` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_penalty_info` (
                                                                   `loan_id` BIGINT(20) NOT NULL,
                                                                   `last_interest_calculation_date` DATE NOT NULL,
                                                                   `debit_interest-rate` DECIMAL(11,8) NOT NULL,
                                                                   `calculation_end_date` DATE NOT NULL,
                                                                   `overdue_balance_for_interest_calculation` BIGINT(18) NOT NULL,
                                                                   `overdue_interest_accruals` BIGINT(18) UNSIGNED NOT NULL,
                                                                   `overdue_interest_collected` BIGINT(18) NOT NULL,
                                                                   `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                   `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                   PRIMARY KEY (`loan_id`,`calculation_end_date`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;
CREATE UNIQUE INDEX `udx_loan_penalty_info` ON `smart_lending`.`loan_penalty_info` (`loan_id` ASC, `calculation_end_date` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `smart_lending`.`loan_product_control`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_product_control` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_product_control` (
                                                                      `product_id` CHAR(3) NOT NULL,
                                                                      `product_description` CHAR(30) NOT NULL,
                                                                      `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                      `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                      PRIMARY KEY (`product_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_loan_product_control` ON `smart_lending`.`loan_product_control` (`product_id` ASC);


-- -----------------------------------------------------
-- Table `smart_lending`.`loan_repayment_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_repayment_history` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_repayment_history` (
                                                                        `loan_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                        `instalment_due_date` DATE NOT NULL,
                                                                        `instalment_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `instalment_amount_paid` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `principal_portion` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `interst_portion` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `principal_portion_paid` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `interst_portion_paid` BIGINT(18) UNSIGNED NOT NULL,
                                                                        `instalment_status` CHAR(1) NOT NULL,
                                                                        `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                        `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                        PRIMARY KEY (`loan_id`,`instalment_due_date`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_repayment_history` ON `smart_lending`.`loan_repayment_history` (`loan_id` ASC, `instalment_due_date` ASC);

-- -----------------------------------------------------
-- Table `smart_lending`.`loan_scheduler_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_scheduler_info` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_scheduler_info` (
                                                                     `loan_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                     `start_date` DATE NOT NULL,
                                                                     `repayment_scheme` CHAR(3) NOT NULL,
                                                                     `debit_interest_rate` DECIMAL(11,8) UNSIGNED NOT NULL,
                                                                     `next_instalment_date` DATE NOT NULL,
                                                                     `next_instalment_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                     `next_interest_application_date` DATE NOT NULL,
                                                                     `instalment_frequency` CHAR(1) NOT NULL,
                                                                     `interest_application_frequency` CHAR(1) NOT NULL,
                                                                     `next_interest_review_date` DATE NOT NULL,
                                                                     `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                     `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                     PRIMARY KEY (`loan_id`, `start_date`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_loan_scheduler_info` ON `smart_lending`.`loan_scheduler_info` (`loan_id` ASC,  `start_date` ASC) VISIBLE;

-- -----------------------------------------------------
-- Table `smart_lending`.`loan_transaction_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `smart_lending`.`loan_transaction_history` ;

CREATE TABLE IF NOT EXISTS `smart_lending`.`loan_transaction_history` (
                                                                          `deal_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
                                                                          `transaction_date` DATE NOT NULL,
                                                                          `loan_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                          `repayment_account_id` BIGINT(20) UNSIGNED NOT NULL,
                                                                          `currency` CHAR(3) NOT NULL,
                                                                          `transaction_amout` BIGINT(18) UNSIGNED NOT NULL,
                                                                          `local_currency_transaction_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                          `exchange_rate` DECIMAL(11,8) NOT NULL,
                                                                          `narrative` VARCHAR(50) NOT NULL,
                                                                          `principal_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                          `interest_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                          `overdue_penalty_amount` BIGINT(18) UNSIGNED NOT NULL,
                                                                          `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                                          `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                                                          PRIMARY KEY (`deal_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `udx_loan_transaction_history` ON `smart_lending`.`loan_transaction_history` (`deal_id` ASC) VISIBLE;
