package com.tlu.esimenerakendus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    lateinit var discImage: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //K6ik muu
        discImage = view.findViewById(R.id.dice_image)
        val rollButton: Button = view.findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        // Example of a call to a native method
        //sample_text.text = randomDice().toString()
    }

    private fun rollDice() {
        //sample_text.text = randomDice().toString()
        //Toast.makeText(this, randomDice().toString(), Toast.LENGTH_SHORT).show()
        val drawResource = when (randomDice()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        discImage.setImageResource(drawResource)

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun randomDice(): Int

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

}
