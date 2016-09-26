package br.edu.webmob.tccfreak;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText edtLogin;
    private EditText edtSenha;
    private ImageButton btnLogin;
    private ImageButton btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // capturando instâncias da tela/xml
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        btnSair = (ImageButton) findViewById(R.id.btnSair);

        // adicionando o listener de click
        btnLogin.setOnClickListener(this);
        btnSair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                String login = edtLogin.getText().toString();
                String senha = edtSenha.getText().toString();
                if (login != null &&
                        !login.trim().equals("") &&
                        senha != null &&
                        !senha.trim().equals("")) {
                    if (login.equals("tccfreak")
                            && senha.equals("tccfreak")) {
                        // chama a tela principal
                        Intent itPrincipal = new Intent(
                                this,
                                PrincipalActivity.class
                        );
                        // passando parâmetros para a activity
                        itPrincipal.putExtra("usuario","tccfreak");
                        startActivity(itPrincipal);
                        // finaliza a tela de login
                        finish();
                    } else {
                        // TODO: (1,00) Adicionar mensagem para avisar o usuário que o login e/ou senha inválidos!
                        edtLogin.setText("");
                        edtSenha.setText("");
                        edtLogin.requestFocus();
                    }
                } else {
                    // avisando o usuário da necessidade
                    // de preenchimento dos campos
                    Toast.makeText(this,
                            R.string.msgCamposObrigatorios,
                            Toast.LENGTH_LONG
                    ).show();
                    edtLogin.requestFocus();
                }
                break;
            case R.id.btnSair:
                // usando uma caixa de diálogo para o sair
                AlertDialog.Builder dialogoSair =
                        new AlertDialog.Builder(this);
                dialogoSair.setTitle(R.string.tituloSair);
                dialogoSair.setMessage(R.string.msgSair);
                dialogoSair.setIcon(R.drawable.sair);
                dialogoSair.setPositiveButton(
                        R.string.opSim,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface,
                                                int i) {
                                // finalizando a aplicação
                                finish();
                                System.exit(0);
                            }
                        }
                );
                dialogoSair.setNegativeButton(R.string.opNao, null);
                dialogoSair.show();
                break;
        }
    }
}
