package com.clau.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUno.setOnClickListener { appendOnExpresstion("1",true) }
        tvDos.setOnClickListener { appendOnExpresstion("2",true) }
        tvTres.setOnClickListener { appendOnExpresstion("3",true) }
        tvCuatro.setOnClickListener { appendOnExpresstion("4",true) }
        tvCinco.setOnClickListener { appendOnExpresstion("5",true) }
        tvSeis.setOnClickListener { appendOnExpresstion("6",true) }
        tvSiete.setOnClickListener { appendOnExpresstion("7",true) }
        tvOcho.setOnClickListener { appendOnExpresstion("8",true) }
        tvNueve.setOnClickListener { appendOnExpresstion("9",true) }
        tvCero.setOnClickListener { appendOnExpresstion("0",true) }
        tvPunto.setOnClickListener { appendOnExpresstion(".",true) }

        tvSuma.setOnClickListener { appendOnExpresstion("+", false) }
        tvMenos.setOnClickListener { appendOnExpresstion("-", false) }
        tvMulti.setOnClickListener { appendOnExpresstion("*", false) }
        tvDiv.setOnClickListener { appendOnExpresstion("/", false) }
        tvPar1.setOnClickListener { appendOnExpresstion("(", false) }
        tvPar2.setOnClickListener { appendOnExpresstion(")", false) }

        tvBorrar.setOnClickListener {
            tvExpresion.text = ""
            tvResultado.text = ""}
        tvBorrado.setOnClickListener {
            val string = tvExpresion.text.toString()
            if(string.isNotEmpty()){
                tvExpresion.text = string.substring(0,string.length-1)
            }
            tvResultado.text = ""
        }
        tvIgual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpresion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResultado.text = longResult.toString()
                else
                    tvResultado.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception","mensaje :" + e.message)
            }
        }




    }
    fun appendOnExpresstion(string: String, canClear : Boolean){

        if(tvResultado.text.isNotEmpty()){
            tvExpresion.text = ""
        }
        if(canClear){
            tvResultado.text = ""
            tvExpresion.append(string)
        }else{
            tvExpresion.append(tvResultado.text)
            tvExpresion.append(string)
            tvResultado.text = ""
        }

    }
}