package calculadora_simples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.atividade2.R

class MainActivity : AppCompatActivity() {


    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var btSoma: Button
    private lateinit var btSubtracao: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        btSoma = findViewById(R.id.btSoma)
        btSubtracao = findViewById(R.id.btSubtracao)
        tvResultado = findViewById(R.id.tvResultado)


        btSoma.setOnClickListener {
            calcularResultado(true)
        }


        btSubtracao.setOnClickListener {
            calcularResultado(false)
        }
    }


    private fun calcularResultado(operacaoSoma: Boolean) {

        val numero1Str = etNumero1.text.toString()
        val numero2Str = etNumero2.text.toString()


        if (numero1Str.isNotEmpty() && numero2Str.isNotEmpty()) {

            val numero1 = numero1Str.toDouble()
            val numero2 = numero2Str.toDouble()


            val resultado = if (operacaoSoma) {
                numero1 + numero2
            } else {
                numero1 - numero2
            }


            tvResultado.text = resultado.toString()
        } else {

            tvResultado.text = "Por favor, insira ambos os números"
        }
    }
}