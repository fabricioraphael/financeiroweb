package financeiro.util;

import financeiro.usuario.*;

public class DAOFactory {

	public static UsuarioDao criarUsuarioDao(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
