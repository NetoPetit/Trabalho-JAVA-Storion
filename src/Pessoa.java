public abstract class Pessoa {
    private String nome;
    private Integer idade;
    private String sexo;

    public String getNome(){
        return this.nome;
    };
    public void setNome(String nome){
        this.nome = nome;
    }
    public Integer getIdade(){
        return this.idade;
    }
    public void setIdade(Integer idade){
        this.idade = idade;
    }
    public String getSexo(){
        return this.sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
}
