package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProducto;
import model.TblProductocl2;

public class ClassProductoImp implements IProducto{

	public void RegistrarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(producto);
		System.out.println("Producto registrado");
		em.getTransaction().commit();
		em.close();
	}

	public void ActualizarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.merge(producto);
		em.getTransaction().commit();
		em.close();
	}

	public void EliminarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblProductocl2 elim = em.merge(producto);
		em.remove(elim);
		System.out.println("Producto eliminado");
		em.getTransaction().commit();
		em.close();
	}

	public TblProductocl2 BuscarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblProductocl2 busproducto = em.find(TblProductocl2.class, producto.getIdproductocl2());
		em.getTransaction().commit();
		em.close();
		return busproducto;
	}

	public List<TblProductocl2> ListadoProducto() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl2> listadoproductos = em.createQuery("select c from TblProductocl2 c", TblProductocl2.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadoproductos;
	}

}
