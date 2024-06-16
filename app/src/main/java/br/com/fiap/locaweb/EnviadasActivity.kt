package br.com.fiap.locaweb

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EnviadasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val emailListTitle: TextView = findViewById(R.id.emailListTitle)
        val emailListView: ListView = findViewById(R.id.emailListView)

        // Set title based on the screen (Inbox, Sent, Trash)
        val screenTitle = intent.getStringExtra("SCREEN_TITLE") ?: "Mensagens enviadas"
        emailListTitle.text = screenTitle

        // Dummy data for email list
        val emailData = listOf(
            Email("Atualização de projeto: Prazo estendido", "O prazo para entrega do projeto foi estendido.", R.drawable.ic_person),
            Email("Feliz aniversário, Rafa!", "Desejamos um dia especial e muitas felicidades.", R.drawable.ic_person),
            Email("Convite para reunião de feedback", "Agende seu horário para a reunião de feedback.", R.drawable.ic_person)
        )

        val adapter = EmailAdapter(this, emailData)
        emailListView.adapter = adapter

        backButton.setOnClickListener {
            // Handle back button click
            finish()
        }


    }
}