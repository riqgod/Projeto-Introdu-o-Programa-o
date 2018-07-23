package fachada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import base.CDMusica;
import base.Cliente;
import base.Filme;
import base.Funcionario;
import base.Jogos;
import base.Midia;
import base.Seriado;
import excecoes.*;
import negocios.*;

public class Locadora {
	
	private static final File fileConfig = new File("config.txt");
	
	public static final String tipoArray = "ARRAY";
	public static final String tipoLista = "LISTA";
	
	private RepsJogos repJogos;
	private RepCDs repCDs;
	private RepFuncionarios repFunc;
	private RepClientes repClientes;
	private RepsMidia repMidia;
	private static double caixa = 0;

	
	
	public Locadora() throws TRIException
	{
		String tipoRep = null;
		
		try {
			FileReader fileReader = new FileReader(fileConfig);
			BufferedReader reader = new BufferedReader(fileReader);
			
			tipoRep = reader.readLine();
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		repJogos = new RepsJogos(tipoRep);
		repCDs = new RepCDs(tipoRep);
		repFunc = new RepFuncionarios(tipoRep);
		repClientes = new RepClientes(tipoRep);
		repMidia = new RepsMidia(tipoRep);
		
	}
	

	// Funções para Jogos
	public void inserirJogos(Jogos jogo) throws RepositorioException, PQNException, JCException {
		repJogos.inserirJogos(jogo);
	}

	public void removerJogos(Jogos jogo) throws JNEException {
		repJogos.removerJogos(jogo);
	}

	public Jogos procurarJogos(String nome) throws JNEException {
		return repJogos.procurarJogos(nome);
	}

	public void atualizarJogos(Jogos jogoAntigo, Jogos jogoAtualizado) throws JNEException {
		repJogos.atualizarJogos(jogoAntigo, jogoAtualizado);
	}

	// Funções para CDs
	public void inserirCD(CDMusica cd) throws PQNException {
		repCDs.inserirCD(cd);
	}

	public void removerCD(CDMusica cd) throws CDNEException {
		repCDs.removerCD(cd);
	}

	public CDMusica procurarCD(CDMusica cd) throws CDNEException {
		return repCDs.procurarCD(cd);
	}

	public void atualizar(CDMusica cdAntigo, CDMusica cdNovo) throws CDNEException, PQNException {
		repCDs.atualizar(cdAntigo, cdNovo);
	}

	// Funções para Funcionarios;
	public void inserirFunc(Funcionario funcionario) throws FJCException, FNEException {
		repFunc.inserirFuncionario(funcionario);
	}

	public void removerFunc(Funcionario funcionario) throws FNEException {
		repFunc.removerFuncionario(funcionario);
	}

	public Funcionario procurarFunc(String nome) throws FNEException {
		return repFunc.procurarFuncionario(nome);
	}

	public void atualizarFunc(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado) throws FNEException {
		repFunc.atualizarFuncionario(funcionarioAntigo, funcionarioAtualizado);
	}

	// funções para cliente

	public void inserirCliente(Cliente cliente) throws RAEException, CJCException {
		repClientes.inserirCliente(cliente);
	}

	public Cliente procurarCliente(String CPF) throws CNEException {
		return repClientes.procurarCliente(CPF);
	}

	public void removerCliente(String CPF) throws CNEException {
		repClientes.removerCliente(CPF);
	}

	public void atualizarCliente(String CPF, Cliente clienteAtualizado) throws CNEException {
		repClientes.atualizarCliente(CPF, clienteAtualizado);
	}

	// funcoes para Midia
	public void inserirMidia(Midia midia) throws PQNException, ArrayCheioException, ProdutoJaExisteException {
		repMidia.inserirMidia(midia);

	}

	public void removerMidia(Midia midia) throws ProdutoInexistenteException {
		repMidia.removerMidia(midia);

	}

	public void atualizarMidia(Midia midiaAntiga, Midia midiaNova)
			throws ProdutoInexistenteException, AtualizacaoIncompativelException {
		repMidia.atualizar(midiaAntiga, midiaNova);
	}

	public Midia procurarMidia(String nome) throws ProdutoInexistenteException {
		return repMidia.procurarMidia(nome);
	}

	
	//Funcoes para locadora
	
	public void alugarFilme(String CPF, String nome) throws ProdutoInexistenteException,CNEException, TipoErradoException, LAAException, ProdutoIndisponivelException 
	{
		if (repClientes.procurarCliente(CPF) != null)
		{
			if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() < 9)
			{
				repClientes.procurarCliente(CPF).setProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(),"Filme Locado: " + repMidia.procurarMidia(nome).getNome() );

				if (repMidia.procurarMidia(nome) instanceof Filme) 
				{
					if (((Filme) repMidia.procurarMidia(nome)).getQuantidadeDisponivel() > 0) 
					{
						((Filme) repMidia.procurarMidia(nome)).setQuantidadeDisponivel(((Filme) repMidia.procurarMidia(nome)).getQuantidadeDisponivel() - 1);
						repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() + 1);
						caixa = caixa + repMidia.procurarMidia(nome).getPreco();
					} 
					else 
					{
						throw new ProdutoIndisponivelException();
					}
				} 
				else 
				{
					throw new TipoErradoException();
				}
			} 
			else
			{
				throw new LAAException();
			}
		}
		else
		{
			throw new CNEException();
		}
	}

	public void alugarSeriado(String CPF, String nome, int temporadaDesejada) throws CNEException,ProdutoInexistenteException, TipoErradoException, LAAException, ProdutoIndisponivelException
	{
		if (repClientes.procurarCliente(CPF) != null) 
		{
			if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() < 9) 
			{
				
				repClientes.procurarCliente(CPF).setProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(),"Seriado Locado: " + repMidia.procurarMidia(nome).getNome() + "; Temporada Desejada: "
								+ temporadaDesejada);

				if (repMidia.procurarMidia(nome) instanceof Seriado) 
				{
					if (((Seriado) repMidia.procurarMidia(nome)).getTemporadasDisponibilidadeLocal(temporadaDesejada) > 0) 
					{
						((Seriado) repMidia.procurarMidia(nome)).setTemporadasDisponibilidadeLocal(temporadaDesejada,
								((Seriado) repMidia.procurarMidia(nome))
										.getTemporadasDisponibilidadeLocal(temporadaDesejada) - 1);
						repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(
								repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() + 1);
						caixa = caixa + repMidia.procurarMidia(nome).getPreco();
					} 
					else 
					{
						throw new ProdutoIndisponivelException();
					}
				} 
				else 
				{
					throw new TipoErradoException();
				}
			} 
			else
			{
				throw new LAAException();
			}
		} 
		else 
		{
			throw new CNEException();
		}
	}

	public void devolverFilme(String CPF, String nome, int diasDevolucao)
			throws CNEException, ProdutoInexistenteException, TipoErradoException {
		if (repClientes.procurarCliente(CPF) != null) {
			if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() > 0) {
				if (diasDevolucao > 3) {
					repClientes.procurarCliente(CPF).setValorAtrasado(((diasDevolucao - 3) * 0.5));
				}
				if (repMidia.procurarMidia(nome) instanceof Filme) {
					((Filme) repMidia.procurarMidia(nome)).setQuantidadeDisponivel(
							((Filme) repMidia.procurarMidia(nome)).getQuantidadeDisponivel() + 1);
					repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(
							repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1);

					for (int i = 0; i < repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(); i++) {
						if (repClientes.procurarCliente(CPF).getProdutosLocados(i)
								.equalsIgnoreCase("Midia Locada: " + nome)) {
							repClientes.procurarCliente(CPF).setProdutosLocados(i,
									repClientes.procurarCliente(CPF).getProdutosLocados(
											repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1));
							repClientes.procurarCliente(CPF).setProdutosLocados(
									repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1, "");
						}
					}
				} else {
					throw new TipoErradoException();
				}
			}
		} else {
			throw new CNEException();
		}
	}

	public void devolverSeriado(String CPF, String nome, int diasDevolucao, int temporadaSeriado)
			throws CNEException, TipoErradoException, ProdutoInexistenteException {
		if (repClientes.procurarCliente(CPF) != null) {
			if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() > 0) {
				if (diasDevolucao > 3) {
					repClientes.procurarCliente(CPF).setValorAtrasado(((diasDevolucao - 3) * 0.5));
				}
				if (repMidia.procurarMidia(nome) instanceof Seriado) {
					((Seriado) repMidia.procurarMidia(nome)).setTemporadasDisponibilidadeLocal(temporadaSeriado,
							((Seriado) repMidia.procurarMidia(nome)).getTemporadasDisponibilidadeLocal(temporadaSeriado)
									+ 1);
					repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(
							repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1);

					for (int i = 0; i < repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(); i++) {

						if (repClientes.procurarCliente(CPF).getProdutosLocados(i)
								.equalsIgnoreCase("Seriado Locado: " + repMidia.procurarMidia(nome).getNome()
										+ "; Temporada Desejada: " + temporadaSeriado)) {
							repClientes.procurarCliente(CPF).setProdutosLocados(i,
									repClientes.procurarCliente(CPF).getProdutosLocados(
											repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1));
							repClientes.procurarCliente(CPF).setProdutosLocados(
									repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() - 1, "");
						}
					}
				} else {
					throw new TipoErradoException();
				}
			}
		} else {
			throw new CNEException();
		}
	}

	public void alugarJogos(String CPF, String nome) throws JIException, JNEException, CNEException, LAAException {
		if (repClientes.procurarCliente(CPF) != null) {
			if (repJogos.procurarJogos(nome) != null) {
				int quantidadeDisponivel = repJogos.procurarJogos(nome).getQuantidade();
				if (quantidadeDisponivel > 0) {
					repJogos.procurarJogos(nome).setQuantidade(quantidadeDisponivel - 1);
					if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() < 9) {
						repClientes.procurarCliente(CPF).setProdutosLocados(
								repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(),
								"Jogo: " + repJogos.procurarJogos(nome).getNome());
						repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(
								repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() + 1);
						caixa = caixa + repJogos.procurarJogos(nome).getPreco();
					} else {
						throw new LAAException();
					}
				} else {
					throw new JIException();
				}
			} else {
				throw new JNEException();
			}
		} else {
			throw new CNEException();
		}
	}
	
	public void devolverJogos(String CPF, String nome, int diasDevolucao) throws CNEException, JNEException {
	    if (repClientes.procurarCliente(CPF) != null) {
	        if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()>0){
	            if (repJogos.procurarJogos(nome) != null) {
	                repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1);
	                repJogos.procurarJogos(nome).setQuantidade(repJogos.procurarJogos(nome).getQuantidade()+1);
	                for (int i = 0; i < repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(); i++) {
	                    if (repClientes.procurarCliente(CPF).getProdutosLocados(i).equalsIgnoreCase("Jogo: " + nome)) {
	                    	
	                        repClientes.procurarCliente(CPF).setProdutosLocados(i, repClientes.procurarCliente(CPF).getProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1));
	                        repClientes.procurarCliente(CPF).setProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1, "");
	                    }
	                }
	            } else {
	                throw new JNEException();
	            }
	        }
	        if (diasDevolucao>3) {
	            repClientes.procurarCliente(CPF).setValorAtrasado(((diasDevolucao-3)*0.5));
	        }
	        } else {
	            throw new CNEException();
	    }
	}
	
	
	public void alugarCD(CDMusica cd, String CPF) throws PQNException, CDNEException, CNEException, LAAException {
        if(repClientes.procurarCliente(CPF) != null){
            if (repCDs.procurarCD(cd) != null){
             int quantidadeDisponivel = cd.getQtd();
                if (quantidadeDisponivel > 0) {
                    cd.setQtd(quantidadeDisponivel - 1);
                    if (repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade() < 9){
                        repClientes.procurarCliente(CPF).setProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(), "CD: " + cd.getAlbum());
                        repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()+1);
                        caixa = caixa + repCDs.procurarCD(cd).getPreco();
                    } else {
                        throw new LAAException();
                    }
                } else {
                    throw new PQNException();
                }
            } else {
                throw new CDNEException();
            }
       } else {
           throw new CNEException();
       }
    }
   
    public void devolverCD(String CPF, CDMusica cd, int diasDevolucao) throws CNEException, ProdutoInexistenteException, TipoErradoException, CDNEException
    {
        if(repClientes.procurarCliente(CPF) != null)
        {
                (repCDs.procurarCD(cd)).setQtd(repCDs.procurarCD(cd).getQtd()+1);
                repClientes.procurarCliente(CPF).setProdutosLocadosQuantidade(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1);
               
                for(int i = 0; i <repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade(); i++)
                {
                    if(repClientes.procurarCliente(CPF).getProdutosLocados(i).equalsIgnoreCase("CD: "+ cd.getAlbum()))
                    {
                        repClientes.procurarCliente(CPF).setProdutosLocados(i, repClientes.procurarCliente(CPF).getProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1));
                        repClientes.procurarCliente(CPF).setProdutosLocados(repClientes.procurarCliente(CPF).getProdutosLocadosQuantidade()-1, "");
                    }
                }
         
        }
        else
        {
            throw new CNEException();
        }
    }

	public void quitarDivida(String CPF) throws CNEException {
		caixa = getCaixa() + repClientes.procurarCliente(CPF).getValorAtrasado();
		repClientes.procurarCliente(CPF).setValorAtrasado(0);

	}

	public double getCaixa() {
		return caixa;
	}

	public void locadoraAssaltada() // Easter egg
	{
		caixa = 0;
	}
	public String atendimento(Funcionario funcionario) {
		return "Obrigado pela preferência!!" + "\n" + "Você foi atendido por: " + funcionario.getNomeFuncionario();
	}

}
