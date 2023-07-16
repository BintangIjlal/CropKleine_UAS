package com.pnj.cropexchange.farmer

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.pnj.cropexchange.R
import com.pnj.cropexchange.farmer.Farmer

class AddFarmerActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var editTextFarmerName: EditText
    private lateinit var editTextLocation: EditText
    private lateinit var editTextProduct: EditText
    private lateinit var buttonAddFarmer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_farmer_activity)

        db = FirebaseFirestore.getInstance()
        editTextFarmerName = findViewById(R.id.editTextFarmerName)
        editTextLocation = findViewById(R.id.editTextLocation)
        editTextProduct = findViewById(R.id.editTextProduct)
        buttonAddFarmer = findViewById(R.id.buttonAddFarmer)

        buttonAddFarmer.setOnClickListener {
            val name = editTextFarmerName.text.toString().trim()
            val location = editTextLocation.text.toString().trim()
            val product = editTextProduct.text.toString().trim()

            val farmer = Farmer("", name, location, product, null) // Generate a unique ID for farmerId field

            // Add the farmer to Firestore
            db.collection("farmers")
                .add(farmer)
                .addOnSuccessListener {
                    // Farmer added successfully
                    // You can perform any necessary actions here
                }
                .addOnFailureListener { e ->
                    // Error occurred while adding farmer
                    // Handle the error appropriately
                }
        }
    }
}
