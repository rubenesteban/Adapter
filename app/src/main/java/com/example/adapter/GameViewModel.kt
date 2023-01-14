package com.example.adapter

import Datasource
import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.*
import com.example.adapter.Data.GameUiState
import com.example.adapter.ui.WellnesTaskList
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel() : ViewModel() {

   private val _uiState = MutableStateFlow(GameUiState())
   val uiState: StateFlow<GameUiState> =_uiState.asStateFlow()

    private var UsaWord: Set<String> = getallWords().toMutableSet()
    private var Words: MutableSet<String> = mutableSetOf<String>("")
    private var Work: MutableSet<String> = mutableSetOf<String>("")
    private var Trabajo: MutableSet<String> = mutableSetOf<String>("")
    private var Fulliy: MutableSet<String> = mutableSetOf<String>("")
    private var Marcot: MutableSet<String> = mutableSetOf<String>("")
    private var Polo: MutableSet<String> = mutableSetOf<String>("")
    private var Roma: MutableSet<String> = mutableSetOf<String>("")


    private lateinit var currentTask:String
    private lateinit var Task:String
    private lateinit var tull:String
    var pass:Boolean = true
    var tren:Boolean = false
    private  val TAG: String = "UserPref"


    //--------------------------
    private val _tasks = loadAffirmations().toMutableStateList()
    val tasks: List<Affirmation>
    get() = _tasks
    //_________________________________________________
    //--------------------------
    private val _wrap = getWellnessTasks().toMutableStateList()
    val wrap: List<WellnessTask>
        get() = _wrap
    //_________________________________________________

    //--------------------------
    private val _punto = traeMixelPunto().toMutableStateList()
    val punto: MutableList<Mixtel>
        get() = _punto
    //_________________________________________________


    var again: List<Mixtel> = listOf<Mixtel>().toMutableStateList()
    var futher: List<Mixtel> = listOf<Mixtel>().toMutableStateList()
    var ipiales: List<Mixtel> = listOf<Mixtel>().toMutableStateList()
    var gol: List<Affirmation> = listOf<Affirmation>().toMutableStateList()
    var aro: List<WellnessTask> = listOf<WellnessTask>().toMutableStateList()
    var rectangulo: List<Mixtel> = listOf<Mixtel>().toMutableStateList()
    lateinit var libre: List<Affirmation>
    lateinit var ocupado: List<WellnessTask>
    lateinit var apple: List<Mixtel>
    lateinit var toronja: List<WellnessTask>
    lateinit var naranja: List<Mixtel>
    lateinit var pera: List<Mixtel>
    lateinit var pina: List<Mixtel>
    lateinit var platano: List<Mixtel>
    lateinit var mas: MutableSet<String>
    lateinit var holdirt: MutableSet<String>
    lateinit var neco: String


    fun remove(item: Affirmation){
        _tasks.remove(item)
        //gult(item)
    }

    fun remove(item: WellnessTask){
        _wrap.remove(item)
        //gult(item)
    }
    fun remove(item: Mixtel){
        _punto.remove(item)
        //gult(item)
    }


    suspend fun miercoles():List<Mixtel>{
        rectangulo = listOf(punto.random());
        futher = listOf(punto.random());
        ipiales = listOf(punto.random());
        again = listOf(punto.random());
        again = again + rectangulo + futher + ipiales
        return again
    }
//------------Addclose
    fun gult(item:Affirmation):List<Mixtel>{
         pina = waffers(item)
        naranja = punto + pina
        return naranja

    }

    fun gilf(item:Mixtel):MutableSet<String>{
        again = listOf(punto.random())
        neco = _punto.add(item).toString()
        mas.add(neco)
        return mas

    }

    fun golf(item:WellnessTask):MutableSet<String>{
        aro = listOf(wrap.random())
        neco = _wrap.add(item).toString()
        holdirt.add(neco)
        return holdirt

    }


    fun waffers(item: Affirmation): List<Mixtel>{
        apple = _tasks.add(item) as List<Mixtel>
        return apple
    }



    //-----------------------




    init {

        resetGame()
       // rectangulo = listOf(punto.random());
        //Skott()
       // ananir()

            //miercoles()


    }

    suspend fun ananir() {
        again = punto + rectangulo
        print( again )
    }




    fun main(){
        again = punto + rectangulo
        println(again)
    }

    suspend fun Skott() {
        viewModelScope.launch {
            ananir()
        }
    }

private fun traeMixelPunto() : MutableList<Mixtel>{
        return listOf<Mixtel>(
            Mixtel(111, "Martha"),
            Mixtel(112, "Manta"),
            Mixtel(116, "Hugo"),
        ) as MutableList<Mixtel>
}



    fun resetGame() {
        Words.clear()
        Work.clear()
        Trabajo.clear()
       //_uiState.value = GameUiState(usedCards = Work)
    }

}


fun main(){
    prueba()
}
fun prueba(){
    for(i in 1..5){
        print(i)
    }
}

data class Mixtel(val id: Int, val label: String)
data class WellnessTask(val id: Int, val label: String)
data class Affirmation(val id: Int, val label: String)

private fun getWellnessTasks() = List(3){i ->WellnessTask(i, "Task # $i")}
private fun loadAffirmations(): List<Affirmation> {
    return listOf<Affirmation>(
        Affirmation(1, "R.image11"),
        Affirmation(2, "R.image12"),
        Affirmation(3, "R.image13"),
        Affirmation(4, "R.image14"),
        Affirmation(5, "R.image15"),
        Affirmation(6, "R.image16"),
        Affirmation(7, "R.image17"),
        Affirmation(8, "R.image18"),
        Affirmation(9, "R.image19"),
        Affirmation(10, "R.image10"))
}




private fun getallWords(): Set<String> =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        "best",
        "birthday",
        "book",
        "briefcase",
        "camera",
        "camping",
        "candle",
        "cat",
        "cauliflower",
        "chat",
        "children",
        "class",
        "classic",
        "classroom",
        "tasa",
        "foco",
        "athantis")
