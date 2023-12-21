-- Insere dados na tabela 'consulta'
INSERT INTO consulta (ativo, dataRealizada, consulta_mamae, dataInclusao, id, medico_consulta, peso, idadeGestacional, observacao, titulo, edema, mf) VALUES
                                                                                                                                                          (1, '2023-12-04', 1, '2023-12-04 16:10:54.497124', 1, 3, 62, '13 Semanas', 'observacao teste 1 aaaaaaaaaaaaaa aaaaaaaaaaaaa', 'Consulta teste 1', NULL, NULL),
                                                                                                                                                          (1, '2023-12-04', 1, '2023-12-04 16:11:02.722029', 2, 3, 63, '15 Semanas', 'observacao teste 1 aaaaaaaaaaaabbbbbbbaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbsdd bbbbbbbbbbb bbbbbbbbbb vvvvvvvvv aaaaaaaaaaa', 'Consulta teste 2', NULL, NULL);

-- Insere dados na tabela 'exame'
INSERT INTO exame (ativo, dataRealizada, dataInclusao, exame_mamae, id, localExameRealizado, observacao, tipoExame) VALUES
                                                                                                                        (1, NULL, '2023-12-04 16:50:17.478301', 1, 1, 'aaaaa', 'Tudo ok', 'Exame sangue'),
                                                                                                                        (1, NULL, '2023-12-04 16:50:44.375370', 1, 2, 'aaaaa', 'Tudo ok', 'Exame sangue'),
                                                                                                                        (1, NULL, '2023-12-04 16:50:56.229142', 1, 3, 'dddddddddddddddd', 'Tudo ok', 'Exame aaadsd');

-- Insere dados na tabela 'gestacao'
INSERT INTO gestacao (ativo, dataInicio, realizado, vacinaDTPa, dataInclusao, id, mamae_gestacao, idadeGestacional, nomeBebe, observacaoFinal) VALUES
                                                                                                                                                   (1, '2023-05-15', NULL, NULL, '2023-12-04 15:34:42.684434', 1, NULL, '30 semanas ', 'joao Guilherme', NULL),
                                                                                                                                                   (1, '2023-05-15', NULL, NULL, '2023-12-04 15:34:42.684434', 3, NULL, '30 semanas ', 'Julieta', NULL);

-- Insere dados na tabela 'mamae'
INSERT INTO mamae (emGestacao, gestacao_mamae, id, medico_medico, contatoEmergencia, convenio, observacoes) VALUES
                                                                                                                (1, 1, 1, 3, '63 9845522656 MARIDO', 'bradesco Saude', '  '),
                                                                                                                (1, 3, 2, 3, '63 958845455 MARIDO (ROBERTO) ', 'bradesco Saude', '  ');

-- Insere dados na tabela 'medico'
INSERT INTO medico (id, crm) VALUES
    (3, '2233222');

-- Insere dados na tabela 'nutricao'
INSERT INTO nutricao (ativo, especifico, dataInclusao, id, mamae_id, descricao, titulo) VALUES
                                                                                            (1, 0, '2023-12-04 18:13:17.456506', 1, NULL, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'Nutricao 1'),
                                                                                            (1, 0, '2023-12-04 18:13:27.505655', 2, NULL, 'vbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'Nutricao 2'),
-- ... (inclua os demais registros conforme necessário)

-- Insere dados na tabela 'observacao'
INSERT INTO observacao (id, ativo, dataInclusao, atendido, observacao, resposta, usuario_duvida) VALUES
    (2, 1, '2023-12-04 20:12:39.078595', 0, 'minha duvida aqui', NULL, 1),
    (3, 1, '2023-12-04 20:25:54.113857', 0, 'essa pergunta é duvidosa', NULL, 1),
-- ... (inclua os demais registros conforme necessário)

-- Insere dados na tabela 'ultrassonografia'
INSERT INTO ultrassonografia (ativo, dataInclusao, id, ultrassonografia_mamae, idadeGestacional, linkArquivo, observacao, data, doppler, igdum, liq, placenta) VALUES
    (1, '2023-12-04 18:51:42.963880', 1, 1, '29 semanas ', '', 'ultrassonografia aaaaaaaa', '2023-12-01', NULL, NULL, NULL, NULL),
-- ... (inclua os demais registros conforme necessário)

-- Insere dados na tabela 'usuario'
INSERT INTO usuario (ativo, dataNascimento, dataInclusao, id, cpf, email, naturalidade, nome, senha, telefone) VALUES
    (1, NULL, '2023-12-04 15:34:42.676669', 1, '1111', 'kaiomm2000@gmail.com', NULL, 'Naomi Nunes', 'cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==', NULL),
-- ... (inclua os demais registros conforme necessário)

-- Insere dados na tabela 'usuario_perfil'
INSERT INTO usuario_perfil (perfil, id_usuario) VALUES
    (2, 1),
    (2, 2);

-- Insere dados na tabela 'vacina'
INSERT INTO vacina (ativo, dataRealizada, doseAtual, quantidadeDoses, dataInclusao, id, vacina_mamae, localVacinaRealizada, loteVacina, nome, nomeProfissionalRealizouVacina) VALUES
                                                                                                                                                                                  (1, NULL, 1, 2, '2023-12-04 19:31:18.049935', 1, 1, 'Postinho joao joao', '556452', 'Vacina 1', 'Postinho joao joao'),
-- ... (inclua os demais registros conforme necessário)
