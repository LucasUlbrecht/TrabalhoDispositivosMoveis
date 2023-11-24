package layout.ItemClickListeneer;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PersonItemClickListener implements View.OnClickListener {
    AppCompatActivity app;
        String indexToGo;
        public PersonItemClickListener(AppCompatActivity app, String indexToGo){
            setApp(app);
            setIndexToGo(indexToGo);
        }
        @Override
        public void onClick(View view) {
            try {
                Class<?> clazz = Class.forName(getIndexToGo());
                Intent intent = new Intent(app, clazz);
                app.startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public void setApp(AppCompatActivity app) {
        this.app = app;
    }

    public void setIndexToGo(String indexToGo) {
        this.indexToGo = indexToGo;
    }

    public AppCompatActivity getApp() {
        return app;
    }

    public String getIndexToGo() {
        return indexToGo;
    }
}
