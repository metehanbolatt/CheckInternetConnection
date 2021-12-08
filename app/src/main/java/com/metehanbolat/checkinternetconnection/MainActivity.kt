package com.metehanbolat.checkinternetconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.metehanbolat.checkinternetconnection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this){ isConnected ->
            if (isConnected){
                binding.layoutDisconnected.visibility = View.GONE
                binding.layoutConnected.visibility = View.VISIBLE
            }else{
                binding.layoutDisconnected.visibility = View.VISIBLE
                binding.layoutConnected.visibility = View.GONE
            }
        }
    }
}