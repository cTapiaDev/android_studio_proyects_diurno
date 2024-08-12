package cl.bootcamp.proyectos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Contador extends AppCompatActivity {

    Toolbar appbar;
    TextView contador;
    FloatingActionButton btnAdd, btnRes;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        appbar = (Toolbar) findViewById(R.id.toolContador);
        contador = (TextView) findViewById(R.id.tvContador);
        btnAdd = (FloatingActionButton) findViewById(R.id.fabContador);
        btnRes = (FloatingActionButton) findViewById(R.id.fabResta);

        setSupportActionBar(appbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Integer.parseInt(contador.getText().toString());
                number++; // number = number + 1
                contador.setText(String.valueOf(number));
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Integer.parseInt(contador.getText().toString());
                number--;
                contador.setText(String.valueOf(number));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}