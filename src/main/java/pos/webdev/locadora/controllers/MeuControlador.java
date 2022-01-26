package pos.webdev.locadora.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import pos.webdev.locadora.ProjetofinalwebdevApplication;
import pos.webdev.locadora.jpa.IRepositorioAluguel;
import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.jpa.dao.DAOAluguel;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.jpa.dao.DAOVeiculo;
import pos.webdev.locadora.model.Aluguel;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;
import pos.webdev.locadora.model.Veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeuControlador {
    
    public static void main(String[] args) {
        SpringApplication.run(ProjetofinalwebdevApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;
    
    @RequestMapping("/")
    public String index() {
        return "login";
    }    

    @RequestMapping("/logout")
    public String usuarioLogado(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView efetuarLogin(@RequestParam(value="login", required=false) String login, @RequestParam(value="senha", required=false) String senha, HttpSession session, Usuario usuario) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") != null) {
            mv.setViewName("home");
        } else {
            IRepositorioUsuario repoUsuario = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repoUsuario);
            Usuario UsuarioObj = daoUsuario.buscarUsuarioPorLogin(String.valueOf(login));
            String usuarioLogin = null;
            String usuarioSenha = null;
            String usuarioNome = null;
            Long usuarioId = null;
            
            if (UsuarioObj == null) {
                mv.setViewName("login");
            } else {                
                usuarioLogin = UsuarioObj.getLogin();
                usuarioSenha = UsuarioObj.getSenha();
                usuarioNome = UsuarioObj.getNome();
                usuarioId = UsuarioObj.getId();
                
                if(usuarioLogin.equals(login) && usuarioSenha.equals(senha)) {
                    session.setAttribute("usuarioLogado", usuarioNome);
                    session.setAttribute("idUsuarioLogado", usuarioId);

                    mv.setViewName("home");
                } else {
                    mv.setViewName("login");
                }            
            }            
        }
        return mv;
    }
    
    @RequestMapping("/cliente/cadastrar")
    public String clienteCadastrar(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else {
            return "cliente/cadastrar";
        }
    }
 
    @RequestMapping("/cliente/cadastrado")
    public ModelAndView clienteCadastrado(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            ArrayList<String> ultimoClienteCadastrado = new ArrayList<String>();
            ultimoClienteCadastrado.add(nome);
            ultimoClienteCadastrado.add(cpf);
            ultimoClienteCadastrado.add(telefone);
            
            session.setAttribute("ultimoClienteCadastrado", ultimoClienteCadastrado);            
            
            Cliente cliente = new Cliente(nome, cpf, telefone);
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            daoCliente.inserirCliente(cliente);

            mv.setViewName("cliente/cadastrado");
        }
        return mv;
    }

    @RequestMapping("/cliente/relatorio")
    public ModelAndView clienteRelatorio(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            List<Cliente> clientes = daoCliente.buscarClientes();
            mv.addObject("clientes", clientes);
            mv.setViewName("cliente/relatorio");
        }
        return mv;
    }

    @RequestMapping("/veiculo/cadastrar")
    public String veiculoCadastrar( HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else { return "veiculo/cadastrar"; }
    }
    
    @RequestMapping("/veiculo/cadastrado")
    public ModelAndView veiculoCadastrado(@RequestParam String modelo, @RequestParam String fabricante, @RequestParam String ano, @RequestParam String cor, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            ArrayList<String> ultimoVeiculoCadastrado = new ArrayList<String>();
            ultimoVeiculoCadastrado.add(modelo);
            ultimoVeiculoCadastrado.add(fabricante);
            ultimoVeiculoCadastrado.add(ano);
            ultimoVeiculoCadastrado.add(cor);
            
            session.setAttribute("ultimoVeiculoCadastrado", ultimoVeiculoCadastrado);
            
            Veiculo veiculo = new Veiculo(modelo, fabricante, ano, cor);
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            daoVeiculo.inserirVeiculo(veiculo);

            mv.setViewName("veiculo/cadastrado");
        }
        return mv;
    }

    @RequestMapping("/veiculo/relatorio")
    public ModelAndView veiculoRelatorio(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            List<Veiculo> veiculos = daoVeiculo.buscarVeiculos();
            mv.addObject("veiculos", veiculos);
            mv.setViewName("veiculo/relatorio");
        }
        return mv;
    }

    @RequestMapping("/usuario/cadastrar")
    public String usuarioCadastrar(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else { return "usuario/cadastrar"; }
    }
    
    @RequestMapping("/usuario/cadastrado")
    public ModelAndView usuarioCadastrado(@RequestParam String nome, @RequestParam String telefone, @RequestParam String login, @RequestParam String senha, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            ArrayList<String> ultimoUsuarioCadastrado = new ArrayList<String>();
            ultimoUsuarioCadastrado.add(nome);            
            ultimoUsuarioCadastrado.add(telefone);
            ultimoUsuarioCadastrado.add(login);
            ultimoUsuarioCadastrado.add(senha);
            
            session.setAttribute("ultimoUsuarioCadastrado", ultimoUsuarioCadastrado);   

            Usuario usuario = new Usuario(nome, login, senha, telefone);
            IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repo);
            daoUsuario.inserirUsuario(usuario);

            mv.setViewName("usuario/cadastrado");
        }
        return mv;
    }

    @RequestMapping("/usuario/relatorio")
    public ModelAndView usuarioRelatorio(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repo);
            List<Usuario> usuarios = daoUsuario.buscarUsuarios();
            mv.addObject("usuarios", usuarios);
            mv.setViewName("usuario/relatorio");
        }
        return mv;
    }

    @RequestMapping("/veiculo/alugar")
    public ModelAndView veiculoAlugar(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            IRepositorioCliente repoCliente = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repoCliente);
            List<Cliente> clientes = daoCliente.buscarClientes();
            mv.addObject("clientes", clientes);

            IRepositorioVeiculo repoVeiculo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repoVeiculo);
            List<Veiculo> veiculos = daoVeiculo.buscarVeiculos();
            mv.addObject("veiculos", veiculos);
            
            mv.setViewName("veiculo/alugar");
        }
        return mv;
    }

    @RequestMapping("/veiculo/alugado")
    public ModelAndView veiculoAlugado(@RequestParam Long cliente, @RequestParam Long veiculo, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            mv.setViewName("login");
        } else {
            IRepositorioCliente repoCliente = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repoCliente);
            Cliente clienteObj = daoCliente.buscaClientePorId(Long.valueOf(cliente));
            
            Long usuario = (Long) session.getAttribute("idUsuarioLogado");
            IRepositorioUsuario repoUsuario = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repoUsuario);
            Usuario usuarioObj = daoUsuario.buscarUsuarioPorId(Long.valueOf(usuario));
            
            IRepositorioVeiculo repoVeiculo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repoVeiculo);
            Veiculo veiculoObj = daoVeiculo.buscarVeiculoPorId(Long.valueOf(veiculo));
            
            Aluguel aluguel = new Aluguel(clienteObj, usuarioObj, veiculoObj);
            IRepositorioAluguel repoAluguel = context.getBean(IRepositorioAluguel.class);
            DAOAluguel daoAluguel = new DAOAluguel(repoAluguel);
            daoAluguel.inserirAluguel(aluguel);
            
            mv.addObject("clienteObj", clienteObj);
            mv.addObject("usuarioObj", usuarioObj);
            mv.addObject("veiculoObj", veiculoObj);

            mv.setViewName("veiculo/alugado");
        }
        return mv;
    }    
}