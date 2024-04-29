import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tema1_android.Animal
import com.example.tema1_android.R
import com.example.tema1_android.animals

class AnimalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal, container, false)
        val animalsContainer: LinearLayout = view.findViewById(R.id.animalsContainer)

        for (animal in animals) {
            val animalView = createAnimalView(animal)
            animalsContainer.addView(animalView)
        }

        return view
    }

    private fun createAnimalView(animal: Animal): View {
        val context = requireContext()
        val padding = resources.getDimensionPixelSize(R.dimen.padding)
        val textColor = if (animal.continent in listOf("Europe", "Asia", "North America", "Australia", "Antarctica")) {
            context.getColor(android.R.color.white)
        } else {
            context.getColor(android.R.color.black)
        }

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val animalView = LinearLayout(context)
        animalView.orientation = LinearLayout.VERTICAL
        animalView.layoutParams = layoutParams
        animalView.setPadding(padding, padding, padding, padding)

        val nameTextView = TextView(context)
        nameTextView.text = animal.name
        nameTextView.setTextColor(textColor)
        nameTextView.textSize = resources.getDimension(R.dimen.text_size)
        animalView.addView(nameTextView)

        if (animal.continent == "Africa" || animal.continent == "South America" || animal.continent == "Antarctica") {
            val dividerView = View(context)
            val dividerHeight = resources.getDimensionPixelSize(R.dimen.divider_height)
            dividerView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dividerHeight)
            dividerView.setBackgroundColor(context.getColor(android.R.color.black))
            animalView.addView(dividerView)
        }

        val continentTextView = TextView(context)
        continentTextView.text = animal.continent
        continentTextView.setTextColor(textColor)
        continentTextView.textSize = resources.getDimension(R.dimen.text_size)
        animalView.addView(continentTextView)

        return animalView
    }
}
