package service;

import java.util.List;
import java.util.Optional;

import com.clibanez.crudspring.domain.Produto;
import com.clibanez.crudspring.exception.ObjectNotFoundException;
import com.clibanez.crudspring.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;

    /**
     * Metodo que busca o produto pelo seu id.
     * @param id do produto que será buscado.
     * @return o produto pelo seu id.
     */
	public Produto findById(Integer id) {
		Optional<Produto> produto = repo.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id: " + id + "Tipo: " + Produto.class.getName()));
	}

    /**
     * Metodo para lista todo os produtos.
     * @return lista de produtos.
     */
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
    /**
     * Metodo para salvar o produto.
     * @param produto salva o produto.
     * @return o produto salvo.
     */
	public Produto save(Produto produto) {
		produto.setId(null);
		return repo.save(produto);
	}
	
    /**
     * Metodo para atualizar o produto.
     * @param produto que será atualizado.
     * @return produto atualizado.
     */
	public Produto update(Produto produto) {
		Produto newProduto = findById(produto.getId());
		updateProduto(produto, newProduto);
		return repo.save(produto);
	}
	
    /**
     * Metodo para deletar o produto
     * @param id do produto que será deletado.
     */
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
    /**
     * Metodo para de produtos que serão atualizados
     * @param oldProduto a ser atualizado
     * @param newProduto atualizado.
     */
	private void updateProduto(Produto oldProduto, Produto newProduto) {
		newProduto.setNome(oldProduto.getNome());
		newProduto.setQuantidade(oldProduto.getQuantidade());
		newProduto.setValor(oldProduto.getValor());
	}
	
	
	


}
