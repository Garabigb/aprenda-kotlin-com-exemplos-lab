// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class DegreeKnowledgde { BASIC, INTERMEDIARY, ADVANCED}

data class User(var name: String, val id: Int)

data class EducationContent(var name: String, val duration: Int = 60)

data class Formation(val name: String, val degree: DegreeKnowledgde, var contents: List<EducationContent>) {

    val subscribed = mutableSetOf<User>()

    fun enroll(vararg users: User) {
        subscribed.addAll(users)
    }

    fun showSubscribed(){
        subscribed.forEach{println(it)}
    }

}

fun thereAnEqual(formation1: Formation, formation2: Formation) {
    var formationLead: Formation? = null
    formationLead = if (formation1.subscribed.size < formation2.subscribed.size){
        formation1
    }else{
        formation2
    }
    for (sub in formationLead.subscribed){
        if(formation2.subscribed.contains(sub))
            println("${sub.name} is making  ${formation1.name} and ${formation2.name}")
    }

}


fun main() {

    val user1 = User("Gabriel", 0)
    val user2 = User("Maria", 1)
    val user3 = User("João", 2)
    val user4 = User("Silvana", 3)
    val user5 = User("Luiza", 4)
    val user6 = User("Carlos", 5)

    val content1 = EducationContent("English")
    val content2 = EducationContent("Application Math", 140)
    val content3 = EducationContent("Data Base")
    val content4 = EducationContent("introduction to informatics")
    val content5 = EducationContent("introduction to programing")
    val content6 = EducationContent("Java")

    val formation1 = Formation("Basic English", DegreeKnowledgde.BASIC, listOf(content1))
    formation1.enroll(user1, user2, user3, user6)

    val formation2 = Formation("Informatics basic", DegreeKnowledgde.BASIC, listOf(content4, content5))
    formation2.enroll(user1, user2, user3, user4, user5, user6)

    val formation3 = Formation("informatics intermediary", DegreeKnowledgde.INTERMEDIARY, listOf(content6))
    formation3.enroll(user4, user5, user6)

    val formation4 = Formation("informatics advanced", DegreeKnowledgde.ADVANCED, listOf(content3, content2))
    formation4.enroll(user6)

    formation3.showSubscribed()
    formation3.enroll(user4)
    formation3.showSubscribed()
    formation3.enroll(user1)

    thereAnEqual(formation3, formation2)









    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
