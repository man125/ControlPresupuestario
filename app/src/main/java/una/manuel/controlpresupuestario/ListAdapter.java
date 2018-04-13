package una.manuel.controlpresupuestario;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import una.manuel.controlpresupuestario.model.Movimiento;

/**
 * Created by manuel on 07/04/2018.
 */

public class ListAdapter extends ArrayAdapter<Movimiento> implements  View.OnClickListener {
    private ArrayList<Movimiento> dataSet;
    Context mContext;
    public ListAdapter(ArrayList<Movimiento> data, Context context){
        super(context, R.layout.list_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    //logica de la lista para eliminar , agregar y actualizar aqui
    @Override
    public View getView(int position, View convert, ViewGroup parent){
        //dibujar o cambiar valorees de la lista
        if(convert == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            convert = vi.inflate(R.layout.list_item, null);
        }

        ImageView categoria = (ImageView) convert.findViewById(R.id.listTipo);
        TextView descripcion = (TextView) convert.findViewById(R.id.listDescripcion);
        TextView fecha = (TextView) convert.findViewById(R.id.listFecha);
        ImageButton boton = (ImageButton) convert.findViewById(R.id.listBoton);

        categoria.setImageResource(android.R.drawable.presence_online);//hacer if
        descripcion.setText(dataSet.get(position).getDescripcion());
        descripcion.setTextColor(convert.getResources().getColor(R.color.colorNegro));
        fecha.setText(dataSet.get(position).getFecha().toString());//do format
        fecha.setTextColor(convert.getResources().getColor(R.color.colorNegro));
        boton.setImageResource(android.R.drawable.ic_delete);
        boton.setOnClickListener(this);
        boton.setTag(position);

        return convert;
    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        Movimiento dataModel = (Movimiento) object;
        switch (view.getId()){
            case R.id.listBoton:
                //eliminar
                for(Movimiento m : dataSet){
                    if(m.getIdMovimiento() == dataModel.getIdMovimiento()){
                        dataSet.remove(dataModel);
                        break;
                    }
                }
                notifyDataSetChanged();

              //  Snackbar.make(view, "Elimina "+dataModel.getDescripcion(), Snackbar.LENGTH_LONG).setAction("no action", null).show();
        }
    }
}
