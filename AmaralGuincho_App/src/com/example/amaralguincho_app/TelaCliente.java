package com.example.amaralguincho_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class TelaCliente extends Activity {
	
	TextView lblSobrenome, lblNome;
	
	EditText txtCodigo, txtNome, txtSobrenome, txtSexo;
	EditText txtDtnasc, txtCpf, txtEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_cliente);
		
		lblSobrenome = (TextView) findViewById(R.id.lblSobrenomeClienteTelaCliente);
		lblNome = (TextView) findViewById(R.id.lblNomeClienteTelaCliente);
		txtCodigo = (EditText) findViewById(R.id.txtCodigoClienteTelaCliente);
		txtNome = (EditText) findViewById(R.id.txtNomeClienteTelaCliente);
		txtSobrenome = (EditText) findViewById(R.id.txtSobrenomeClienteTelaCliente);
		txtSexo = (EditText) findViewById(R.id.txtSexoClienteTelaCliente);
		txtDtnasc = (EditText) findViewById(R.id.txtDataNascimentoClienteTelaCliente);
		txtCpf = (EditText) findViewById(R.id.txtCpfClienteTelaCliente);
		txtEmail = (EditText) findViewById(R.id.txtEmailClienteTelaCliente);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_cliente, menu);
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
}
