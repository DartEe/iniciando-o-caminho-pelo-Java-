package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }
    
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }
    
    public void alterar(PessoaFisica pessoaFisica) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == pessoaFisica.getId()) {
                pf.setNome(pessoaFisica.getNome());
                pf.setCpf(pessoaFisica.getCpf());
                pf.setIdade(pessoaFisica.getIdade());
                break;
            }
        }
    }
    
    public void excluir(int id) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == id) {
                pessoasFisicas.remove(pf);
                break;
            }
        }
    }
    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    
    public void persistir(String arquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pessoasFisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
        } catch (IOException e) {
            System.err.println("Erro ao armazenar dados: " + e.getMessage());
        }
    }

    public void recuperar(String arquivo) {
        try (FileInputStream fileIn = new FileInputStream(arquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
            System.out.println("Dados de Pessoa Fisica Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}