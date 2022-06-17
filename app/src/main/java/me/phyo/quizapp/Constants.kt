package me.phyo.quizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val CORRECT_ANSWERS:String="correct_answer"
    const val TOTAL_QUESTIONS:String="total_questions"

    fun getQuestions():ArrayList<Question>{
        val questions = ArrayList<Question>()

        val que1 = Question(1,"Who dis?",R.drawable.ic_chuu,"Chuu","Sana","Jennie","Ryujin",1)
        questions.add(que1)
        val que2 = Question(2,"Who dis?",R.drawable.ic_hwasa,"Karina","Dahyun","Hwasa","Hyunjin",3)
        questions.add(que2)
        val que3 = Question(3,"Who dis?",R.drawable.ic_iu,"Lisa","IU","Yeji","Sana",2)
        questions.add(que3)
        val que4 = Question(4,"Who dis?",R.drawable.ic_hyewon,"Sana","Yves","Joy","Hyewon",4)
        questions.add(que4)
        val que5 = Question(5,"Who dis?",R.drawable.ic_jennie,"Jennie","Somi","Yuna","Haewon",1)
        questions.add(que5)
        val que6 = Question(6,"Who dis?",R.drawable.ic_jinsoul,"Ryujin","Tzuyu","Jinsoul","Jisoo",3)
        questions.add(que6)
        val que7 = Question(7,"Who dis?",R.drawable.ic_karina,"Heejin","Jihyo","Karina","Irene",3)
        questions.add(que7)
        val que8 = Question(8,"Who dis?",R.drawable.ic_ryujin,"Jennie","Ryujin","Mina","Solar",2)
        questions.add(que8)
        val que9 = Question(9,"Who dis?",R.drawable.ic_tzuyu,"Jennie","Ryujin","Tzuyu","Sana",3)
        questions.add(que9)
        val que10 = Question(10,"Who dis?",R.drawable.ic_wendy,"MoMo","Wendy","Ryujin","Olivia Hye",2)
        questions.add(que10)

        return questions
    }
}