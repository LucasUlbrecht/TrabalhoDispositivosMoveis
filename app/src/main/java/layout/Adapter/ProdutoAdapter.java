package layout.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Model.Adicionais;
import Model.Produto;
import com.example.grandeatividade.R; // Certifique-se de ajustar o caminho do R corretamente

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private List<Produto> produtoList;
    private Context context;

    public ProdutoAdapter(Context context, List<Adicionais> produtoList) {
        super(context, 0, produtoList);
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_gerenciar_adicionais_page, parent, false);
        }

        Produto produto = getItem(position);

        TextView nomeTextView = convertView.findViewById(R.id.parte_azul);
        TextView tipoTextView = convertView.findViewById(R.id.parte_vermelha);
        TextView valorTextView = convertView.findViewById(R.id.parte_branca);

        if (produto != null) {
            String nome = produto.getNome();
            String tipo = produto.getTipo();
            double valor = produto.getQuantidade();

            nomeTextView.setText("Nome: " + nome);
            tipoTextView.setText("Tipo: " + tipo);
            valorTextView.setText("Quantidade: " + String.valueOf(valor));
        } else {
            // Trate o caso em que o produto é nulo
            nomeTextView.setText("Nome: ");
            tipoTextView.setText("Tipo: ");
            valorTextView.setText("Quantidade" +": ");
            Log.e("ProdutoAdapter", "Produto nulo na posição: " + position);
        }

        return convertView;
    }
}
