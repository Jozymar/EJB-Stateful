package com.ifpb.edu.jsf;

import com.ifpb.edu.shared.Carrinho;
import com.ifpb.edu.shared.ServiceLocator;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ControladorCarrinho implements Serializable {

    private String produto;
    private Carrinho carrinho;

    @PostConstruct
    public void init() {
        carrinho = new ServiceLocator().lookup("host-core", "3700", "java:global/core-stateful/CarrinhoOnline");
    }

    public String add() {
        this.carrinho.adicionarProduto(produto);
        this.produto = "";
        return null;
    }

    public String remove(String produtoSelecionado) {
        this.carrinho.removerProduto(produtoSelecionado);
        return null;
    }

    public String finalizar() {
        this.carrinho.finalizarCompra();
        encerrarSessao();
        return null;
    }

    public List<String> todosOsprodutos() {
        return this.carrinho.todosOsProdutos();
    }

    private void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        if (session != null) {
            session.invalidate();
        }
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
