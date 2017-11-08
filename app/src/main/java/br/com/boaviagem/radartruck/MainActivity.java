package br.com.boaviagem.radartruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Spinner categoria;
    ListView list_view;
    EditText txtKilometro;

    Quilometro adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtKilometro = (EditText) findViewById(R.id.txtKilometro);
        List<Quilometro> lstQuilometro = Quilometro.listAll(Quilometro.class);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this, R.array.categoria_mes,
                        android.R.layout.simple_spinner_item);
        categoria = (Spinner) findViewById(R.id.cadMes);
        categoria.setAdapter(adapter);

        adapter = new Quilometro (this,lstQuilometro);

    list_view.setAdapter(adapter);
    }

    public void inserirItem(View view){
        String quilometros = txtKilometro.getText().toString();

        if(quilometros.isEmpty())return;

        Quilometro q = new Quilometro(quilometros, false);

        adapter.add(q);

        q.save();

        txtKilometro.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_visualizar) {
            startActivity(new Intent(this, VisualizarActivity.class));
            return true;
        }else if (id == R.id.action_calcular)
            startActivity((new Intent(this, CalcularActivity.class)));
            return false;

    }




}


