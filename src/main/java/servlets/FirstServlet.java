package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.Cart;
import java.io.IOException;

@WebServlet(name = "servlets.FirstServlet", value = "/servlets.FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (cart == null) {
            cart = new Cart();
        }
        cart.setProduct(product);
        cart.setQuantity(quantity);
        session.setAttribute("cart", cart);

        // forward
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
