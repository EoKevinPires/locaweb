package br.com.fiap.locaweb

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LixeiraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val emailListTitle: TextView = findViewById(R.id.emailListTitle)
        val emailListView: ListView = findViewById(R.id.emailListView)

        val screenTitle = intent.getStringExtra("SCREEN_TITLE") ?: "Lixeira"
        emailListTitle.text = screenTitle

        val emailData = listOf(
            Email("Atualização no plano de saúde", "Confira as novas opções e benefícios disponíveis.", R.drawable.ic_person, ""),
            Email("Pesquisa de satisfação do cliente", "Participe da nossa pesquisa e nos ajude a melhorar.", R.drawable.ic_person, ""),
            Email("Aviso de férias coletivas", "A empresa estará de férias coletivas de 20/12 a 05/01.", R.drawable.ic_person, "")
        )

        val adapter = EmailAdapter(this, emailData)
        emailListView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }


    }
}