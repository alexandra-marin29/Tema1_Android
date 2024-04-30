package com.example.tema1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.graphics.Color
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class AnimalDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_details, container, false)

        val name = arguments?.getString("name") ?: "Unknown"
        val continent = arguments?.getString("continent") ?: "Unknown"
        val color = getContinentColor(continent)

        val nameTextView = view.findViewById<TextView>(R.id.animal_name)
        nameTextView.text = name
        nameTextView.setTextColor(if (continent in listOf("Europe", "Asia", "North America", "Australia", "Antarctica")) {
            Color.WHITE
        } else {
            Color.BLACK
        })

        val continentTextView = view.findViewById<TextView>(R.id.animal_continent)
        continentTextView.text = continent
        continentTextView.setTextColor(if (continent in listOf("Europe", "Asia", "North America", "Australia", "Antarctica")) {
            Color.WHITE
        } else {
            Color.BLACK
        })

        view.setBackgroundColor(color)

        val layout = view.findViewById<LinearLayout>(R.id.details_layout)
        layout.orientation = LinearLayout.VERTICAL

        val continentLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val continentView = TextView(requireContext())
        continentView.text = continent
        continentView.setTextColor(if (continent in listOf("Europe", "Asia", "North America", "Australia", "Antarctica")) {
            Color.WHITE
        } else {
            Color.BLACK
        })

        return view
    }

    private fun getContinentColor(continent: String): Int {
        return when (continent) {
            "Europe" -> Color.parseColor("#008000") // Green
            "Africa" -> Color.parseColor("#FFFF00") // Yellow
            "Asia" -> Color.parseColor("#FF0000") // Red
            "North America" -> Color.parseColor("#A52A2A") // Brown
            "South America" -> Color.parseColor("#FFA500") // Orange
            "Australia" -> Color.parseColor("#00008B") // Dark Blue
            "Antarctica" -> Color.parseColor("#00719B") // Light Blue
            else -> Color.GRAY
        }
    }
}
