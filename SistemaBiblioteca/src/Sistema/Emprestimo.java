package Sistema;

import java.util.ArrayList;

public class Emprestimo {
    private static int cod = 1;
    private int id;
    private final ArrayList<Livro> livros;
    private String dataEmprestimos;
    private String dataDevolucao;
    private boolean status;
    private String descricao;
    private double multa;
    private String dataDevolucaoReal;
    //Status e dat devolução

    public Emprestimo(String dataEmprestimos, String descricao) {
        this.setId();
        livros = new ArrayList<Livro>();
        this.setDataEmprestimos(dataEmprestimos);
        this.setStatus(status);
        this.setDescricao(descricao);
        this.setMulta(multa);
        Biblioteca biblioteca = Biblioteca.getInstancia();
    }

    public void realizaEmprestimo(UsuarioEspecial usuarioEspecial, Biblioteca biblioteca) {
        if (usuarioEspecial.getNivelBeneficio().equals("Usuário Diamante")) {
            if (getLivros().size() <= Constante.LIMITE_LIVROS_DIAMANTE) {
                int cont = 0;
                for (Livro liv : livros) {
                    for(Livro liv2: biblioteca.getLivros()){
                        if(liv == liv2){
                            cont++;
                        }
                    }
                }
                if(cont == livros.size()){
                    if (biblioteca.livrosDisponiveis.equals(livros)) {
                        ArrayList<Livro> livrosEmprestimos = this.livros;
                        System.out.println(livrosEmprestimos);
                        for (Livro livros : livrosEmprestimos) {
                            GerenciaLivro.tornarIndisponivel(livros, biblioteca);
                            System.out.println(livros.getDisponibilidade());
                        }
                    }
                }
            }
        } else {
            if (usuarioEspecial.getNivelBeneficio().equals("Usuário Elite")) {

            } else {
                if (usuarioEspecial.getNivelBeneficio().equals("Usuário Premium")) {

                } else {
                    if (usuarioEspecial.getNivelBeneficio().equals("Usuário Plus")) {
                    } else {
                        if (usuarioEspecial.getNivelBeneficio().equals("Usuário Básico")) {

                        }
                    }
                }
            }
        }
    }


    public void addLivros(Livro liv) {
        this.livros.add(liv);
    }

    public void removeLivros(Livro liv) {
        this.livros.remove(liv);
    }

    private void setId() {
        this.id = Usuario.cod++;
    }

    public boolean setDataEmprestimos(String dataEmprestimos) {
        if (!dataEmprestimos.isBlank()) {
            this.dataEmprestimos = dataEmprestimos;
            return true;
        } else return false;
    }

    public boolean setDataDevolucao(String dataDevolucao) {
        if (!dataDevolucao.isBlank()) {
            this.dataDevolucao = dataDevolucao;
            return true;
        } else return false;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean setDescricao(String descricao) {
        if (!descricao.isBlank()) {
            this.descricao = descricao;
            return true;
        } else return false;
    }

    public boolean setMulta(double multa) {
        if (multa > 0) {
            this.multa = multa;
            return true;
        } else return false;
    }

    public boolean setDataDevolucaoReal(String dataDevolucaoReal) {
        if (!dataDevolucaoReal.isBlank()) {
            this.dataDevolucaoReal = dataDevolucaoReal;
            return true;
        } else return false;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public String getDataDevolucao() {
        return this.dataDevolucao;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDataEmprestimos() {
        return this.dataEmprestimos;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getMulta() {
        return this.multa;
    }

    public String getDataDevolucaoReal() {
        return this.dataDevolucaoReal;
    }

    public String imprimeLivros() {
        String texto = "";
        for (Livro liv : livros) {
            texto += liv.getTitulo();
        }
        return texto;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\n" +
                "Data do emprestimo: " + this.getDataEmprestimos() + "\n" +
                "Data da devolução: " + this.getDataDevolucao() + "\n" +
                "Status: " + this.getStatus() + "\n" +
                "Descrição: " + this.getDescricao() + "\n" +
                "Multa: " + this.getMulta() + "\n" +
                "Data real da devolução: " + this.getDataDevolucaoReal() + "\n";

    }
}

