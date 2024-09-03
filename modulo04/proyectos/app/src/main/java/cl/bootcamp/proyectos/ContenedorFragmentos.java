package cl.bootcamp.proyectos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ContenedorFragmentos extends AppCompatActivity {

    Toolbar appbar;

    FragmentTransaction transaction;
    Fragment primaryFragment, secondFragment, treeFragment, fourFragment;

    Button btnFrame1, btnFrame2, btnFrame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_fragmentos);

        btnFrame1 = (Button) findViewById(R.id.btnFrame1);
        btnFrame2 = (Button) findViewById(R.id.btnFrame2);
        btnFrame3 = (Button) findViewById(R.id.btnFrame3);

        primaryFragment = new primaryfragment();
        secondFragment = new secondfragment();
        treeFragment = new treefragment();
        fourFragment = new fourfragment();

        getSupportFragmentManager().beginTransaction().add(R.id.flContainer, primaryFragment).commit();

        transaction = getSupportFragmentManager().beginTransaction();

        btnFrame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, secondFragment).commit();
            }
        });

        btnFrame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, treeFragment).commit();
            }
        });

        btnFrame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, fourFragment).commit();
            }
        });



        appbar = (Toolbar) findViewById(R.id.toolContainer);
        setSupportActionBar(appbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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