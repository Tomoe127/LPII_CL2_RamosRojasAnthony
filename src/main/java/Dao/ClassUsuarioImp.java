package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IUsuario;
import model.TblUsuariocl2;

public class ClassUsuarioImp implements IUsuario {

	public void RegistrarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		System.out.println("Usuario registrado");
		em.getTransaction().commit();
		em.close();
		
	}

	public void ActualizarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
		
	}

	public void EliminarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblUsuariocl2 elim = em.merge(usuario);
		em.remove(elim);
		System.out.println("Cliente eliminado");
		em.getTransaction().commit();
		em.close();
	}

	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 usuario) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblUsuariocl2 bususuario = em.find(TblUsuariocl2.class, usuario.getIdusuariocl2());
		em.getTransaction().commit();
		em.close();
		return bususuario;
	}

	public List<TblUsuariocl2> ListadoUsuario() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL2_RamosRojasAnthony");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblUsuariocl2> listadousuarios = em.createQuery("select c from TblUsuariocl2 c", TblUsuariocl2.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadousuarios;
	}

}
