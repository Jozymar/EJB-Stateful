<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
    </head>
    <body>
        <h1>Carrinho</h1>

        <form action="carrinho" method="GET">
            <input type="text" name="produto" />
            <input type="hidden" name="action" value="add" />
            <input type="submit" name="+" value="+"/>
        </form>

        <table>
            <thead>
                <tr>
                    <th>Produto</th>
                    <th colspan=2>Excluir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="produto">
                    <tr>
                        <td><c:out value="${produto}" /></td>
                        <td>
                            <form action="carrinho" method="GET">
                                <input type="hidden" name="produto" value="${produto}" />
                                <input type="hidden" name="action" value="rem" />
                                <input type="submit" name="-" value="-" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <form action="carrinho" method="GET">
            <input type="hidden" name="action" value="fim" />
            <input type="submit" name="finalizar" value="finalizar" />
        </form>
    </body>
</html>
