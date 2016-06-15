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
import model.funcionario;

public class pesquisarMotorista extends AsyncTask<Object, Object, Boolean> {

	Connection conexao;

	Context tela;

	ProgressDialog dialogo;

	funcionario motClass = new funcionario();

	public funcionario getMotClass() {
		return motClass;
	}

	public void setMotClass(funcionario motClass) {
		this.motClass = motClass;
	}

	public pesquisarMotorista(Context tela) {
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

		if (result == true)
			Toast.makeText(tela, "Dados cadastrados com sucesso!!!", Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(tela, "ERRO no cadastro!!!", Toast.LENGTH_SHORT).show();

		dialogo.dismiss();

		disconnect();
	}

	public Boolean pesquisarNome(){
		try{
		Date dataTMP;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		
		ResultSet tabelaMemoria;
		String sql = "select * from funcionario where nome_func=?";
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, motClass.getNome_func());
		tabelaMemoria = comando.executeQuery();
		
		if(tabelaMemoria.next()){
			
			motClass.setId_func(tabelaMemoria.getInt("id_func"));
			motClass.setNome_func(tabelaMemoria.getString("nome_func"));
			motClass.setSobrenome_func(tabelaMemoria.getString("sobrenome_func"));
			motClass.setSx_func(tabelaMemoria.getString("sx_func"));
			
			
		}
		
		}
 }
}