package br.edu.pdm.snackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);
        Snackbar
                .make(coordinatorLayoutView, "Teste", Snackbar.LENGTH_LONG).show();
       }
}
