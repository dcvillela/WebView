package edi.fema.helloworldii;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private EditText nomeEditText;
	private TextView saudacaoTextView;
	private TextView local;
	private String saudacao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.nomeEditText = (EditText) findViewById(R.id.nomeEditText);
		this.saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);
		this.local = (TextView) findViewById(R.id.local);
		this.saudacao = getResources().getString(R.string.saudacao);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void surpreenderUsuario(View v) {
		Editable texto = this.nomeEditText.getText();
		String msg = saudacao + " " + texto.toString();
		this.saudacaoTextView.setText(msg);
		this.local.setText("Tópicos de programação - Prof. Domingos");
		this.nomeEditText.setText("");
	}
}
