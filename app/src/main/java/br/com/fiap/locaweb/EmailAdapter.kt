package br.com.fiap.locaweb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

data class Email(val title: String, val content: String, val senderImageResId: Int)

class EmailAdapter(private val context: Context, private val emails: List<Email>) : BaseAdapter() {

    override fun getCount(): Int = emails.size

    override fun getItem(position: Int): Any = emails[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val email = emails[position]
        viewHolder.title.text = email.title
        viewHolder.content.text = email.content
        viewHolder.senderImage.setImageResource(email.senderImageResId)

        return view
    }

    private class ViewHolder(view: View) {
        val senderImage: ImageView = view.findViewById(R.id.emailSenderImage)
        val title: TextView = view.findViewById(R.id.emailTitle)
        val content: TextView = view.findViewById(R.id.emailContent)
    }
}