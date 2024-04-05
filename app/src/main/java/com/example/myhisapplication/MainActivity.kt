package com.example.myhisapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var generateButton: Button
    private lateinit var clearButton: Button
    private lateinit var feedbackTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set title for the activity
        title = "The History App"

        ageInput = findViewById(R.id.age_input)
        generateButton = findViewById(R.id.generate_button)
        clearButton = findViewById(R.id.clear_button)
        feedbackTextView = findViewById(R.id.text_view)

        // Click listener for generateButtonF
        generateButton.setOnClickListener {
            val ageStr = ageInput.text.toString().trim()

            // Check if the input age is empty
            if (ageStr.isEmpty()) {
                showError("Please enter an age.")
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null) {

                // Show error if input age is not a valid integer
                showError("Invalid age. Please enter a valid integer.")
                return@setOnClickListener
            }

            // Check if the input age is within the range 20 to 100
            if (age !in 20..100) {
                showError("The age is out of range.")
                return@setOnClickListener
            }

            // Get the name of the historical figure who died at the input age
            val person = getPersonByAge(age)
            feedbackTextView.text = "A famous person who passed away at the age of $age was $person."
        }

        // Click listener for clearButton
        clearButton.setOnClickListener {
            // Clear the feedbackTextView and ageInput
            feedbackTextView.text = ""
            ageInput.text.clear()
        }
    }

    // Function to display an error message in an AlertDialog
    private fun showError(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

    // Function to get the name of the historical figure who died at the given age
    private fun getPersonByAge(age: Int): String {
        val people = mapOf(
            // Mapping ages to historical figures
            95 to "Nelson Mandela",
            52 to "William Shakespeare",
            55 to "Christopher Columbus",
            76 to "Albert Einstein",
            73 to "Charles Darwin",
            64 to "Karl Marx",
            39 to "Martin Luther King Jr",
            84 to "Isaac Newton",
            81 to "Queen Victoria",
            83 to "Thomas Jefferson",
            32 to "Alexander the Great",
            35 to "Wolfgang Amadeus Mozart",
            39 to "Bob Hope",
            25 to "John Keats",
            40 to "Edgar Allan Poe",
            37 to "Vincent van Gogh",
            27 to "Jimi Hendrix",
            30 to "Sylvia Plath",
            77 to "Galileo Galilei",
            67 to "Leonardo da Vinci",
            88 to "Michelangelo",
            100 to "Winston Churchill",
            87 to "Mother Teresa",
            50 to "Julius Caesar",
            51 to "Anne Frank",
            54 to "Abraham Lincoln",
            55 to "Helen Keller",
            56 to "Amelia Earhart",
            57 to "Mark Twain",
            60 to "Pablo Picasso",
            64 to "George Orwell",
            70 to "Marie Curie",
            76 to "Frederick Douglass",
            77 to "Thomas Edison",
            80 to "Walt Disney",
            82 to "Benjamin Franklin",
            84 to "Winston Churchill",
            86 to "Albert Schweitzer",
            90 to "Pierre-Auguste Renoir",
            91 to "Rosa Parks",
            97 to "Charlie Chaplin"
        )
        // Return the name of the historical figure, or "Unknown" if not found
        return people[age] ?: "Unknown"
    }
}


