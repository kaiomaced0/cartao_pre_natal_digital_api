
INSERT INTO `consulta` (`ativo`, `dataRealizada`, `consulta_mamae`, `dataInclusao`, `id`, `medico_consulta`, `peso`, `idadeGestacional`, `observacao`, `titulo`, `edema`, `mf`) VALUES
                                                                                                                                                                                    (b'1', '2023-12-04', 1, '2023-12-04 16:10:54.497124', 1, 3, 62, '13 Semanas', 'observacao teste 1 aaaaaaaaaaaaaa aaaaaaaaaaaaa', 'Consulta teste 1', NULL, NULL),
                                                                                                                                                                                    (b'1', '2023-12-04', 1, '2023-12-04 16:11:02.722029', 2, 3, 63, '15 Semanas', 'observacao teste 1 aaaaaaaaaaaabbbbbbbaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbsdd bbbbbbbbbbb bbbbbbbbbb vvvvvvvvv aaaaaaaaaaa', 'Consulta teste 2', NULL, NULL);

INSERT INTO `exame` (`ativo`, `dataRealizada`, `dataInclusao`, `exame_mamae`, `id`, `localExameRealizado`, `observacao`, `tipoExame`) VALUES
                                                                                                                                          (b'1', NULL, '2023-12-04 16:50:17.478301', 1, 1, 'aaaaa', 'Tudo ok', 'Exame sangue'),
                                                                                                                                          (b'1', NULL, '2023-12-04 16:50:44.375370', 1, 2, 'aaaaa', 'Tudo ok', 'Exame sangue'),
                                                                                                                                          (b'1', NULL, '2023-12-04 16:50:56.229142', 1, 3, 'dddddddddddddddd', 'Tudo ok', 'Exame aaadsd');

INSERT INTO `gestacao` (`ativo`, `dataInicio`, `realizado`, `vacinaDTPa`, `dataInclusao`, `id`, `mamae_gestacao`, `idadeGestacional`, `nomeBebe`, `observacaoFinal`) VALUES
                                                                                                                                                                         (b'1', '2023-05-15', NULL, NULL, '2023-12-04 15:34:42.684434', 1, NULL, '30 semanas ', 'joao Guilherme', NULL),
                                                                                                                                                                         (b'1', '2023-05-15', NULL, NULL, '2023-12-04 15:34:42.684434', 3, NULL, '30 semanas ', 'Julieta', NULL);

INSERT INTO `mamae` (`emGestacao`, `gestacao_mamae`, `id`, `medico_medico`, `contatoEmergencia`, `convenio`, `observacoes`) VALUES
                                                                                                                                (b'1', 1, 1, 3, '63 9845522656 MARIDO', 'bradesco Saude', '  '),
                                                                                                                                (b'1', 3, 2, 3, '63 958845455 MARIDO (ROBERTO) ', 'bradesco Saude', '  ');

INSERT INTO `medico` (`id`, `crm`) VALUES
    (3, '2233222');

