
package com.rolax.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private val black = Color.BLACK
    private val white = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this)
        page.orientation = LinearLayout.VERTICAL
        page.setBackgroundColor(black)
        page.setPadding(20, 25, 20, 15)

        fun text(value: String, size: Float): TextView {
            return TextView(this).apply {
                text = value
                textSize = size
                setTextColor(white)
                setPadding(0, 10, 0, 10)
            }
        }

        val header = LinearLayout(this)
        header.gravity = Gravity.CENTER_VERTICAL

        val logo = text("ROLAX", 28f)
        logo.setTypeface(null, 1)
        header.addView(logo)

        val profile = Button(this)
        profile.text = "حسابي"
        profile.setOnClickListener { toast("صفحة الحساب قريباً") }
        header.addView(profile)

        page.addView(header)

        page.addView(text("اكتشف عوالم جديدة", 23f))

        val search = EditText(this)
        search.hint = "ابحث عن لعبة..."
        search.setSingleLine(true)
        search.setTextColor(white)
        search.setHintTextColor(Color.LTGRAY)
        page.addView(search)

        page.addView(text("⭐ عالم مميز", 21f))

        val featured = Button(this)
        featured.text = "استكشف العالم"
        featured.setOnClickListener { toast("العوالم ثلاثية الأبعاد قيد التطوير") }
        page.addView(featured)

        page.addView(text("الألعاب المقترحة", 21f))

        val games = listOf(
            "🏙️ مدينة المغامرات",
            "🏝️ جزيرة البقاء",
            "🚀 سباق الفضاء",
            "🏰 عالم الأبطال"
        )

        for (game in games) {
            val item = Button(this)
            item.text = game
            item.textSize = 17f
            item.setOnClickListener { toast("اللعبة قيد التطوير") }
            page.addView(item)
        }

        page.addView(text("الرئيسية     اكتشف     إنشاء     شخصيتي", 16f))

        setContentView(page)
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
