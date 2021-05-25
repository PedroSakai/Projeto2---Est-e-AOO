function BD ()
{
    process.env.ORA_SDTZ = 'UTC-3';

    this.getConexao = async function ()
    {
        if (global.conexao)
            return global.conexao;

        const oracledb = require('oracledb');
        const dbConfig = require('./dbconfig.js');
        
        try
        {
            global.conexao = await oracledb.getConnection(dbConfig);
        }
        catch (erro)
        {
            console.log ('Não foi possível estabelecer conexão com o BD!');
            process.exit(1);
        }

        return global.conexao;
    }

    this.estrutureSe = async function ()
    {
        try
        {
            const conexao = await this.getConexao();
            const sql     = 'CREATE TABLE Matriculas (RA NUMBER(5), Cod NUMBER(3), PRIMARY KEY (RA,Cod), FOREIGN KEY (RA) REFERENCES Alunos(RA), FOREIGN KEY (Cod) REFERENCES Disciplinas(cod)) ';
            await conexao.execute(sql);
        }
        catch (erro)
        {} 
    }

    this.banana = async function ()
    {
        console.log("Começando!");
    }
}

function Matriculas (bd)
{
    this.bd = bd;

    this.recupereTodos = async function ()
    {
        const conexao = await this.bd.getConexao();
        
        const sql = 'SELECT * FROM Matriculas';
        const ret =  await conexao.execute(sql);

        return ret.rows;
    }

}

function Matricula (ra,cod)
{
    this.ra = ra;
    this.cod = cod;
}

function Comunicado (codigo,mensagem,descricao)
{
    this.codigo    = codigo;
    this.mensagem  = mensagem;
    this.descricao = descricao;
}

function middleWareGlobal (req, res, next)
{
    console.time('Requisição'); // marca o início da requisição
    console.log('Método: '+req.method+'; URL: '+req.url); // retorna qual o método e url foi chamada

    next(); // função que chama as próximas ações

    console.log('Finalizou'); // será chamado após a requisição ser concluída

    console.timeEnd('Requisição'); // marca o fim da requisição
}

async function ativacaoDoServidor ()
{
    const bd = new BD ();
    await bd.estrutureSe();
    //global.matriculas = new Matriculas (bd);

    const express = require('express');
    const app     = express();
    
    app.use(express.json());  
    app.use(middleWareGlobal);

    //app.get   ('/matriculas'    , recuperacaoDeTodos);

    console.log ('Servidor ativo na porta 3000...');
    app.listen(3000);
}

ativacaoDoServidor();