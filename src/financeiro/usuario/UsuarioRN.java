package financeiro.usuario;

import java.util.List;

import financeiro.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDao usuarioDao;

	public UsuarioRN(){
		this.usuarioDao = DAOFactory.criarUsuarioDao();
	}
	
	public void salvar(Usuario usuario){
		Integer id = usuario.getId();
		if(id == null || id == 0){
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDao.salva(usuario);
		}else{
			this.usuarioDao.atualiza(usuario);
		}
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDao.carrega(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDao.buscaPorLogin(login);
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDao.exclui(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDao.listar();
	}
}
