package dados;

import base.Filme;
import base.Midia;
import base.Seriado;
import excecoes.ArrayCheioException;
import excecoes.AtualizacaoIncompativelException;
import excecoes.ProdutoInexistenteException;

public class RepositorioMidiaArray implements RepositorioMidiaInterface
{
	private Midia[] midia;
	private int indice;
	private int tamanho;

	public RepositorioMidiaArray(int tamanho)
	{
		this.midia = new Midia[tamanho];
		this.indice = 0;
		this.tamanho = tamanho;
	}
	
	private int getIndice(String nome)
	{
		String n;
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i< this.indice))
		{
			n = midia[i].getNome();
			if(n.equals(nome))
			{
				achou = true;
			}
			else
			{
				i++;
			}
		}
		return i;
	}
	
	public void inserirMidia(Midia midia) throws ArrayCheioException 
	{
		if(this.indice < this.tamanho)
		{
			this.midia[indice] = midia;
			indice++;
		}
		else
		{
			throw new ArrayCheioException();
		}
	}

	public void atualizarMidia(Midia midiaAntiga, Midia midiaNova) throws ProdutoInexistenteException, AtualizacaoIncompativelException 
	{
		midiaAntiga = procurarMidia(midiaAntiga.getNome());
		if((midiaAntiga instanceof Filme && midiaNova instanceof Seriado) || (midiaAntiga instanceof Seriado && midiaNova instanceof Filme))
		{
			throw new AtualizacaoIncompativelException();
		}
		
		midiaAntiga.setNome(midiaNova.getNome());
		midiaAntiga.setDescricao(midiaNova.getDescricao());
		midiaAntiga.setNota(midiaNova.getNota());
		midiaAntiga.setPreco(midiaNova.getPreco());
		if(midiaAntiga instanceof Filme)
		{
			((Filme) midiaAntiga).setQuantidadeDisponivel(((Filme) midiaNova).getQuantidadeDisponivel());
		}
		else
		{
			((Seriado) midiaAntiga).setEpisodiosTemporadas(((Seriado) midiaNova).getEpisodiosTemporadas());
			((Seriado) midiaAntiga).setNumeroTemporadas(((Seriado) midiaNova).getNumeroTemporadas());
			((Seriado) midiaAntiga).setDisponibilidadeTemporada(((Seriado) midiaNova).getDisponibilidadeTemporada());
		}
	}

	public Midia procurarMidia(String nome) throws ProdutoInexistenteException
	{
		int aux = 0;
		for (int i=0; i<indice; i++)
		{
			aux++;
			if(this.midia[i] != null)
			{
				if(this.midia[i].getNome().equalsIgnoreCase(nome))
				{
					return this.midia[i];
				}
			}
			else
			{
				throw new ProdutoInexistenteException();
			}
		}
		return this.midia[aux];
	}

	public void removerMidia(Midia midia) throws ProdutoInexistenteException
	{
		int i = this.getIndice(midia.getNome());
		if(i == this.indice)
		{
			throw new ProdutoInexistenteException();
		}
		else
		{
			this.indice--;
			this.midia[i] = midia;
		}
	}

	public boolean existeMidia(String nome) 
	{
		int i = this.getIndice(nome);
		return (i != this.indice);
	}
}
