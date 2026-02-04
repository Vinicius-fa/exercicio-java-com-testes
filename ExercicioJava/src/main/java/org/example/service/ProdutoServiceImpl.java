package org.example.service;

import org.example.model.Produto;
import org.example.repository.ProdutoRepositoryImpl;
import org.example.repository.ProdutoRepository;
import java.sql.SQLException;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository repository = new ProdutoRepositoryImpl();

    @Override
    public Produto cadastrarProduto(Produto produto) throws SQLException {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preco deve ser positivo.");
        }
        return repository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Produto buscarPorId(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public Produto atualizarProduto(Produto produto, int id) throws SQLException {
        produto.setId(id);
        return repository.update(produto);
    }

    @Override
    public boolean excluirProduto(int id) throws SQLException {
        if (repository.findById(id) != null) {
            repository.findById(id);
            return true;
        }
        return false;
    }
}
