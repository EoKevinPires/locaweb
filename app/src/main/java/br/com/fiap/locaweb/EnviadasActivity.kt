package br.com.fiap.locaweb

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EnviadasActivity : AppCompatActivity() {

    private lateinit var emailListView: ListView
    private lateinit var editTextSearch: EditText
    private lateinit var adapter: EmailAdapter
    private lateinit var emailData: MutableList<Email>
    private lateinit var originalEmailData: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val emailListTitle: TextView = findViewById(R.id.emailListTitle)
        emailListView = findViewById(R.id.emailListView)
        editTextSearch = findViewById(R.id.editTextSearch)

        val screenTitle = intent.getStringExtra("SCREEN_TITLE") ?: "Mensagens enviadas"
        emailListTitle.text = screenTitle

        emailData = mutableListOf(
            Email("Atualização de projeto: Prazo estendido", "O prazo para entrega do projeto foi estendido.", R.drawable.ic_person, "Rafael"),
            Email("Feliz aniversário, Rafa!", "Desejamos um dia especial e muitas felicidades.", R.drawable.ic_person, "Kevin"),
            Email("Convite para reunião de feedback", "Agende seu horário para a reunião de feedback.", R.drawable.ic_person, "Duda")
        )

        originalEmailData = emailData.toList()

        adapter = EmailAdapter(this, emailData)
        emailListView.adapter = adapter

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterEmails(s.toString())
            }
        })

        emailListView.setOnItemClickListener { _, _, position, _ ->
            val selectedEmail = emailData[position]
            val intent = Intent(this, EmailDetailActivity::class.java).apply {
                putExtra("SENDER_IMAGE_RES_ID", selectedEmail.senderImageResId)
                putExtra("EMAIL_TITLE", selectedEmail.title)
                putExtra("EMAIL_CONTENT", selectedEmail.content)
                putExtra("EMAIL_SENDER", selectedEmail.sender)
            }
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun filterEmails(query: String) {
        emailData.clear()
        if (query.isEmpty()) {
            emailData.addAll(originalEmailData)
        } else {
            val filteredEmails = originalEmailData.filter {
                it.title.contains(query, ignoreCase = true) || it.content.contains(query, ignoreCase = true)
            }
            emailData.addAll(filteredEmails)
        }
        adapter.notifyDataSetChanged()
    }
}
