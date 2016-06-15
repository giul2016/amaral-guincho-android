package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import model.cliente;

public class pesquisarCliente extends AsyncTask<Object, Object, Boolean> {

	Connection conexao;

	Context tela;

	ProgressDialog dialogo;
	
	cliente cliClasse = new cliente();
		

	public cliente getCliClasse() {
		return cliClasse;
	}

	public void setCliClasse(cliente cliClasse) {
		this.cliClasse = cliClasse;
	}

	public pesquisarCliente(Context tela) {
		super();
		this.tela = tela;
	}

	public Boolean connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conexao = DriverManager.getConnection("jdbc:mysql://172.16.39.174:3306/fabrica", "root", "ALUNOS");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void disconnect() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		dialogo = new ProgressDialog(tela);
		dialogo.setMessage("Aguarde ...");
		dialogo.show();
	}

	@Override
	protected Boolean doInBackground(Object... params) {
		// TODO Auto-generated method stub

		Boolean resp;

		resp = connect();

		return resp;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		Toast.makeText(tela, "Cliente Não Cadastrado", Toast.LENGTH_SHORT).show();

		dialogo.dismiss();

		disconnect();
	}
	
	public Boolean pesquisarNome(){
		try{
			
			Date dataTMP;
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
			
			ResultSet tabelaMemoria;
			String sql = "Select * from cliente where nome_cli=?";
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, cliClasse.getNome_cli());
			tabelaMemoria = comando.executeQuery();
			
			if(tabelaMemoria.next()) {
				
				cliClasse.setId_cli(tabelaMemoria.getInt("id_cli"));
				cliClasse.setNome_cli(tabelaMemoria.getString("nome_cli"));
				cliClasse.setSobrenome_cli(tabelaMemoria.getString("sobrenome_cli"));
				cliClasse.setCpf_cli(tabelaMemoria.getString("cpf_cli"));
				cliClasse.setEmail(tabelaMemoria.getString("email_cli"));
				cliClasse.setSx_cli(tabelaMemoria.getString("sx_cli"));
				cliClasse.setTelefone_cli(tabelaMemoria.getString("telefone_cli"));
				
				dataTMP = tabelaMemoria.getDate("dtnasc_cli");
				cliClasse.setDtnasc_cli(formatoData.format(dataTMP));
				
				/*cliClasse.setCep_cli(tabelaMemoria.getString("cep_cli"));
				cliClasse.setBairro_cli(tabelaMemoria.getString("bairro_cli"));
				cliClasse.setCid_cli(tabelaMemoria.getString("cid_cli"));
				cliClasse.setUf_cli(tabelaMemoria.getString("uf_cli"));
				cliClasse.setEndereco_cli(tabelaMemoria.getString("endereco_cli"));*/
				
				return true;
			} else {
				cliClasse = null;
				return false;
			}
			
		} catch (SQLException e) {
			e.getStackTrace();
			return false;
		}
	}

}
