package TestEntidades;

import Dao.ClassProductoImp;
import model.TblProductocl2;

public class TestEntidadProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl2("Laptop HP Pavilion");
		producto.setPrecioventacl2(750);
		producto.setPreciocompcl2(650);
		producto.setEstadocl2("nuevo");
		producto.setDescripcl2("Laptop HP Pavilion con procesador Intel Core i5, 8GB de RAM y 512GB de SSD. Ideal para trabajo y entretenimiento");
		crud.RegistrarProducto(producto);

	}

}