INSERT INTO `nutricao` (`ativo`, `especifico`, `dataInclusao`, `id`, `mamae_id`, `descricao`, `titulo`) VALUES
                                                                                                            (b'1', b'0', '2023-12-04 18:13:17.456506', 1, NULL, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'Nutricao 1'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:27.505655', 2, NULL, 'vbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'Nutricao 2'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:35.591721', 3, NULL, 'cccccccccasddacscassadscfdsadsadsadsd', 'Nutricao 3'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:36.622943', 4, NULL, 'cccccccccasddacscassadscfdsadsadsadsd', 'Nutricao 4'),
                                                                                                            (b'1', b'1', '2023-12-04 18:14:23.487872', 5, 1, 'assssssssssssssssssssssssssssssssssssssssssnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnuticaroasodamsdnsannutirpcar', 'Nutricao Mamae 1'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:27.505655', 6, NULL, 'vbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'Nutricao 2'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:27.505655', 7, NULL, 'vbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'Nutricao 2'),
                                                                                                            (b'1', b'0', '2023-12-04 18:13:27.505655', 8, NULL, 'vbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'Nutricao 2');

INSERT INTO `observacao` (`id`, `ativo`, `dataInclusao`, `atendido`, `observacao`, `resposta`, `usuario_duvida`) VALUES
                                                                                                                     (2, b'1', '2023-12-04 20:12:39.078595', b'0', 'minha duvida aqui', NULL, 1),
                                                                                                                     (3, b'1', '2023-12-04 20:25:54.113857', b'0', 'essa pergunta é duvidosa', NULL, 1),
                                                                                                                     (9, b'1', '2023-12-04 20:30:05.035437', b'1', 'teste realizado', NULL, 1),
                                                                                                                     (10, b'1', '2023-12-06 14:33:37.551649', b'0', 'asdsd', NULL, 1),
                                                                                                                     (11, b'1', '2023-12-06 14:41:04.155444', b'0', 'minha duvida é essa', NULL, 1),
                                                                                                                     (12, b'1', '2023-12-06 14:41:24.632733', b'0', 'agora estou com duvida B', NULL, 1),
                                                                                                                     (13, b'1', '2023-12-04 20:30:05.035437', b'1', 'teste realizado', NULL, 1),
                                                                                                                     (14, b'1', '2023-12-04 20:25:54.113857', b'0', 'essa pergunta é duvidosa', NULL, 1),
                                                                                                                     (15, b'1', '2023-12-06 14:33:37.551649', b'0', 'asdsd', NULL, 1),
                                                                                                                     (16, b'1', '2023-12-04 20:30:05.035437', b'1', 'teste realizado', NULL, 1),
                                                                                                                     (17, b'1', '2023-12-04 20:30:05.035437', b'1', 'teste realizado', NULL, 1),
                                                                                                                     (20, b'1', '2023-12-11 20:21:29.858590', b'0', 'sssss', NULL, 1),
                                                                                                                     (21, b'1', '2023-12-11 20:23:16.499529', b'0', 'sssss', NULL, 1),
                                                                                                                     (22, b'1', '2023-12-11 20:23:47.427245', b'0', 'ert', NULL, 1),
                                                                                                                     (23, b'1', '2023-12-11 20:33:29.923513', b'0', '', NULL, 1),
                                                                                                                     (24, b'1', '2023-12-11 20:59:37.775911', b'0', 'to com dúvida ', NULL, 1),
                                                                                                                     (25, b'1', '2023-12-11 21:01:25.146087', b'0', 'o', NULL, 1),
                                                                                                                     (26, b'1', '2023-12-11 21:12:13.847435', b'0', 'dúvida 2', NULL, 1),
                                                                                                                     (27, b'1', '2023-12-11 21:12:24.476959', b'0', 'dúvida 2', NULL, 1),
                                                                                                                     (28, b'1', '2023-12-12 13:21:32.322659', b'0', 'yeisje', NULL, 1),
                                                                                                                     (29, b'1', '2023-12-14 19:44:18.885161', b'0', 'uugh', NULL, 1);

INSERT INTO `ultrassonografia` (`ativo`, `dataInclusao`, `id`, `ultrassonografia_mamae`, `idadeGestacional`, `linkArquivo`, `observacao`, `data`, `doppler`, `igdum`, `liq`, `placenta`) VALUES
                                                                                                                                                                                             (b'1', '2023-12-04 18:51:42.963880', 1, 1, '29 semanas ', '', 'ultrassonografia aaaaaaaa', '2023-12-01', NULL, NULL, NULL, NULL),
                                                                                                                                                                                             (b'1', '2023-12-04 19:16:20.046267', 2, 1, '29 semanas ', 'https://drive.google.com/file/d/1r-n1zA-2QdIQxKyyXC5eC_uksFskM4YX/view?usp=sharing', 'ultrassonografia bbbbbbbbb', '2023-12-01', 'asdsd', 'ddda', '23423sds', 'ddasdsd');

INSERT INTO `usuario` (`ativo`, `dataNascimento`, `dataInclusao`, `id`, `cpf`, `email`, `naturalidade`, `nome`, `senha`, `telefone`) VALUES
                                                                                                                                         (b'1', NULL, '2023-12-04 15:34:42.676669', 1, '1111', 'kaiomm2000@gmail.com', NULL, 'Naomi Nunes', 'cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==', NULL),
                                                                                                                                         (b'1', NULL, '2023-12-04 15:40:38.556807', 2, '11112', 'naomi@gmail.com', NULL, 'Juliana', 'cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==', NULL),
                                                                                                                                         (b'1', NULL, '2023-12-04 15:53:55.223669', 3, '00000', 'cairo@gmail.com', NULL, 'Dr. Cairo', 'DJC4T+9ZdI/lF2jbE5fm6ggBM1B9yqOv6vXxHLUmWljQFW5NIobIKeMCPP8Hft/biLjUnbUmIK1Y9GIuPQM0dg==', '63 9999555');

INSERT INTO `usuario_perfil` (`perfil`, `id_usuario`) VALUES
                                                          (2, 1),
                                                          (2, 2);

INSERT INTO `vacina` (`ativo`, `dataRealizada`, `doseAtual`, `quantidadeDoses`, `dataInclusao`, `id`, `vacina_mamae`, `localVacinaRealizada`, `loteVacina`, `nome`, `nomeProfissionalRealizouVacina`) VALUES
                                                                                                                                                                                                          (b'1', NULL, 1, 2, '2023-12-04 19:31:18.049935', 1, 1, 'Postinho joao joao', '556452', 'Vacina 1', 'Postinho joao joao'),
                                                                                                                                                                                                          (b'1', NULL, 2, 2, '2023-12-04 19:31:25.014295', 2, 1, 'Postinho joao joao', '556452', 'Vacina 2', 'Postinho joao joao');
