package financeiro.usuario;

import java.util.List;

public interface UsuarioDao {

	public void salva(Usuario usuario);
	public void atualiza(Usuario usuario);
	public void exclui(Usuario usuario);
	public Usuario carrega(Integer codigo);
	public Usuario buscaPorLogin(String login);
	public List<Usuario> listar();
}
