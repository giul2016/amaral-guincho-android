package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import model.cliente;

public class ListarBDCliente extends AsyncTask<Object, Object, Boolean>{
	
	
	Context context;
	ProgressDialog dialogo;
	
	Connection conexao = null;
	
	List<cliente> listaCliente = new ArrayList<cliente>(); 

	public List<cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	/////////////////////////////////////////////////////////////
	
	public ListarBDCliente(Context context) {
		this.context = context;
	}
	
	public Boolean connect() {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager.getConnection("jdbc:mysql://169.254.84.109:3306/amaralguincho","root","ALUNOS");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void disconnect() {
		try {
			conexao.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		dialogo = new ProgressDialog(this.context);
		dialogo.setMessage("Aguarde...");
		dialogo.show();
		
	}

	@Override
	protected Boolean doInBackground(Object... params) {
		connect();
		
		listarTudo();
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		
		Toast.makeText(this.context, "Dados ....", Toast.LENGTH_SHORT).show();
		
		dialogo.dismiss();
		
		disconnect();
	}
	
	
	public void listarTudo() {
		try{
			
			Date dataMysql;
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
			
			String sql = "select * from cliente";
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet tabelaMemoria = comando.executeQuery();
			
			
			while (tabelaMemoria.next()) {
				
				cliente cliIMG = new cliente();
				
				cliIMG.setId_cli(tabelaMemoria.getInt("id_func"));
				cliIMG.setNome_cli(tabelaMemoria.getString("nome_cli"));
				cliIMG.setSobrenome_cli(tabelaMemoria.getString("sobrenome_cli"));
				cliIMG.setCpf_cli(tabelaMemoria.getString("cpf_cli"));
				cliIMG.setEmail(tabelaMemoria.getString("email_cli"));
				cliIMG.setSx_cli(tabelaMemoria.getString("sx_cli"));
				cliIMG.setTelefone_cli(tabelaMemoria.getString("telefone_cli"));
				
				dataMysql = tabelaMemoria.getDate("dtnasc_cli");
				cliIMG.setDtnasc_cli(formatoData.format(dataMysql));
				
				cliIMG.setCep_cli(tabelaMemoria.getString("cep_cli"));
				cliIMG.setBairro_cli(tabelaMemoria.getString("bairro_cli"));
				cliIMG.setCid_cli(tabelaMemoria.getString("cid_cli"));
				cliIMG.setUf_cli(tabelaMemoria.getString("uf_cli"));
				cliIMG.setEndereco_cli(tabelaMemoria.getString("endereco_cli"));
				
				listaCliente.add(cliIMG);
				
			}
			
		} catch (SQLException e) {
			e.getSQLState();
		}
	}
	



}
