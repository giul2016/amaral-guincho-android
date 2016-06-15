package com.example.amaralguincho_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class TelaFrota extends Activity {
	
	TextView lblTipo, lblNome;
	EditText txtCodigo, txtModelo, txtFabricante, txtPlaca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_frota);
		
		lblTipo = (TextView) findViewById(R.id.lblTipoFrotaTelaFrota);
		lblNome = (TextView) findViewById(R.id.lblNomeFrotaTelaFrota);
		
		txtCodigo = (EditText) findViewById(R.id.txtCodigoFrotaTelaFrota);
		txtFabricante = (EditText) findViewById(R.id.txtFabricanteFrotaTelaFrota);
		txtModelo = (EditText) findViewById(R.id.txtModeloFrotaTelaFrota);
		txtPlaca = (EditText) findViewById(R.id.txtPlacaFrotaTelaFrota);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_frota, menu);
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
