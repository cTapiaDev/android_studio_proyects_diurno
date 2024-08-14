package cl.bootcamp.proyectos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.proyectos.databinding.ActivityBindingButtonsBinding;


public class BindingButtons extends AppCompatActivity {

    ActivityBindingButtonsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding_buttons);

        binding = ActivityBindingButtonsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnValidarCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cadena = "Seleccionado: ";

                if (binding.cb1.isChecked()) {
                    cadena += binding.cb1.getText();
                }
                if (binding.cb2.isChecked()) {
                    cadena += "Opción 2 -";
                }
                if (binding.cb3.isChecked()) {
                    cadena += "Opción 3";
                }

                Toast.makeText(view.getContext(), cadena, Toast.LENGTH_LONG).show();

            }
        });

        binding.btnValidarRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "Seleccionado: ";

                if (binding.rb1.isChecked()) {
                    cadena += "Opción 1";
                }
                if (binding.rb2.isChecked()) {
                    cadena += "Opción 2";
                }

                Toast.makeText(view.getContext(), cadena, Toast.LENGTH_LONG).show();
            }
        });


        setSupportActionBar(binding.toolBinding);

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