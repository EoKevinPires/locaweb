package br.com.fiap.locaweb

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CaixaEntradaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val emailListTitle: TextView = findViewById(R.id.emailListTitle)
        val emailListView: ListView = findViewById(R.id.emailListView)

        val screenTitle = intent.getStringExtra("SCREEN_TITLE") ?: "Caixa de entrada"
        emailListTitle.text = screenTitle

        val emailData = listOf(
            Email("Reunião agendada para amanhã", "A reunião será às 10h no auditório principal.", R.drawable.ic_person, ""),
            Email("Parabéns pelo ótimo trabalho!", "Seu empenho no projeto foi essencial para o sucesso.", R.drawable.ic_person, ""),
            Email("Convite para o evento de networking", "Junte-se a nós para um evento de networking às 18h.", R.drawable.ic_person, "")
        )

        val adapter = EmailAdapter(this, emailData)
        emailListView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }


    }
}