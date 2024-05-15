package com.example.plantapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
@@ -9,73 +10,80 @@ import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewDog: ImageView
    //variables
    private lateinit var  imageViewPlant: ImageView
    private var health = 100
    private var hunger = 0
    private var cleanliness = 100
    private var water = 0
    private var sunlight = 100

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        imageViewDog = findViewById(R.id.imageViewDog)

        val buttonFeed = findViewById<Button>(R.id.buttonFeed)
        val buttonPlay = findViewById<Button>(R.id.buttonPlay)
        val buttonClean = findViewById<Button>(R.id.buttonClean)
        imageViewPlant = findViewById(R.id.imageViewPlant)

        val eatAnimation = AnimationUtils.loadAnimation(this, R.anim.dog_eat)
        val playAnimation = AnimationUtils.loadAnimation(this, R.anim.dog_play)
        val cleanAnimation = AnimationUtils.loadAnimation(this, R.anim.dog_clean)
        //buttons
        val buttonWater = findViewById<Button>(R.id.buttonWater)
        val buttonFertilize = findViewById<Button>(R.id.buttonFertilize)
        val buttonSun = findViewById<Button>(R.id.buttonSun)

        //changing animation
        val waterAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_water)
        val fertilizeAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_fertilize)
        val sunAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_sun)

        updateUI()

        buttonFeed.setOnClickListener {
            imageViewDog.startAnimation(eatAnimation)
            feedPet()
            buttonWater.setOnClickListener {
                imageViewPlant.startAnimation(waterAnimation)
                waterPlant()
                updateUI()
            }

            buttonPlay.setOnClickListener {
                imageViewDog.startAnimation(playAnimation)
                playWithPet()
                buttonFertilize.setOnClickListener {
                    imageViewPlant.startAnimation(fertilizeAnimation)
                    fertilizePlant()
                    updateUI()
                }

                buttonClean.setOnClickListener {
                    imageViewDog.startAnimation(cleanAnimation)
                    cleanPet()
                    buttonSun.setOnClickListener {
                        imageViewPlant.startAnimation(sunAnimation)
                        putPlantInSun()
                        updateUI()
                    }
                }

                private fun feedPet() {
                    hunger -= 10
                    if (hunger < 0) hunger = 0
                    if (cleanliness < 100) cleanliness += 5
                    //methods
                    private fun waterPlant() {
                        sunlight -= 5
                        if (water < 0) water = 0
                        if (water < 100) water += 10
                    }

                    private fun playWithPet() {
                        health += 10
                        if (health > 100) health = 100
                        hunger += 10
                        if (hunger > 100) hunger = 100
                        cleanliness -= 5
                        if (cleanliness < 0) cleanliness = 0
                        private fun fertilizePlant() {
                            health = 100
                        }

                        private fun cleanPet() {
                            cleanliness = 100
                            private fun putPlantInSun() {

                                health -= 10
                                if (health > 100) health = 100
                                sunlight += 10
                                if (water > 100) water = 100
                                water -= 5
                                if (sunlight < 0) sunlight = 0
                            }

                            private fun updateUI() {
                                val textViewHealth = findViewById<TextView>(R.id.textViewHealth)
                                val textViewHunger = findViewById<TextView>(R.id.textViewHunger)
                                val textViewCleanliness = findViewById<TextView>(R.id.textViewCleanliness)
                                val textViewHunger = findViewById<TextView>(R.id.textViewWater)
                                val textViewCleanliness = findViewById<TextView>(R.id.textViewSun)

                                textViewHealth.text = "Health: $health"
                                textViewHunger.text = "Hunger: $hunger"
                                textViewCleanliness.text = "Cleanliness: $cleanliness"
                                textViewHunger.text = "Water: $water"
                                textViewCleanliness.text = "Sun: $sunlight"
                            }
                        }

