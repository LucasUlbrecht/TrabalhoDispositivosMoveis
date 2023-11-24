package layout.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import Model.Sorvete;
import com.example.grandeatividade.R; // Certifique-se de ajustar o caminho do R corretamente

public class SorveteAdapter extends ArrayAdapter<Sorvete> {
    private List<Sorvete> sorveteList;
    private Context context;

    public SorveteAdapter(Context context, List<Sorvete> sorveteList) {
        super(context, 0, sorveteList);
        this.context = context;
        this.sorveteList = sorveteList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_sorvete, parent, false);
        }

        Sorvete sorvete = getItem(position);

        TextView nomeTextView = convertView.findViewById(R.id.parte_azul);
        TextView tipoTextView = convertView.findViewById(R.id.parte_vermelha);
        TextView valorTextView = convertView.findViewById(R.id.parte_branca);

        if (sorvete != null) {
            String nome = sorvete.getNome();
            String tipo = sorvete.getTipo();
            double valor = sorvete.getValor();

            nomeTextView.setText("Nome: " + nome);
            tipoTextView.setText("Tipo: " + tipo);
            valorTextView.setText("Valor: " + String.valueOf(valor));
        } else {
            // Trate o caso em que o sorvete é nulo
            nomeTextView.setText("Nome: ");
            tipoTextView.setText("Tipo: ");
            valorTextView.setText("Valor: ");
            Log.e("SorveteAdapter", "Sorvete nulo na posição: " + position);
        }

        return convertView;
    }
}
