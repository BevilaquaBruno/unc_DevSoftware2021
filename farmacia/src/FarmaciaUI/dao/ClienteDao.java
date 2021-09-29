package FarmaciaUI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import FarmaciaUI.MySqlSingleton;
import FarmaciaUI.models.Cliente;

public class ClienteDao {
	private Connection connection;
	
	public ClienteDao() {
		this.connection = MySqlSingleton.getConnection();
	}
	
	public boolean inserir(Cliente cliente) {
		String sql = "INSERT INTO unc_farmacia.cliente (nome, cpf, rg, telefone) VALUES (?, ?, ?, ?);";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTelefone());
			stmt.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean atualizar(Cliente cliente) {
		String sql = "UPDATE unc_farmacia.cliente SET nome = ?, cpf = ?, rg = ?, telefone = ? WHERE id = ?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getId());
			
			stmt.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Cliente> listarTodos(){
		String sql = "SELECT * FROM cliente;";
		List<Cliente> listaClientes = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				Cliente cliente = new Cliente(res.getString("nome"), res.getString("cpf"), res.getString("rg"), res.getString("telefone"));
				cliente.setId(res.getInt("id"));
				listaClientes.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return listaClientes;
	}
	
	public boolean remover (Integer id) {
		String sql = "DELETE FROM cliente WHERE id = ?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Cliente encontreId(Integer id){
		String sql = "SELECT * FROM cliente WHERE id = ?;";
		Cliente cliente = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			if (res.next()) {
				cliente = new Cliente(res.getString("nome"), res.getString("cpf"), res.getString("rg"), res.getString("telefone"));
				cliente.setId(res.getInt("id"));
			}
		} catch (SQLException e) {
			cliente = null;
		}
		
		return cliente;
	}
	
}
