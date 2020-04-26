package questaodois;

public class Pais {
    private String nome;
    private String nome_capital;
    private int dimensao;
    private Pais[] fronteiras;

    public Pais(String nome, String nome_capital, int dimensao) {
        this.nome = nome;
        this.nome_capital = nome_capital;
        this.dimensao = dimensao;
    }

        public String getNome() {
        return nome;
    }

        public void setNome(String nome) {
        this.nome = nome;
    }

        public String getNome_capital() {
        return nome_capital;
    }

       public void setNome_capital(String nome_capital) {
        this.nome_capital = nome_capital;
    }

        public int getDimensao() {
        return dimensao;
    }

        public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }
    
    public boolean equals(final Pais outro){
        boolean retorno = false;
        
        String nome_pais = this.nome;
        String nome_capital_pais = this.nome_capital;
        
        String nome_outro_pais = outro.getNome();
        String nome_capital_outro_pais = outro.getNome_capital();
        
        if(nome_pais.equals(nome_outro_pais) && 
                (nome_capital_pais.equals(nome_capital_outro_pais))){
            retorno = true;
        }
        
        return retorno;
    }
    
    public void defineFronteira(Pais... paises){
        
        int quantidadePaisesIguais = 0;
        for(int i=0;i<paises.length;i++){
            if(this.equals(paises[i])){
                quantidadePaisesIguais++;
            }
        }
        
        this.fronteiras = new Pais[paises.length - quantidadePaisesIguais];
        int idxFronteira = 0;
        for(int i=0;i< paises.length;i++){
            if(!this.equals(paises[i])){
                this.fronteiras[idxFronteira] = paises[i];
                idxFronteira++;
            }
        }
        
    }
    
    public Pais[] getFronteiras(){
        return this.fronteiras;
    }

    public Pais[] vizinhosEmComum(Pais outro) {
        int totaisIguais = 0;
        
        
        for (Pais fronteiraPais : this.fronteiras) {
            for (Pais fronteiraOutro : outro.fronteiras) {
                if (fronteiraPais.equals(fronteiraOutro)) {
                    totaisIguais++;
                }
            }
        }

        if (totaisIguais > 0) {
            int idxVizinhos = 0;
            Pais[] mesmosVizinhos = new Pais[totaisIguais];
            for (Pais fronteiraPais : this.fronteiras) {
                for (Pais fronteiraOutro : outro.fronteiras) {
                    if (fronteiraPais.equals(fronteiraOutro)) {
                        mesmosVizinhos[idxVizinhos] = fronteiraOutro;
                        idxVizinhos++;
                    }
                }
            }

            return mesmosVizinhos;
        }
        return null;
    }    
    
}
    
    

