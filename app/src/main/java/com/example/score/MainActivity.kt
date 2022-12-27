package com.example.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.score.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.ivChPass.visibility =View.INVISIBLE
        binding.ivEhPass.visibility =View.INVISIBLE
        binding.ivMathPass.visibility =View.INVISIBLE
        binding.btCk.setOnClickListener {
            check(binding.etCH.text.toString().toInt(),binding.ivChPass)
            check(binding.etEH.text.toString().toInt(),binding.ivEhPass)
            check(binding.etMath.text.toString().toInt(),binding.ivMathPass)
            binding.textView.requestFocus()
        }
        binding.etCH.setOnFocusChangeListener { view, b ->
            if (b) binding.ivChPass.visibility =View.INVISIBLE
        }
        binding.etEH.setOnFocusChangeListener { view, b ->
            if (b) binding.ivEhPass.visibility =View.INVISIBLE
        }
        binding.etMath.setOnFocusChangeListener { view, b ->
            if (b) binding.ivMathPass.visibility =View.INVISIBLE
        }
    }
    private fun check(Score:Int,iv:ImageView){
        if (Score>=60){
            iv.setImageResource(R.drawable.ic_ok)
        }
        else{
            iv.setImageResource(R.drawable.ic_fail)
        }
        iv.visibility =View.VISIBLE
    }
}