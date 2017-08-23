package com.evan.designpatterns.activitys

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.evan.designpatterns.R

class Chapter3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter3)

    }

    fun popWindow(view: View) {

        val popwindow: PopupWindow = PopupWindow(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        popwindow.contentView = getTextView()

        val setLayoutInsetDecor = popwindow.javaClass.getMethod("setLayoutInsetDecor", Boolean::class.java)
        // 设置后会让PopWindow以屏幕的左上角坐标来计算，忽略状态的高度
        val setLayoutInScreenEnabled = popwindow.javaClass.getMethod("setLayoutInScreenEnabled", Boolean::class.java)

        setLayoutInsetDecor.invoke(popwindow, true)
        setLayoutInScreenEnabled.invoke(popwindow, true)

        popwindow.setTouchInterceptor hehe@{ v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                popwindow.dismiss()
            }
            return@hehe true
        }

        popwindow.setBackgroundDrawable(ColorDrawable(Color.parseColor("#999999")))


        popwindow.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0)
        val parent = popwindow.contentView.parent as View
        val root  = parent.parent as View
        println(" $parent ,  $root ")
        popwindow.contentView.rootView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))


    }

    fun getTextView() : TextView {
        val textView = TextView(this)
        textView.text = "Evan Test PopWindow"
        return textView
    }

    fun dialog(view: View){
        AlertDialog.Builder(this).setMessage("建造者模式")
                .show()
    }
}

