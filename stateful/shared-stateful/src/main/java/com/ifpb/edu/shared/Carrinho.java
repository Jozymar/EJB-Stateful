package com.ifpb.edu.shared;

import java.util.List;

public interface Carrinho {

    void adicionarProduto(String produto);

    void removerProduto(String produto);

    List<String> todosOsProdutos();

    void finalizarCompra();

}
