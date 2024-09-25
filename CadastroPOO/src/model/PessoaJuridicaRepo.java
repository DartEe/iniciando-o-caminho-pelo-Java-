package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList<>();
    }
    
    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }
    
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (PessoaJuridica pj : pessoasJuridicas) {
            if (pj.getId() == pessoaJuridica.getId()) {
                pj.setNome(pessoaJuridica.getNome());
                pj.setCnpj(pessoaJuridica.getCnpj());
                break;
            }
        }
    }
    
    public void excluir(int id) {
        for (PessoaJuridica pj : pessoasJuridicas) {
            if (pj.getId() == id) {
                pessoasJuridicas.remove(pj);
                break;
            }
        }
    }
    
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : pessoasJuridicas) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String arquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pessoasJuridicas);
            System.out.println("Dados de Pessoa Juridica armazenados.");
        } catch (IOException e) {
            System.err.println("Erro ao armazenar dados: " + e.getMessage());
        }
    }

    public void recuperar(String arquivo) {
        try (FileInputStream fileIn = new FileInputStream(arquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
            System.out.println("Dados de Pessoa Juridica Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}