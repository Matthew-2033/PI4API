DELETE FROM avaliacao WHERE id_avaliacao = ?;
DELETE FROM avaliacaoDobras WHERE id_avaliacao = ?;
DELETE FROM avaliacaoPerimetro WHERE id_avaliacao = ?;
DELETE FROM avaliacaoPorcentagemGordura WHERE id_avaliacao = ? AND autor = ?;