package com.robertlevonyan.demo.dragndrop.callback

import android.view.DragEvent
import android.view.View

/**
 * Callback for the draggable view to update it's visibility
 * */
class DragListener : View.OnDragListener {
  override fun onDrag(view: View, dragEvent: DragEvent): Boolean {
    when (dragEvent.action) {
      // hide view when drag has been started
      DragEvent.ACTION_DRAG_ENTERED -> view.visibility = View.INVISIBLE
      // show view when drag has been ended
      DragEvent.ACTION_DRAG_ENDED -> view.visibility = View.VISIBLE
    }

    return true
  }
}
