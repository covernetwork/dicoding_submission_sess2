package com.example.mydicodingsubmissionsession2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var animalListContainer: RecyclerView
    private val list = ArrayList<Animal>()

    private fun getData(): ArrayList<Animal> {
        val dataName = resources.getStringArray((R.array.data_name))
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val animalList = ArrayList<Animal>()
        for (i in dataName.indices) {
            animalList.add(Animal(dataName[i], dataDescription[i], dataPhoto[i]))
        }
        return animalList
    }

    private fun showAnimalSelected(animal: Animal) {
        Toast.makeText(this, "kamu memilih ${animal.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animalListContainer = findViewById(R.id.animal_list_container)
        animalListContainer.setHasFixedSize(true)

        list.addAll((getData()))
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_list_view -> {
                animalListContainer.layoutManager = LinearLayoutManager(this)
            }

            R.id.change_grid_view -> {
                animalListContainer.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        animalListContainer.layoutManager = LinearLayoutManager(this)
        val listAnimalAdapter = ListAnimalAdapter(list)
        animalListContainer.adapter = listAnimalAdapter

        listAnimalAdapter.setOnItemClickCallback(object : ListAnimalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Animal) {
                showAnimalSelected(data)
            }
        })
    }

}