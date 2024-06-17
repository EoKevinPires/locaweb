package br.com.fiap.locaweb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    // Usuário genérico para fins de demonstração
    private val usuarioGenerico = "joao@locaweb.com.br"
    private val senhaGenerico = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextSenha: EditText = findViewById(R.id.editTextSenha)
        val login: Button = findViewById(R.id.login)
        val cadastrese: TextView = findViewById(R.id.textCadastro)

        login.setOnClickListener {
            val email = editTextEmail.text.toString()
            val senha = editTextSenha.text.toString()

            if (email == usuarioGenerico && senha == senhaGenerico) {
                // Credenciais corretas, iniciar MenuActivity
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                // Credenciais incorretas, mostrar mensagem de erro
                Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }

        cadastrese.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}
