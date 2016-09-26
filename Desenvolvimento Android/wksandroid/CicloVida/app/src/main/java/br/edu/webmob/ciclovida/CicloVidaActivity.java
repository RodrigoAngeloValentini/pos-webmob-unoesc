package br.edu.webmob.ciclovida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class CicloVidaActivity extends AppCompatActivity {

    private final String TAG = "CicloVidaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // carrega o layout visual(tela gráfica)
        setContentView(R.layout.activity_ciclo_vida);
        Log.i(TAG, "Passando pelo método onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Passando pelo método onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Passando pelo método onRestart()");
    }

    // TODO: Implementar onResume, onPause, onStop, onDestroy
}
