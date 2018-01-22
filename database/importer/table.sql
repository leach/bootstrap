CREATE TABLE `qq` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`num`  int(10) NOT NULL ,
`a`  varchar(255) NULL ,
`b`  varchar(255) NULL ,
`c`  varchar(255) NULL ,
`d`  varchar(255) NULL ,
`e`  varchar(255) NULL ,
`f`  varchar(255) NULL ,
`g`  varchar(255) NULL ,
`pool`  bigint NULL ,
`first`  bigint NULL ,
`first_count`  bigint NULL ,
`second`  bigint NULL ,
`second_count`  bigint NULL ,
`total`  bigint NULL ,
`open_date`  datetime NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `qq_num_index` (`num`)
)
;

