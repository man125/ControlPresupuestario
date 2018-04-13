package una.manuel.controlpresupuestario;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import una.manuel.controlpresupuestario.model.Categoria;
import una.manuel.controlpresupuestario.model.Movimiento;

public class MovimientoActivity extends AppCompatActivity {
    List<Categoria> categorias =  new ArrayList<Categoria>();
    ArrayList movimientos = new ArrayList<Movimiento>();
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        categorias.add(new Categoria(1,0,"Salario"));
        categorias.add(new Categoria(2,0,"Alquiler"));
        categorias.add(new Categoria(3,1,"Alimentos"));
        categorias.add(new Categoria(4,1,"Diversión"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento);
        ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(
                this, android.R.layout.simple_spinner_item, categorias);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.movimiento);
        sItems.setAdapter(adapter);

    }

    public void click(View view) throws ParseException {
        //movimientos.add(new Movimiento(2,"2 elemento",new Date(2010,2,1),null));
        long id = 2;
        String descripcion = "2 elemento";
        String entrada = "12/03/2016  08:48:10"; // Entrada recogida como sea (scanner)
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // Creamos un formato de fecha

          Date  date = format.parse(entrada);
            System.out.println("Date ->" + date);

        Categoria categoria = null;

        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("id", id);
        i.putExtra("descripcion", descripcion);
        i.putExtra("fecha", date.toString());
        i.putExtra("categoria", (Parcelable) categoria);
        startActivity(i);
    }

    public List<Movimiento> listar(){
        System.out.println( movimientos.size());
        return movimientos;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    public ListAdapter getAdapter() {
        return adapter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MovimientoActivity.this, ListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
