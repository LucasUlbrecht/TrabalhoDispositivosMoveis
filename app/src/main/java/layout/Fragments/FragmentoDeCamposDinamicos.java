package layout.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.grandeatividade.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import layout.FieldDeAcoes;

public class FragmentoDeCamposDinamicos<T> extends Fragment {

    private Class<T> clazz; // Classe genérica
    private String highlightedFieldName; // Nome do campo destacado
    private int DynamicFieldsLayout;
    private FieldDeAcoes fieldDeAcoes;

    public FragmentoDeCamposDinamicos(Class<T> clazz, String highlightedFieldName, int DynamicFieldsLayout, FieldDeAcoes fieldDeAcoes) {
        this.clazz = clazz;
        this.highlightedFieldName = highlightedFieldName;
        this.DynamicFieldsLayout = DynamicFieldsLayout;
        this.fieldDeAcoes = fieldDeAcoes;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(DynamicFieldsLayout, container, false); // Substitua 'seu_layout_scrollview' pelo nome do seu arquivo XML ScrollView

        ScrollView scrollView = view.findViewById(R.id.scroll_view); // Substitua 'scroll_view' pelo ID do ScrollView no seu arquivo XML
        FrameLayout frameLayout = view.findViewById(R.id.frame_layout_container); // Substitua 'frame_layout_container' pelo ID do FrameLayout no seu arquivo XML

        List<Field> fields = getAllFields(clazz);

        for (Field field : fields) {
            TextView textView = new TextView(requireContext());
            textView.setText(field.getName());

            EditText editText = new EditText(requireContext());
            editText.setHint("Enter " + field.getName());

            frameLayout.addView(textView);
            frameLayout.addView(editText);

            if (field.getName().equals(highlightedFieldName)) {
                Button generateCodeButton = new Button(requireContext());
                generateCodeButton.setText("Gerar Codigo");
                generateCodeButton.setOnClickListener(v -> {
                    if (fieldDeAcoes != null) {
                        fieldDeAcoes.genCode();
                    }
                });
                frameLayout.addView(generateCodeButton);
            }
        }
        Button btnCriar = new Button(requireContext());
        btnCriar.setText("Criar");

        Button btnAtualizar = new Button(requireContext());
        btnAtualizar.setText("Atualizar");

        Button btnRemover = new Button(requireContext());
        btnRemover.setText("Remover");

        frameLayout.addView(btnCriar);
        frameLayout.addView(btnAtualizar);
        frameLayout.addView(btnRemover);

        // Associando os métodos aos botões
        btnCriar.setOnClickListener(v -> {
            if (fieldDeAcoes != null) {
                fieldDeAcoes.onCreateField();
            }
        });

        btnAtualizar.setOnClickListener(v -> {
            if (fieldDeAcoes != null) {
                fieldDeAcoes.onUpdateField();
            }
        });

        btnRemover.setOnClickListener(v -> {
            if (fieldDeAcoes != null) {
                fieldDeAcoes.onRemoveField();
            }
        });

        return view;
    }

    public void setFieldActionListener(FieldDeAcoes listener) {
        this.fieldDeAcoes = listener;
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
