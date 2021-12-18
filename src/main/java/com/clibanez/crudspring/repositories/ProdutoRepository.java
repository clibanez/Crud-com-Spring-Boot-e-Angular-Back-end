package com.clibanez.crudspring.repositories;

import com.clibanez.crudspring.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
