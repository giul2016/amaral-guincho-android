package com.example.amaralguincho_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TelaHome extends Activity implements OnClickListener {

	Button btnOrdemDeServico, btnMotorista, btnClientes;
	TextView lblNome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_home);

		btnClientes = (Button) findViewById(R.id.btnClientesTelaHome);
		btnMotorista = (Button) findViewById(R.id.btnMotoristaTelaHome);
		btnOrdemDeServico = (Button) findViewById(R.id.btnOrdemDeServicoTelaHome);
		lblNome = (TextView) findViewById(R.id.lblNomeTelaHome);

		btnClientes.setOnClickListener(this);
		btnMotorista.setOnClickListener(this);
		btnOrdemDeServico.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_home, menu);
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
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btnClientesTelaHome:
			Intent tela = new Intent(this, TelaCliente.class);
			startActivity(tela);
			break;

		case R.id.btnMotoristaTelaHome:
			Intent tela2 = new Intent(this, TelaFuncionario.class);
			startActivity(tela2);
			break;

		}

	}
}
