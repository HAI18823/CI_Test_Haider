INSERT INTO `spengermed`.`greeting` (`id`, `content`) VALUES ('1', 'Greet you');
INSERT INTO `spengermed`.`greeting` (`id`, `content`) VALUES ('2', 'Greet me');
INSERT INTO `spengermed`.`greeting` (`id`, `content`) VALUES ('3', 'Greet forever');

INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_deceaseddatetime`, `p_deceasedboolean`, `p_gender`) VALUES ('asdf',1, '2000-01-01', '2010-01-01', 1, 'male');
INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`,`p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('gjuerighirgh', 1,'2000-01-01','unknown', 1);
INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`,`p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('7439re', 0, '2001-04-05','male', 0);
INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('frejifgreu89', 1, '2010-01-21','female', 1);
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('n1','Mustermann', '2099-12-31', '2000-01-01', 'blabla', 'usual','7439re');
INSERT INTO `spengermed`.`a_adress` (`id`, `a_city`, `a_country`,`a_district`, `pp_end`, `pp_start`, `a_postalcode`, `a_state`, `a_p_id`)VALUES ('addr1', 'Orasje', 'BiH', 'Orase', '2099-12-31 16:36:34.000000','2020-04-27 16:36:49.000000', '1111', 'BiH', '7439re');

INSERT INTO `spengermed`.`pr_pradictioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('lol', 1, '2003-02-01', 'female');
INSERT INTO `spengermed`.`pr_pradictioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('hejrlt', 1, '2005-03-08', 'male');
INSERT INTO `spengermed`.`pr_pradictioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('lenhjd', 1, '1972-05-19', 'unknown');
INSERT INTO `spengermed`.`pr_pradictioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('oekhroekhr', 1, '1963-06-03', 'male');
INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `at_pr_id`) VALUES ('jhhdadl', '2021-01-13', 'sdd', 'fdsf', 'deat', 14, 'lololol', 'http:spengergasse.at', 'lol');
INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `at_pr_id`) VALUES ('klojj', '2021-02-01', 'sdd', 'fdsf', 'deat', 16, 'lololol', 'http:spengergasse.at', 'hejrlt');
INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `at_pr_id`) VALUES ('bdjne', '2020-12-11', 'sdc', 'ndnf', 'deat', 15, 'lololol', 'http:spengergasse.at', 'lenhjd');
INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `at_pr_id`) VALUES ('hdnje', '2020-12-21', 'sdc', 'ndnf', 'deat', 17, 'lololol', 'http:spengergasse.at', 'oekhroekhr');


INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('as', 12, '2020-02-01', '2050-01-04', '2020-12-01', 'unknown');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('ezr', 'temp', '2055-12-31', '2019-12-31', 'blabla', 'HAllo', 'as');

INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('klo', 12, '2018-03-02', '2040-10-14', '2020-08-10', 'stopped');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('hjhd', 'usual', '2021-12-31', '2010-10-21', 'bliblablub', 'Tschau', 'klo');


INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('Flasche', 12, '2009-03-02', '2040-11-17', '2021-09-18', 'onhold');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('cola', 'official', '2021-11-01', '2001-01-01', 'spongebob', 'Tschau', 'Flasche');
