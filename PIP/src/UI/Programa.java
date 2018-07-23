package UI;


import base.CDMusica;
import base.Cliente;
import base.Filme;
import base.Funcionario;
import base.Jogos;
import base.Midia;
import base.Seriado;
import excecoes.ArrayCheioException;
import excecoes.AtualizacaoIncompativelException;
import excecoes.CDNEException;
import excecoes.CJCException;
import excecoes.CNEException;
import excecoes.FJCException;
import excecoes.FNEException;
import excecoes.JCException;
import excecoes.JIException;
import excecoes.JNEException;
import excecoes.LAAException;
import excecoes.PQNException;
import excecoes.ProdutoIndisponivelException;
import excecoes.ProdutoInexistenteException;
import excecoes.ProdutoJaExisteException;
import excecoes.RAEException;
import excecoes.RepositorioException;
import excecoes.TRIException;
import excecoes.TipoErradoException;
import fachada.Locadora;

public class Programa 
{
	public static void main(String[] args) throws PQNException, RAEException, RepositorioException, FJCException, FNEException, ArrayCheioException, ProdutoJaExisteException, CNEException, CDNEException, JNEException, ProdutoInexistenteException, AtualizacaoIncompativelException, TipoErradoException, LAAException, ProdutoIndisponivelException, JIException, JCException, TRIException, CJCException
	{
		
		Locadora CInBuster = new Locadora();
		
	//	Cliente Andre = new Cliente("André melo dos Santos", "123456789", "9980-8301");
		Cliente Fofao = new Cliente("Carreta Fofao", "Siga em frente", "6969-6969");
		Cliente Ladrao = new Cliente("Eduardo Cunha", "Conta na Suica", "Nao divulgado");// 
		
		Funcionario Henrique = new Funcionario("Opa", "Atendente");
		Funcionario StanLee = new Funcionario("StanLee", "Dono");
		Funcionario FilthyFrank = new Funcionario("Henrique", "Gerente");
		
		CDMusica Carreta = new CDMusica("Siga em frente", "O melhor que existe", "Carreta Furacão", 5, 8001);
		CDMusica McLivinho = new CDMusica("Funk eletrohits", "Funk" ,"McLivinho", 5, 2 );
		CDMusica NewPerspective = new CDMusica("GGWP", "Pop Rock", "Panic! At the Disco", 5, 10);
		
		Jogos TheSearchingOfTrapezioDescendente = new Jogos("The Searching of Trapezio Descendente", "Trapezera Buscano", "BIIIRRR", 13, 37, 8001);
		Jogos TheSearchingOfTrapezioDescendente2 = new Jogos("The Searching of Trapezio Descendente: Ta saindo da jaula o monstro", "Trapezera buscano denovo", "HORA DO SHOW", 14, 38 , 8002 );
		Jogos CarretaFuracaoTheGame = new Jogos("Carreta Furacao: The Game" , "Se liga na batida" , "do cavaco", 5, 5, 250);
		
		Midia Friends = new Seriado("Friends", "Amiguinhos se juntam para enfrentar altas confusoes", "comedia", 10/10 , 8 , 12, 10, 10 );
		Midia GoT = new Seriado("Game of Thrones", "Spoiler alert: todo mundo morre depois de rolar altas putaria", "acao", 8, 12, 10, 6, 10);
		Midia TahM = new Seriado("Two and a half Man", "Charlie sheen eh muito doidao", "comedia", 7, 12, 10 ,8 ,10);
		
		Midia Terror = new Filme("A invocação do mal 2", "Pra se cagar de medo", "Terror", 10/10 , 5, 5);
		Midia ProjetoX = new Filme("Projeto X", "Uma festa que saiu do controle, gerando altas confusoes", "comedia", 7, 25, 10);
		Midia Pesadao = new Filme("Pesadao", "Acabou o frio", "drama familiar", 24,90,10);
		
		
		
		//inserir
		

	//	CInBuster.inserirCliente(Andre);
		CInBuster.inserirCliente(Fofao);
		CInBuster.inserirCliente(Ladrao);
		
		CInBuster.inserirFunc(Henrique);
		CInBuster.inserirFunc(StanLee);
		CInBuster.inserirFunc(FilthyFrank);
		
		CInBuster.inserirCD(Carreta);
		CInBuster.inserirCD(McLivinho);
		CInBuster.inserirCD(NewPerspective);
		
		CInBuster.inserirJogos(TheSearchingOfTrapezioDescendente);
		CInBuster.inserirJogos(TheSearchingOfTrapezioDescendente2);
		CInBuster.inserirJogos(CarretaFuracaoTheGame);
		
		CInBuster.inserirMidia(Pesadao);
		CInBuster.inserirMidia(ProjetoX);
		CInBuster.inserirMidia(Terror);
		
		CInBuster.inserirMidia(Friends);
		CInBuster.inserirMidia(GoT);
		CInBuster.inserirMidia(TahM);
		
		//remover
		
		
	//	CInBuster.removerCliente("Siga em frente");
		
		//CInBuster.removerFunc(StanLee);
		
	//	CInBuster.removerCD(McLivinho);
		
	//	CInBuster.removerJogos(TheSearchingOfTrapezioDescendente2);
	//	
	//	CInBuster.removerMidia(ProjetoX);
		
	//	CInBuster.removerMidia(GoT);
		
	
		//atualizar
		
	//	CInBuster.atualizarJogos(TheSearchingOfTrapezioDescendente, CarretaFuracaoTheGame);//jogo
		
	//	CInBuster.atualizarCliente("BIRRR", Ladrao);//cliente
		
	//	CInBuster.atualizarMidia(Friends, TahM);//Seriado
		
	//	CInBuster.atualizarMidia(CarretaFuracaoThemovie, Pesadao);//filme
		
	//	CInBuster.atualizar(Carreta, NewPerspective);//cd
		
	//	CInBuster.atualizarFunc(McLovin, FilthyFrank);//funcionario
		
		//procurar
		
	//	CInBuster.procurarCliente("Conta na Suica");
		
	//	CInBuster.procurarJogos(CarretaFuracaoTheGame.getNome());
		
	//	CInBuster.procurarFunc(McLovin.getNomeFuncionario());
		
	//	CInBuster.procurarMidia("Pesadao");
		
	//	CInBuster.procurarMidia("Two and a half Man");
		
		//alugar
		Cliente testeAlugar = new Cliente("Andre", "123456789", "9980-8301");
		CInBuster.inserirCliente(testeAlugar);
		
		// Temos um periodo de aluguel aluguel fixo de 3 dias
		
		//CInBuster.alugarCD(NewPerspective, "2");
		CInBuster.alugarFilme("123456789","A invocação do mal 2");
	//	CInBuster.alugarSeriado("2", "Two and a half Man", 3);
	//	CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		
		
		
		
		System.out.println(testeAlugar);
		System.out.println(CInBuster.atendimento(FilthyFrank));
		
		//CInBuster.locadoraAssaltada();
		
		System.out.println("Valor no caixa: R$" + CInBuster.getCaixa());
		
		
		//devolver
		
	//	CInBuster.devolverFilme("2", "Pesadao", 5);
	//	CInBuster.devolverJogos("2", "Carreta Furacao: The Game", 3);
	//	CInBuster.devolverSeriado("2", "Two and a half Man", 12, 3);
		
	//	System.out.println("\n" + "\n" + "\n"+ testeAlugar);
		
		
//		CInBuster.quitarDivida("2");
	//	System.out.println("\n" + "\n" + "\n"+ testeAlugar);
		
	//	System.out.println("\n" + "\n" + "\n"+"Valor no caixa: R$"+ CInBuster.getCaixa());
		
		
		
		//excecoes
		
		
		//CadastroExistenteException
		//CInBuster.inserirFunc(McLovin);
		//CInBuster.inserirMidia(Pesadao);
        //CInBuster.inserirMidia(TahM);
        //CInBuster.inserirJogos(CarretaFuracaoTheGame);

		
		//ArrayLotadoException
	//	Midia teste1 = new Filme("c", "c", "c", 1, 1, 1);
	//	Midia teste7 = new Filme("d", "c", "c", 1, 1, 1);
	//	Midia teste8 = new Filme("e", "c", "c", 1, 1, 1);
	//	Cliente teste2 = new Cliente("asda", null, null);
	//	Funcionario teste3 = new Funcionario(null, null);
	//	Jogos teste4 = new Jogos("a", "a", "a", 1, 1, 1);
	//	Jogos teste6 = new Jogos("b", "a", "a", 1, 1, 1);
	//	CDMusica teste5 = new CDMusica(null, null, null, 0, 0);
		
		//CInBuster.inserirMidia(teste1);
		//CInBuster.inserirMidia(teste7);
		//CInBuster.inserirMidia(teste8);
		//CInBuster.inserirCliente(teste2);
		//CInBuster.inserirFunc(teste3);
		//CInBuster.inserirJogos(teste4);
		//CInBuster.inserirJogos(teste6);
		//CInBuster.inserirCD(teste5);
		
		
		//ProdutoInexistenteException
		//CInBuster.removerMidia(teste1);
		//CInBuster.removerCliente("12312312sesad");
		//CInBuster.removerFunc(StanLee);
		//CInBuster.removerCD(McLivinho);
		//CInBuster.removerJogos(TheSearchingOfTrapezioDescendente2);
		
		
		//AtualizacaoErrada
		//Midia teste9 = new Seriado("f", "g", "h", 1, 1, 1, 1, 1);
		//CInBuster.atualizarMidia(teste1, teste9);
		
		
		//ProdutoIndisponivelException
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		//CInBuster.alugarJogos("2", "Carreta Furacao: The Game");
		CInBuster.locadoraAssaltada();
		
		System.out.println("Valor no caixa: R$" + CInBuster.getCaixa());
		
	}

}
