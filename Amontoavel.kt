public interface Amontoavel {
    fun inserir(dado: Long)
    fun extrair():Long?
    fun obter():Long
    fun atualizar(dado:Long)

    fun imprimir():String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}
