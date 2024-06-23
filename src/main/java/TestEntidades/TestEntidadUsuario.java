package TestEntidades;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl2;

public class TestEntidadUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblUsuariocl2 usuario = new TblUsuariocl2();
		ClassUsuarioImp crud = new ClassUsuarioImp();
		
		usuario.setUsuariocl2("ruth123");
		usuario.setPasswordcl2("123456");
		crud.RegistrarUsuario(usuario);

	}

}
