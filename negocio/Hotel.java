
package org.negocio;
import org.dados.Repo_Cliente;
import org.dados.Repo_Reserva;
import org.dados.Repo_Quarto;
import org.dados.Repo_Func;
import java.util.ArrayList;
import org.negocio.excecoes.*;
public class Hotel {
private NegocioCliente clientes;
private NegocioReserva reservas;
private NegocioQuarto quartos;
private NegocioFunc funcionarios;

public Hotel(){
    this.clientes = new NegocioCliente(new Repo_Cliente());
    this.reservas = new NegocioReserva(new Repo_Reserva());
    this.quartos = new NegocioQuarto(new Repo_Quarto());
    this.funcionarios =  new NegocioFunc(new Repo_Func());
}

public boolean login_func(String usu, String senha) throws LoginException{
    boolean result = funcionarios.verificaLogin(usu, senha);
    if(result==true){
        return true;
    }else{
        throw new LoginException();
    }
}

public String tipo_quarto(int id){
    return quartos.tipo_quarto(id);
}
public boolean login_cliente(String usu, String senha) throws LoginException{
    boolean result = clientes.verificaLogin(usu, senha);
    if(result==true){
        return true;
    }else{
        throw new LoginException();
    }
}

public void adicionar_cliente(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, int cartao) throws ItemExisteException{
    Cliente c =  new Cliente(cpf,nome,data_nascimento,sexo, cep, usuário,senha,cartao);
    clientes.add_cliente(c);
}

public void atualizar_cliente(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, int cartao) throws ItemNaoEncontradoException{
    clientes.atualiza_cliente(cpf, nome, data_nascimento, sexo, cep, usuário, senha, cartao);
}
public void excluir_cliente(int id)throws ItemNaoEncontradoException{
    clientes.excluir_cliente(id);
}
public ArrayList<Cliente> consulta_clientes() throws RepoVazioException{
    return clientes.ver_clientes();
}

public ArrayList<Reserva> consulta_reservas() throws RepoVazioException{
    return reservas.ver_reserva();
}

public void atualizar_reserva(int cod_reserva, String data_checkin, String data_checkout, int cpf, int id_quarto) throws RepoVazioException,ItemNaoEncontradoException,DataPassadoException, QuartoOcupadoException, DataException{
    reservas.atualiza_reserva(cod_reserva,  data_checkin,  data_checkout,  cpf,  id_quarto,quartos.consulta_quartos());
}
public void adicionar_reserva(String data_checkin, String data_checkout, int cpf, int id_quarto) throws ItemNaoEncontradoException,DataException, ItemExisteException, DataPassadoException, QuartoOcupadoException, RepoVazioException{
    Reserva r = new Reserva(data_checkin, data_checkout, cpf, id_quarto);
    reservas.add_reserva(r,quartos.consulta_quartos());
}
public void excluir_reserva(int codigo) throws ItemNaoEncontradoException{
    reservas.excluir_reserva(codigo);
}
public ArrayList<Quarto> ver_quartos() throws RepoVazioException{
    return quartos.consulta_quartos();
}
public void adicionar_quartoBasic(int id_quarto,String estado, int capacidade, float preco,String andar, boolean alimentação) throws ItemExisteException{
    QuartoBasic q = new QuartoBasic(id_quarto,estado, capacidade, preco,andar, alimentação);
    quartos.add_quarto(q);
}

public void adicionar_quartoPremium(int id_quarto,String estado, int capacidade, float preco,String andar,boolean serviço_de_quarto,boolean sauna,boolean piscina,boolean alimentação,boolean vista) throws ItemExisteException{
    QuartoPremium q = new QuartoPremium( id_quarto,estado,capacidade, preco,andar, serviço_de_quarto, sauna,piscina,alimentação,vista);
    quartos.add_quarto(q);
}

public void atualizar_quartoPremium(int id_quarto, String estado, int capacidade, float preco,String andar,boolean serviço_de_quarto,boolean sauna,boolean piscina,boolean alimentação,boolean vista) throws ItemNaoEncontradoException{
    quartos.altera_quartoPremium(id_quarto, estado, capacidade,preco, andar, serviço_de_quarto, sauna, piscina, alimentação, vista);
}

public void atualizar_quartoBasic(int id_quarto, String estado, int capacidade, float preco,String andar,boolean alimentação) throws ItemNaoEncontradoException{
    quartos.altera_quartoBasic(id_quarto, estado, capacidade,preco, andar, alimentação);
}
public void excluir_quarto(int id) throws ItemNaoEncontradoException{
    quartos.excluir_quarto(id);
}
public ArrayList<Funcionário> consulta_func() throws RepoVazioException{
    return funcionarios.ver_func();
}
public void adicionar_func(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, String estado) throws ItemExisteException{
    Funcionário f = new Funcionário(cpf,nome,data_nascimento,sexo,cep,usuário,senha,estado);
    funcionarios.add_func(f);
}

public void atualizar_func(int cpf, String nome, String data_nascimento, char sexo, String cep, String usuário, String senha, String estado) throws ItemNaoEncontradoException{
    funcionarios.atualiza_func(cpf, nome, data_nascimento, sexo, cep, usuário, senha, estado);
}
public void excluir_func(int cpf) throws ItemNaoEncontradoException{
    funcionarios.excluir_func(cpf);
}
}
