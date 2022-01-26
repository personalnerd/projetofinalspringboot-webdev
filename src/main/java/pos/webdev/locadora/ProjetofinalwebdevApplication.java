package pos.webdev.locadora;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.jpa.dao.DAOVeiculo;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;
import pos.webdev.locadora.model.Veiculo;

@SpringBootApplication
public class ProjetofinalwebdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetofinalwebdevApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IRepositorioCliente repoCliente, IRepositorioUsuario repoUsuario, IRepositorioVeiculo repoVeiculo) {
		return (args) -> {
			DAOCliente dc = new DAOCliente(repoCliente);
			dc.inserirCliente(new Cliente("Joao da Silva", "12345678912", "41 98769876"));
			dc.inserirCliente(new Cliente("Maria Fernanda", "98765432121", "61 98763214"));
			
			DAOVeiculo dv = new DAOVeiculo(repoVeiculo);
			dv.inserirVeiculo(new Veiculo("Up", "VW", "2019", "Preto"));
			dv.inserirVeiculo(new Veiculo("Ka", "Ford", "2020", "Cinza"));
			dv.inserirVeiculo(new Veiculo("Civic", "Honda", "2019", "Preto"));
			
			DAOUsuario du = new DAOUsuario(repoUsuario);
			du.inserirUsuario(new Usuario("Usuario", "user", "123", "61 99898979"));
		};
	}
}
