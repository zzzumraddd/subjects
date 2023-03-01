package uz.itschool.martbir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import uz.itschool.martbir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subject = arrayListOf<String>("cs", "maths", "english")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subject)
        binding.spinner.adapter = adapter

//        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(this@MainActivity, subject.get(position), Toast.LENGTH_LONG).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }

        binding.button.setOnClickListener {
            val s = subject.get(binding.spinner.selectedItemPosition)
           // Log.d("TAG", "onItemSelected: "+s)
            Log.d("TAG", subject.get(binding.spinner.selectedItemPosition))
            Toast.makeText(this@MainActivity, subject.get(binding.spinner.selectedItemPosition), Toast.LENGTH_LONG).show()
        }
        binding.autoComplete.setAdapter(adapter)

    }
}