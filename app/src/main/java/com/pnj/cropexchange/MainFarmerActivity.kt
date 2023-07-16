package com.pnj.cropexchange

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.pnj.cropexchange.farmer.Farmer
import com.pnj.cropexchange.farmer.FarmerAdapter



class MainFarmerActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var editTextSearchFarmer: EditText
    private lateinit var recyclerViewFarmers: RecyclerView
    private lateinit var farmerAdapter: FarmerAdapter
    private lateinit var farmers: MutableList<Farmer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_farmer_activity)

        db = FirebaseFirestore.getInstance()
        editTextSearchFarmer = findViewById(R.id.editTextSearchFarmer)
        recyclerViewFarmers = findViewById(R.id.recyclerViewFarmers)
        farmers = mutableListOf()

        farmerAdapter = FarmerAdapter(farmers)
        recyclerViewFarmers.adapter = farmerAdapter
        recyclerViewFarmers.layoutManager = LinearLayoutManager(this)

        // Retrieve all farmers from Firestore
        db.collection("farmers")
            .get()
            .addOnSuccessListener { querySnapshot ->
                farmers.clear()
                for (document in querySnapshot) {
                    val farmer = document.toObject(Farmer::class.java)
                    farmers.add(farmer)
                }
                farmerAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                // Error occurred while retrieving farmers
                // Handle the error appropriately
            }

        editTextSearchFarmer.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterFarmers(s.toString().trim())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterFarmers(query: String) {
        val filteredFarmers = farmers.filter {
            it.name.contains(query, true) ||
                    it.location.contains(query, true) ||
                    it.product.contains(query, true)
        }
        farmerAdapter = FarmerAdapter(filteredFarmers)
        recyclerViewFarmers.adapter = farmerAdapter
    }
}
