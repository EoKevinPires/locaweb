package br.com.fiap.locaweb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val caixaEntrada: Button = findViewById(R.id.entrada)
        val lixeira: Button = findViewById((R.id.lixeira))
        val enviadas: Button = findViewById(R.id.enviados)
        val novoEmail: Button = findViewById(R.id.novoMail)

        caixaEntrada.setOnClickListener {
            val intent = Intent(this, CaixaEntradaActivity::class.java)
            startActivity(intent)
        }

        lixeira.setOnClickListener {
            val intent = Intent(this, LixeiraActivity::class.java)
            startActivity(intent)
        }

        enviadas.setOnClickListener {
            val intent = Intent(this, EnviadasActivity::class.java)
            startActivity(intent)
        }

        novoEmail.setOnClickListener {
            val intent = Intent(this, NovoEmailActivity::class.java)
            startActivity(intent)
        }
    }
}