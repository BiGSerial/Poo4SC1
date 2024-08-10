package data;

public class Patient {
	 	private String nome;
	    private String cpf;
	    private String dataNascimento;
	    private String historico;

	    public Patient(String nome, String cpf, String dataNascimento, String historico) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	        this.historico = historico;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public String getDataNascimento() {
	        return dataNascimento;
	    }

	    public String getHistorico() {
	        return historico;
	    }

	    public void setHistorico(String historico) {
	        this.historico = historico;
	    }

	   
}
