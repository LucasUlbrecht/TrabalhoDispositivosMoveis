package layout;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import java.lang.reflect.Field;

public class TelaGeradora {

    public static void preencherCampos(Activity activity, Object objeto) {
        Field[] campos = objeto.getClass().getDeclaredFields();

        for (Field campo : campos) {
            if (campo.getType() == String.class || campo.getType() == int.class || campo.getType() == double.class) {
                int id = activity.getResources().getIdentifier("editText" + campo.getName().substring(0, 1).toUpperCase() + campo.getName().substring(1), "id", activity.getPackageName());
                EditText editText = activity.findViewById(id);

                try {
                    campo.setAccessible(true);
                    Object valorCampo = campo.get(objeto);
                    if (valorCampo != null) {
                        editText.setText(String.valueOf(valorCampo));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static <T> T obterDadosDosCampos(Activity activity, Class<T> classe) {
        T objeto = null;
        try {
            objeto = classe.newInstance();
            Field[] campos = classe.getDeclaredFields();

            for (Field campo : campos) {
                int id = activity.getResources().getIdentifier(campo.getName(), "id", activity.getPackageName());
                EditText editText = activity.findViewById(id);

                campo.setAccessible(true);

                if (campo.getType() == String.class) {
                    campo.set(objeto, editText.getText().toString());
                } else if (campo.getType() == int.class) {
                    campo.set(objeto, Integer.parseInt(editText.getText().toString()));
                } else if (campo.getType() == double.class) {
                    campo.set(objeto, Double.parseDouble(editText.getText().toString()));
                }
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return objeto;
    }
}
