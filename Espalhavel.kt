public interface Espalhavel {

    fun adicionar(mapa: Mapa)

    fun remover(chave: Any): Any?

    fun contemChave(chave: Any): Boolean

    fun buscar(chave: Any): Any?




    fun estaVazia(): Boolean

    fun imprimir(): String

    fun tamanho(): Int
}
