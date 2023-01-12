import com.example.adapter.Affirmation

class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
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
}