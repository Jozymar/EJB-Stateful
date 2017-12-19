package com.ifpb.edu.core;

import com.ifpb.edu.shared.Carrinho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoOnline implements Carrinho {

    private List<String> produtos = new ArrayList<>();

    @Override
    public void adicionarProduto(String produto) {
        this.produtos.add(produto);
    }

    @Override
    public void removerProduto(String produto) {
        this.produtos.remove(produto);
    }

    @Override
    public List<String> todosOsProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    @Override
    public void finalizarCompra() {
        for (int i = 0; i < produtos.size(); i++) {
            String get = produtos.get(i);
            System.out.println(i + " - " + get);
        }
    }

}
