package com.example.kharkov.radioant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit private var butt1: Button
    lateinit private var butt2: Button
    lateinit private var butt3: Button
    lateinit private var butt4: Button
    lateinit private var butt5: Button
    lateinit private var butt6: Button

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button1 -> {
                val intent1 = Intent(this, Radio::class.java)
                intent1.putExtra("site",RadioEnum.KissFM.url)
                intent1.putExtra("image",R.drawable.kiss)
                startActivity(intent1)
            }
            R.id.button2->{
                val intent2= Intent(this,Radio::class.java)
                intent2.putExtra("site",RadioEnum.HitFM.url)
                intent2.putExtra("image",R.drawable.hit)
                startActivity(intent2)
            }
            R.id.button3->{
                val intent3= Intent(this,Radio::class.java)
                intent3.putExtra("site",RadioEnum.RadioROKS.url)
                intent3.putExtra("image",R.drawable.rocks)
                startActivity(intent3)
            }
            R.id.button4->{
                val intent4= Intent(this,Radio::class.java)
                intent4.putExtra("site",RadioEnum.MelodiaFM.url)
                intent4.putExtra("image",R.drawable.melodia)
                startActivity(intent4)
            }
            R.id.button5->{
                val intent5= Intent(this,Radio::class.java)
                intent5.putExtra("site",RadioEnum.RadioRelax.url)
                intent5.putExtra("image",R.drawable.relax)
                startActivity(intent5)
            }
            R.id.button6->{
                val intent6= Intent(this,Radio::class.java)
                intent6.putExtra("site",RadioEnum.RusRadio.url)
                intent6.putExtra("image",R.drawable.rus)
                startActivity(intent6)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butt1=findViewById<Button>(R.id.button1) as Button
        butt1.setOnClickListener(this)

        butt2=findViewById<Button>(R.id.button2) as Button
        butt2.setOnClickListener(this)

        butt3=findViewById<Button>(R.id.button3) as Button
        butt3.setOnClickListener(this)


        butt4=findViewById<Button>(R.id.button4) as Button
        butt4.setOnClickListener(this)

        butt5=findViewById<Button>(R.id.button5) as Button
        butt5.setOnClickListener(this)

        butt6=findViewById<Button>(R.id.button6) as Button
        butt6.setOnClickListener(this)
    }
}
