package com.robertlevonyan.demo.dragndrop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.flexbox.*
import com.robertlevonyan.demo.dragndrop.adapter.SentenceAdapter
import com.robertlevonyan.demo.dragndrop.adapter.WordsAdapter
import com.robertlevonyan.demo.dragndrop.callback.DropListener
import com.robertlevonyan.demo.dragndrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  // values of the draggable views (usually this should come from a data source)
  private val words = mutableListOf("world", "a", "!", "What", "wonderful")
  // last selected word
  private var selectedWord = ""

  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    val topAdapter = SentenceAdapter()
    val bottomAdapter = WordsAdapter {
      selectedWord = it
    }.apply {
      submitList(words)
    }

    binding.rvTop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    binding.rvTop.adapter = topAdapter

    binding.rvTop.setOnDragListener(
        DropListener {
          bottomAdapter.removeItem(selectedWord)
          topAdapter.addItem(selectedWord)
        }
    )

    binding.rvBottom.layoutManager = FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP).apply {
      justifyContent = JustifyContent.SPACE_EVENLY
      alignItems = AlignItems.CENTER
    }

    binding.rvBottom.adapter = bottomAdapter
  }
}
