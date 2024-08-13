package cl.bootcamp.proyectos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        element = new ArrayList<>();
        element.add(new ListElement(
                "#11212D",
                "Contador",
                "#11212D",
                "Actividad de Contador",
                "Activo")
        );
        element.add(new ListElement(
                "#11212D",
                "Fragment",
                "#11212D",
                "Difrentes fragmentos",
                "Activo")
        );
        element.add(new ListElement(
                "#11212D",
                "WebFont",
                "#11212D",
                "Conectados a la red",
                "En Proceso...")
        );
        ListAdapter listAdapter = new ListAdapter(element, this);
        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                Intent intent;

                if (view.getId() != 0) {
                    switch (position) {
                        case 0:
                            intent = new Intent(view.getContext(), Contador.class);
                            view.getContext().startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(view.getContext(), ContenedorFragmentos.class);
                            view.getContext().startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(view.getContext(), WebFont.class);
                            view.getContext().startActivity(intent);
                            break;
                        default:
                            break;
                    }
                }


                Toast.makeText(getApplicationContext(),
                        "Selección: " + element.get
                                (position).getName()
                                + " - Posición: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}