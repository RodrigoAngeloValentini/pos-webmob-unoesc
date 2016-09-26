package br.edu.unoesc.cc.conversormoeda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity
implements View.OnClickListener {
    // variávei de apoio
    private EditText edtValor;
    private RadioGroup rgMoeda;
    private Button btnConverter;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtValor = (EditText) findViewById(R.id.edtValor);
        rgMoeda = (RadioGroup) findViewById(R.id.rgMoeda);
        btnConverter = (Button) findViewById(R.id.btnConverter);
        btnSair = (Button) findViewById(R.id.btnSair);
        btnConverter.setOnClickListener(this);
        btnSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnConverter:
                String strValor = edtValor.getText().toString();
                double valor = Double.parseDouble(strValor);
                double resultado = 0.0;
                if (rgMoeda.getCheckedRadioButtonId()
                        == R.id.rbDolar) {
                    resultado = valor / 3.25;
                } else {
                    resultado = valor / 0.22;
                }
                Toast.makeText(
                        this,
                        "Resultado: " + resultado,
                        Toast.LENGTH_LONG
                ).show();
                break;
            case R.id.btnSair:
                finish();
                System.exit(0);
                break;
        }
    }
}
