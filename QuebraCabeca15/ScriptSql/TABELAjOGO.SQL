CREATE TABLE JOGADOR(
	PK_JOGADOR INT PRIMARY KEY,
	NOME VARCHAR (50) NOT NULL,
	PONTOS FLOAT NOT NULL
);


CREATE TABLE JOGO (
	PK_JOGO SERIAL,
	OBJETO BYTEA,
	PRIMARY KEY (PK_JOGO)
);

CREATE TABLE JOGO_JOGADOR(
	FK_JOGO INT NOT NULL,
	FK_JOGADOR INT NOT NULL,
	FOREIGN KEY (FK_JOGO) REFERENCES JOGO(PK_JOGO),
	FOREIGN KEY (FK_JOGADOR) REFERENCES JOGADOR(PK_JOGADOR)
);

select fk_jogo from jogo_jogador as jj inner join jogo as j on(j.pk_jogo = jj.fk_jogo)
inner join jogador as ja on (ja.pk_jogador = jj.fk_jogador) where ja.pk_jogador =2;

s