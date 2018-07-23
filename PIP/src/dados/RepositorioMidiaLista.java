package dados;

import base.Filme;
import base.Midia;
import base.Seriado;
import excecoes.AtualizacaoIncompativelException;
import excecoes.JNEException;
import excecoes.ProdutoInexistenteException;

public class RepositorioMidiaLista implements RepositorioMidiaInterface
{
	private Midia midia;
	private RepositorioMidiaLista proximo;
	
	public RepositorioMidiaLista()
	{
		this.midia = null;
		this.proximo = null;
	}
	
	public boolean existeMidia(String nome)
	{
		boolean existe = true;
		if(this.midia != null)
		{
			if(this.midia.getNome().equalsIgnoreCase(nome))
			{
				return existe = true;
			}
			else
			{
				return existe = this.proximo.existeMidia(nome);
			}
		}
		
		if(this.midia == null)
		{
			return existe = false;
		}
		return existe;
	}
	
	public void inserirMidia(Midia midia)
	{
		if(this.midia == null)
		{
			this.midia = midia;
			this.proximo = new RepositorioMidiaLista();
		}
		else
		{
			this.proximo.inserirMidia(midia);
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
	
	public Midia procurarMidia(String nome)throws ProdutoInexistenteException
	{
		if(this.midia != null)
		{
			if(this.midia.getNome().equalsIgnoreCase(nome))
			{
				return this.midia;
			}
			else
			{
				return this.proximo.procurarMidia(nome);
			}
		}
		
		if(this.proximo == null)
		{
			throw new ProdutoInexistenteException();
		}
		return this.midia;
	}
	
	public void removerMidia(Midia midia) throws ProdutoInexistenteException
	{
		if (this.midia != null) {
			if (this.midia.equals(midia)) {
				if (this.proximo == null) {
					this.midia = null;
				} else if (this.proximo.proximo == null) {
					this.midia = this.proximo.midia;
					this.proximo = null;
				} else {
					this.midia = this.proximo.midia;
					this.proximo = this.proximo.proximo;
				}
			} else {
				this.proximo.removerMidia(midia);
			}
		} else {
			throw new ProdutoInexistenteException();
		}
	}
	
	public static void main(String args[])
	{
		RepositorioMidiaLista A = new RepositorioMidiaLista();
		Midia a = new Filme("a" , "b ", "c" ,1 ,2,3);
		
		A.inserirMidia(a);
		
		System.out.println(A.existeMidia("a"));
	}
}
