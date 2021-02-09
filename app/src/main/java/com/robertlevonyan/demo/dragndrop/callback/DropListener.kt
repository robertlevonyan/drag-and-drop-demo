package com.robertlevonyan.demo.dragndrop.callback

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.DragEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.robertlevonyan.demo.dragndrop.R

/**
 * Callback for the target view where dragged items will be dropped
 * */
class DropListener(private val onDrop: () -> Unit) : View.OnDragListener {
  override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
    when (dragEvent.action) {
      // animate and highlight a background under the view to show the borders of the drop area
      DragEvent.ACTION_DRAG_ENTERED -> {
        val bgColor = ContextCompat.getColor(view.context, R.color.colorWhiteTransparent)
        if (view.background is ColorDrawable && (view.background as ColorDrawable).color == bgColor) return true

        ValueAnimator.ofArgb(Color.TRANSPARENT, bgColor).apply {
          addUpdateListener {
            val color = it.animatedValue as Int
            view.setBackgroundColor(color)
          }
          duration = 500
        }.start()
      }
      // animate and hide the highlight under the drop area
      DragEvent.ACTION_DRAG_ENDED -> {
        val bgColor = ContextCompat.getColor(view.context, R.color.colorWhiteTransparent)
        if (view.background is ColorDrawable && (view.background as ColorDrawable).color == Color.TRANSPARENT) return true

        ValueAnimator.ofArgb(bgColor, Color.TRANSPARENT).apply {
          addUpdateListener {
            val color = it.animatedValue as Int
            view.setBackgroundColor(color)
          }
          duration = 500
        }.start()
      }
      // when item has been dropped, notify about it
      DragEvent.ACTION_DROP -> onDrop()
    }

    return true
  }
}
