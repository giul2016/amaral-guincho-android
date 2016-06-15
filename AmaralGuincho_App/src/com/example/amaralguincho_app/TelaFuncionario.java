package com.example.amaralguincho_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaFuncionario extends Activity implements OnClickListener{
	
	TextView lblSobrenome, lblNome;
	Button btnHabilitacao;
	EditText txtCodigo, txtNome, txtSobrenome, txtSexo, txtDtnasc;
	EditText txtCpf, txtTelefone, txtEmail, txtResidencia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_funcionario);
		
		lblNome = (TextView) findViewById(R.id.lblNome1MotoristaTelaHabilitacao);
		lblSobrenome = (TextView) findViewById(R.id.lblSobrenomeFuncionarioTelaFuncionario);
		txtCodigo = (EditText) findViewById(R.id.txtCodigoTelaFuncionario);
		txtNome = (EditText) findViewById(R.id.txtNomeTelaFuncionario);
		txtSexo = (EditText) findViewById(R.id.txtSexoTelaFuncionario);
		txtCpf = (EditText) findViewById(R.id.txtCpfTelaFuncionario);
		txtTelefone = (EditText) findViewById(R.id.txtTelefoneTelaFuncionario);
		txtEmail = (EditText) findViewById(R.id.txtEmailTelaFuncionario);
		txtResidencia = (EditText) findViewById(R.id.txtResidenciaTelaFuncionario);
		btnHabilitacao = (Button) findViewById(R.id.btnHabilitacaoTelaFuncionario);
		
		btnHabilitacao.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_funcionaro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnHabilitacaoTelaFuncionario:
			
			Intent tela = new Intent(this, Habilitacao.class);
			startActivity(tela);
			break;
			

		}
		
	}
}
