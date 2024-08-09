package cl.bootcamp.proyectos;

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
                "#2a6c8c",
                "Clase 5",
                "#2a6c8c",
                "RecyclerView",
                "Activo")
        );
        ListAdapter listAdapter = new ListAdapter(element, this);
        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: " + element.get
                                (recyclerView.getChildAdapterPosition(view))
                                .getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}