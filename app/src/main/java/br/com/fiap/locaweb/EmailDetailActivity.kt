package br.com.fiap.locaweb

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmailDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corpoemail)

        val voltaListaEmail: ImageView = findViewById(R.id.voltar_lista_email)

        val senderImageView: ImageView = findViewById(R.id.emailSenderImageDetail)
        val titleTextView: TextView = findViewById(R.id.emailTitleDetail)
        val contentEditText: EditText = findViewById(R.id.emailContentDetail)
        val senderTextView: TextView = findViewById(R.id.emailSenderDetail)

        // Recuperar os dados passados pela intent
        val senderImageResId = intent.getIntExtra("SENDER_IMAGE_RES_ID", 0)
        val title = intent.getStringExtra("EMAIL_TITLE") ?: ""
        val content = intent.getStringExtra("EMAIL_CONTENT") ?: ""
        val sender = intent.getStringExtra("EMAIL_SENDER") ?: ""

        // Definir os dados na view
        senderImageView.setImageResource(senderImageResId)
        titleTextView.text = title
        contentEditText.setText(content)
        senderTextView.text = if (sender.isNotEmpty()) sender else "Remetente desconhecido"

        voltaListaEmail.setOnClickListener {
            finish()
        }
    }
}