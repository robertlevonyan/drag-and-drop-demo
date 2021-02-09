package com.robertlevonyan.demo.dragndrop.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.robertlevonyan.demo.dragndrop.callback.DragListener
import com.robertlevonyan.demo.dragndrop.R
import com.robertlevonyan.demo.dragndrop.callback.WordsDiffCallback

/**
 * A @androidx.recyclerview.widget.RecyclerView adapter to show draggable items
 *
 * @param onDragStarted will provide the current draggable view value. String in this case
 * */
class WordsAdapter(private val onDragStarted: (String) -> Unit) : ListAdapter<String, WordsAdapter.WordsViewHolder>(WordsDiffCallback()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
    return WordsViewHolder(view)
  }

  override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  fun removeItem(selectedWord: String) {
    val list = ArrayList(currentList)
    list.remove(selectedWord)
    submitList(list)
  }

  inner class WordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(word: String) = itemView.run {
      findViewById<TextView>(R.id.tvWord).text = word

      setOnLongClickListener { view ->
        // when user is long clicking on a view, drag process will start
        val data = ClipData.newPlainText("", word)
        val shadowBuilder = View.DragShadowBuilder(view)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
          view.startDragAndDrop(data, shadowBuilder, view, 0)
        } else {
          view.startDrag(data, shadowBuilder, view, 0)
        }
        onDragStarted(word)
        true
      }

      setOnDragListener(DragListener())
    }
  }
}
