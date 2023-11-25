package layout.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

public class GenericAdapter<T> extends ArrayAdapter<T> {
    private List<T> objectList;
    private Context context;
    private int resourceLayout; // Layout da linha do item da lista
    private String[] campos; // Array de campos para exibição

    public GenericAdapter(Context context, int resourceLayout, List<T> objectList, String[] campos) {
        super(context, resourceLayout, objectList);
        this.context = context;
        this.resourceLayout = resourceLayout;
        this.objectList = objectList;
        this.campos = campos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resourceLayout, parent, false);
        }

        T item = objectList.get(position);

        for (int i = 0; i < campos.length; i++) {
            TextView textView = convertView.findViewById(getResourceId(context, "parte_" + campos[i].toLowerCase()));

            if (textView != null && item != null) {
                try {
                    Field field = item.getClass().getDeclaredField(campos[i]);
                    field.setAccessible(true);
                    Object value = field.get(item);

                    if (value != null) {
                        textView.setText(campos[i] + ": " + value.toString());
                    } else {
                        textView.setText(campos[i] + ": ");
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                    Log.e("GenericAdapter", "Erro ao acessar o campo " + campos[i]);
                }
            }
        }

        return convertView;
    }

    // Método para obter o ID do recurso usando o nome
    private int getResourceId(Context context, String resourceName) {
        return context.getResources().getIdentifier(resourceName, "id", context.getPackageName());
    }
}
