package financeiro.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class UsuarioDAOHibernate implements UsuarioDao{
	
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salva(Usuario usuario) {
		this.session.save(usuario);
	}

	@Override
	public void atualiza(Usuario usuario) {
		if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
			Usuario usuarioPermissao = this.carrega(usuario.getId());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	@Override
	public void exclui(Usuario usuario) {
		this.session.delete(usuario);		
	}

	@Override
	public Usuario carrega(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}
}