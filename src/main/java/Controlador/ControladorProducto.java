package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		List<TblProductocl2> listadoproducto = crud.ListadoProducto();
		
		request.setAttribute("listadodeproductos", listadoproducto);
		request.getRequestDispatcher("/RegistroProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		double precioventa = Double.parseDouble(request.getParameter("precioventa"));
		double preciocompra = Double.parseDouble(request.getParameter("preciocompra"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl2(nombre);
		producto.setPrecioventacl2(precioventa);
		producto.setPreciocompcl2(preciocompra);
		producto.setEstadocl2(estado);
		producto.setDescripcl2(descripcion);
		
		crud.RegistrarProducto(producto);
		
		List<TblProductocl2> listadoproducto = crud.ListadoProducto();
		
		request.setAttribute("listadodeproductos", listadoproducto);
		
		request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
		
		
		
	}

}
