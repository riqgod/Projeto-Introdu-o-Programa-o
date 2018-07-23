package base;

public class Cliente {

	
	private String nome;
	private String CPF;
	private String telefone;
	private double ValorAtrasado;
	private String[] ProdutosLocados;
	private int ProdutosLocadosQuantidade;
	
	
	
	public Cliente(String nome,String CPF, String telefone){
		
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.ValorAtrasado = 0;
		ProdutosLocados = new String[10];
	
		this.ProdutosLocadosQuantidade = 0;
		
		
	}
	
	public int getProdutosLocadosQuantidade(){
		return ProdutosLocadosQuantidade;
	}
	public void setProdutosLocadosQuantidade(int ProdutosLocados){
		this.ProdutosLocadosQuantidade = ProdutosLocados;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getValorAtrasado() {
		return ValorAtrasado;
	}
	
	public void setValorAtrasado(double d) {
		this.ValorAtrasado = d;
	}
	
	public String getProdutosLocados(int aux) {

		return ProdutosLocados[aux];
	}

	public void setProdutosLocados(int aux, String midiaLocada) {
		ProdutosLocados[aux] = midiaLocada;
	}
	
	public String toString(){
		String retorno = "";
		String retorno2 = "Midias Locadas: ";
		retorno += "Cliente: " + getNome() +"; CPF: "+ getCPF() + "; Tel: "+getTelefone() +"; Valor em Débito:R$ "+ getValorAtrasado()+ "; Quantidade de Produtos Locados: "+ getProdutosLocadosQuantidade(); 
		if(getProdutosLocadosQuantidade()==0){
			retorno2 += "Nenhum";
		}else{
		for(int i = 0; i<getProdutosLocadosQuantidade(); i++){
				retorno2 += ProdutosLocados[i] + "\n";
		}
		}
		return retorno+"\n"+retorno2;
		
	}
}


	
	