package cl.bootcamp.proyectos;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewVista extends AppCompatActivity {

    Toolbar appbar;

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_vista);


        webView = (WebView) findViewById(R.id.wvWeb);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com/cTapiaDev/repo_bootcamp_android_diurno");
        //webView.loadUrl("https://www.youtube.com/watch?v=vSaPr3Uc2Vk");



        appbar = (Toolbar) findViewById(R.id.toolWebVista);
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