package com.ifpb.edu.web;

import com.ifpb.edu.shared.Carrinho;
import com.ifpb.edu.shared.ServiceLocator;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCarrinho", urlPatterns = {"/carrinho"})
public class ServletCarrinho extends HttpServlet {

    private Carrinho carrinho
            = new ServiceLocator()
                    .lookup("host-core", "3700", "java:global/core-stateful/CarrinhoOnline");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            String produto = request.getParameter("produto");
            carrinho.adicionarProduto(produto);

            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            request.setAttribute("produtos", carrinho.todosOsProdutos());
            dis.forward(request, response);
        } else if (action.equalsIgnoreCase("rem")) {
            String produto = request.getParameter("produto");
            carrinho.removerProduto(produto);

            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
            request.setAttribute("produtos", carrinho.todosOsProdutos());
            dis.forward(request, response);
        } else if (action.equalsIgnoreCase("fim")) {
            carrinho.finalizarCompra();
            response.sendRedirect("index.jsp");
        }
    }

}
