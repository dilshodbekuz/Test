package com.example.android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.transition.Slide
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.example.android.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import androidx.recyclerview.widget.ItemTouchHelper as ItemTouchHelper

class MainActivity : AppCompatActivity() {
    private lateinit var product: ArrayList<Product>
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadProduct()
        val productAdapter = ProductAdapter(product)
        binding.rv.adapter = productAdapter
        binding.rv.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))


        binding.floatingAction.setOnClickListener {
            val build = AlertDialog.Builder(this)
            val dialogView = LayoutInflater.from(this).inflate(R.layout.diolog,null,false)
            val name = dialogView.findViewById<TextInputEditText>(R.id.name)
            val price = dialogView.findViewById<TextInputEditText>(R.id.price)
            val desc = dialogView.findViewById<TextInputEditText>(R.id.desc)

            build.setView(dialogView)
            build.setPositiveButton("save",DialogInterface.OnClickListener { dialog, which ->
                product.add(Product(R.drawable.ic_launcher_foreground,name.text.toString(),price.text.toString().toInt(),desc.text.toString()))

                productAdapter.notifyDataSetChanged()
                binding.rv.smoothScrollToPosition(product.size)
            })

            build.show()

        }

        with(binding) {
            rv.adapter = productAdapter
            rv.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))


            floatingAction.setOnClickListener {
                val build = AlertDialog.Builder(this@MainActivity)
                val dialogView = LayoutInflater.from(this@MainActivity).inflate(R.layout.diolog,null,false)
                val name = dialogView.findViewById<TextInputEditText>(R.id.name)
                val price = dialogView.findViewById<TextInputEditText>(R.id.price)
                val desc = dialogView.findViewById<TextInputEditText>(R.id.desc)

                build.setView(dialogView)
                build.setPositiveButton("save",DialogInterface.OnClickListener { dialog, which ->
                    product.add(Product(R.drawable.ic_launcher_foreground,name.text.toString(),price.text.toString().toInt(),desc.text.toString()))

                    productAdapter.notifyDataSetChanged()
                    rv.smoothScrollToPosition(product.size)
                })
                build.show()

            }
        }
    }


    private fun loadProduct() {
        product = ArrayList()
        product.add(Product(R.drawable.image, "Salom", 100,""))
        product.add(Product(R.drawable.image, "Salom", 100,""))
        product.add(Product(R.drawable.image, "gyfyt", 100,""))
        product.add(Product(R.drawable.image, "gyfyt", 100,""))
        product.add(Product(R.drawable.image, "gyfyt", 100,""))
    }
}