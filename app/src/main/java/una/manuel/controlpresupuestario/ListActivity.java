package una.manuel.controlpresupuestario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import una.manuel.controlpresupuestario.model.Categoria;
import una.manuel.controlpresupuestario.model.Movimiento;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MovimientoActivity.class);
                startActivity(intent);


            }
        });
            if(getIntent().getExtras() != null) {
                System.out.println("im here");
                Bundle extras = getIntent().getExtras();
                String entrada = extras.getString("fecha");
                System.out.println(entrada);
                SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH); // Creamos un formato de fecha
               Date fecha = null;
                try {
                   fecha = format.parse(entrada);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Categoria categoria = extras.getParcelable("categoria");

                ArrayList movimientos = new ArrayList<Movimiento>();
                ListView listView = (ListView) findViewById(R.id.list);
                movimientos.add(new Movimiento(extras.getLong("id"), extras.getString("descripcion"), fecha, categoria));
                ListAdapter adapter = new ListAdapter(movimientos, getApplicationContext());
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();

    }

    public void update(){

    }
}
