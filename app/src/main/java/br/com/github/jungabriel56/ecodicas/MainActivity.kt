import android.os.Bundle
import android.widget.EditText
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.github.jungabriel56.ecodicas.viewmodel.TipViewModelFactory
import br.com.github.jungabriel56.ecodicas.viewmodel.TipsAdapter
import br.com.github.jungabriel56.ecodicas.viewmodel.TipsViewModel
import carreiras.com.github.kotlin_android_lista_de_compras.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TipsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val toolbar: Toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val tipsAdapter = TipsAdapter { tip ->
            //viewModel.removeTip(tip)
        }
        recyclerView.adapter = tipsAdapter

       val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

           // viewModel.addTip(editText.text.toString())
            editText.text.clear()
        }

        val viewModelFactory = TipViewModelFactory(application)
        //viewModel = ViewModelProvider(this, viewModelFactory).get(TipsViewModel::class.java)

        //viewModel.itemsLiveData.observe(this) { items ->
            //tipsAdapter.updateItems(tips)
        }
    }

