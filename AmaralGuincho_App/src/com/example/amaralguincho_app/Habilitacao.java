package com.example.amaralguincho_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Habilitacao extends Activity {

	TextView lblNome;
	
	EditText txtNome, txtIdentidade, txtNumeroRegistro, txtValidade, txtLocalGerado, txtEmissao;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_habilitacao);
		
		lblNome = (TextView) findViewById(R.id.lblNomeMotoristaTelaHabilitacao);
		txtNome = (EditText) findViewById(R.id.lblNomeMotoristaTelaHabilitacao);
		txtIdentidade = (EditText) findViewById(R.id.txtIdentidadeTelaHabilitacao);
		txtNumeroRegistro = (EditText) findViewById(R.id.txtNumeroRegistroHabilitacaoTelaHabilitacao);
		txtValidade = (EditText) findViewById(R.id.txtValidadeHabilitacaoTelaHabilitacao);
		txtLocalGerado =  (EditText) findViewById(R.id.txtLocalGeradoHabilitacaoTelaHabilitacao);
		txtEmissao = (EditText) findViewById(R.id.txtEmissaoHabilitacaoTelaHabilitacao);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.habilitacao, menu);
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
