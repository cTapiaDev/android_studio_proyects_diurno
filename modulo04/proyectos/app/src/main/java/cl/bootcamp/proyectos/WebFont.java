package cl.bootcamp.proyectos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebFont extends AppCompatActivity {

    Toolbar appbar;
    Button btnWeb, btnRed;
    TextView tvFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_font);

        btnWeb = (Button) findViewById(R.id.btnWebView);
        btnRed = (Button) findViewById(R.id.btnRed);

        tvFont = (TextView) findViewById(R.id.tvSinto);

        tvFont.setTypeface(ResourcesCompat.getFont(this, R.font.shadows_into));



        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WebViewVista.class);
                view.getContext().startActivity(intent);
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://www.youtube.com/watch?v=vSaPr3Uc2Vk");
                Intent browser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(browser);
            }
        });


        appbar = (Toolbar) findViewById(R.id.toolWeb);
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